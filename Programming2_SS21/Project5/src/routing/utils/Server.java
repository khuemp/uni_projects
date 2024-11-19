package routing.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import routing.Coordinate;
import routing.Factory;
import routing.Graph;
import routing.Node;
import routing.NodeFinder;
import routing.Route;
import routing.RoutingAlgorithm;
import routing.RoutingAlgorithm.NoSuchRouteException;
import routing.TravelType;

public class Server {

	/**
	 * If true, keep the server open until the program is shut down (e.g., by
	 * the red square in the console window of eclipse).
	 */
	static final boolean LISTEN_FOREVER = true;

	/**
	 * The file of the map/graph the routes are computed on. Possible choices
	 * are: campus.osm.nae saarbruecken.osm.nae saarland.osm.nae
	 */
	static final String MapFilename = "campus.osm.nae";

	/**
	 * The port the server is listening on.
	 */
	static final int PORT = 22222;

	/**
	 * Prune the navigation graph after specializing it.
	 */
	static final boolean PruneGraph = true;

	/**
	 * Specialize the navigation graph to this travel type (null means don't).
	 */
	static final TravelType SpecializedTT = TravelType.ANY;

	/**
	 * Main entry point for the server program.
	 */
	public static void main(String[] args) {
		Server server = null;

		try {
			server = new Server();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println("\n\nERROR:  Could not open the graph file @ '"
					+ MapFilename + "'");
			return;
		}

		try {
			server.openSocket();
		} catch (IOException e) {
			e.printStackTrace();
			System.err
			.println("\n\nERROR:  Could not open server on port "
					+ PORT
					+ ".\n\tPlease try a similar but different port and ask for help only if the problem persists!"
					+ "\n\tIn case you post the problem, please attach the stack trace that was printed above this message!");
			return;
		}

		if (!server.isValid()) {
			System.err
			.println("\n\nWARNING: Could not open a server (hopefully there is an error message above this one).");
			return;
		}

		System.out
		.println("\n\nINFO: The server is listening on: http://127.0.0.1:"
				+ PORT);

		try {
			do {
				server.acceptConnections();
			} while (LISTEN_FOREVER);
		} catch (IOException e) {
			e.printStackTrace();
			System.err
			.println("\n\nWARNING:  Server was should down due to an Exception.");
		} finally {
			server.closeSocket();
		}
		return;
	}

	/**
	 * The graph constructed for the map identified by MapFilename.
	 */
	private final Graph graph;

	/**
	 * The node finder to get node OSM id's from coordinates.
	 */
	private final NodeFinder nf;

	/**
	 * The routing algorithm used to compute routes.
	 */
	private final RoutingAlgorithm ra;

	/**
	 * The socket of this server to communicate with the frontend.
	 */
	private ServerSocket serverSocket = null;

	/**
	 * A stop watch to measure the time it took to compute the route.
	 */
	private final Stopwatch sw = new Stopwatch();

	Server() throws IOException {
		System.out.println("INFO: Start a new server.");

		System.out.println("INFO: Read the map file (" + MapFilename
				+ ") and build graph.");
		graph = Factory.createGraphFromMap(MapFilename);
		graph.removeIsolatedNodes();

		System.out.println("INFO: Create routing algorithm.");
		ra = Factory.createRoutingAlgorithm(graph);

		if (SpecializedTT != null) {
			System.out.println("INFO: Specialize the graph to "
					+ SpecializedTT.name());
			graph.removeUntraversableEdges(ra, SpecializedTT);
		}

		if (PruneGraph) {
			System.out.println("INFO: Prune the graph.");
			graph.removeIsolatedNodes();
		}

		System.out.println("INFO: Create node finder.");
		nf = Factory.createNodeFinder(graph);
	}

	/**
	 * Wait (block) until a connection to a client was made and handled.
	 *
	 * @throws IOException
	 *             If the connection breaks unexpected or during the
	 *             communication.
	 */
	public void acceptConnections() throws IOException {
		System.out.println("INFO: Waiting for a connection now.");

		Socket client = null;
		while (client == null)
			client = serverSocket.accept();

		System.out.println("INFO: Got a connection!");

		try {
			handleClient(client);
			System.out.println("INFO: Client handled.");
		} catch (Exception e) {
			e.printStackTrace();
			System.err
			.println("ERROR: Exception occured while handling client: "
					+ e);
		} finally {
			client.close();
			System.out.println("INFO: Client connection closed.");
		}

	}

	/**
	 * Close the server socket and thereby allow a new server on this port.
	 */
	public void closeSocket() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err
			.println("\n\nWARNING:  Could not close server socket. This should not be a real problem though.");

		}
	}

	/**
	 * Compute the faster route between the given coordinates and return the
	 * result.
	 */
	private void computeAndSendRoute(Socket client, Scanner requestScanner)
			throws IOException {

		sw.reset();

		if (!requestScanner.hasNext("waypoints"))
			throw new IOException(
					"Invalid client request (expected waypoints)!");
		requestScanner.next();

		List<Coordinate> waypoints = new ArrayList<>();
		List<Node> nodes = new ArrayList<Node>();

		while (requestScanner.hasNextDouble()) {
			Node n;
			String token = requestScanner.next();
			if (token.contains(".")) {
				double latitude = Double.parseDouble(token);
				double longitude = requestScanner.nextDouble();

				Coordinate c = new Coordinate(latitude, longitude);
				waypoints.add(c);

				sw.start();
				n = nf.getNodeForCoordinates(c);
				sw.stop();

				System.out.println("INFO: Graph node for coordinate: " + c
						+ " has id: " + n.getId());
			} else {
				long osm_id = Long.parseLong(token);
				n = graph.getNode(osm_id);
				if (n == null)
					throw new IOException("ID: " + osm_id
							+ " is not in the graph!");
				waypoints.add(n.getCoordinate());

			}
			nodes.add(n);
		}

		if (requestScanner.next("travelmode") == null)
			throw new IOException(
					"Invalid client request (expected travelmode after waypoints)!");

		if (!requestScanner.hasNext("(driving|bicycling|walking)"))
			throw new IOException(
					"Invalid client request (invalid travelmode)!");

		TravelType travelType = TravelType.ANY;
		String travelTypeString = requestScanner.next();
		if (travelTypeString.equals("driving"))
			travelType = TravelType.CAR;
		else if (travelTypeString.equals("bicycling"))
			travelType = TravelType.BIKE;
		else if (travelTypeString.equals("walking"))
			travelType = TravelType.FOOT;

		sw.start();
		Route r = null;
		String data = "No Route Found!";
		try {
			r = ra.computeRoute(graph, nodes, travelType);
		} catch (NoSuchRouteException e) {
		}
		sw.stop();

		if (r != null && r.size() > 0) {
			if (r.size() > 0)
				data = r.toJSON(sw.time(), waypoints);
		} else {
			System.err.println("WARNING: " + data);
		}

		sendResponse(client, data, "text/plain", data.length());
	}

	/**
	 * Helper to create a valid HTTP response header.
	 */
	private String createHttpResponse(String data, String mimeType, int length) {
		StringBuilder builder = new StringBuilder();
		builder.append("HTTP/1.1 200 OK\r\n");
		builder.append("Content-Type: " + mimeType + "\r\n");
		builder.append("Content-Length: " + length + "\r\n\r\n");
		if (data != null)
			builder.append(data);

		return builder.toString();
	}

	/**
	 * Decode and handle the request of a client (the frontend).
	 *
	 * @param client
	 *            The client socket used for communication.
	 * @throws IOException
	 *             If the communication fails.
	 */
	private void handleClient(Socket client) throws IOException {
		Scanner requestScanner = null;
		Scanner in = null;

		try {
			in = new Scanner(client.getInputStream());
			if (!in.hasNextLine())
				return;

			String request = in.nextLine();
			requestScanner = new Scanner(request);
			requestScanner.useLocale(Locale.US);

			requestScanner.useDelimiter("(\\s+|\\?|,|=|\\|)");

			if (!requestScanner.hasNext("GET"))
				throw new IOException(
						"Invalid client request (wrong or no GET)!");
			requestScanner.next();

			if (!requestScanner.hasNext("/+routes"))
				sendStaticData(client, requestScanner);
			else {
				System.out.println("INFO: Got routing request: " + request);
				requestScanner.next();
				computeAndSendRoute(client, requestScanner);
			}

		} finally {
			if (in != null)
				in.close();
			if (requestScanner != null)
				requestScanner.close();
		}
	}

	/**
	 * @return Returns true if the socket is valid and should be able to accept
	 *         connections.
	 */
	private boolean isValid() {
		return serverSocket != null && !serverSocket.isClosed();
	}

	/**
	 * Open a server, or better create a new server socket.
	 *
	 * @throws IOException
	 *             If the socket cannot be created.
	 */
	public void openSocket() throws IOException {
		System.out.print("INFO: Try to open server ...");

		serverSocket = new ServerSocket(PORT);

		System.out
		.print("... server is open and listening on " + PORT + " ...");
		System.out.print("... "
				+ (isValid() ? "and good to go!" : "but not valid!") + "\n");
	}

	/**
	 * Helper to send the given binary data to the client.
	 */
	private void sendResponse(Socket client, byte[] bytes, String mimeType)
			throws IOException {
		WritableByteChannel out = Channels.newChannel(client.getOutputStream());
		ByteBuffer buffer = ByteBuffer.wrap(bytes);

		sendResponse(client, null, mimeType, bytes.length);

		out.write(buffer);
	}

	/**
	 * Helper to send the given ASCII data to the client.
	 */
	private void sendResponse(Socket client, String data, String mimeType,
			int length) throws IOException {
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		data = createHttpResponse(data, mimeType, length);
		try {
			out.write(data);
		} finally {
			out.flush();
		}
	}

	/**
	 * Send the requested static file (.html,.jpg,...) to the client.
	 */
	private void sendStaticData(Socket client, Scanner requestScanner)
			throws IOException {
		String token = requestScanner.next();
		String path = "Frontend" + token;
		String mimeType = "text/plain";

		if (token.equals("/"))
			path += "index.html";

		if (path.endsWith(".html"))
			mimeType = "text/html";
		else if (path.endsWith(".js"))
			mimeType = "text/javascript";
		else if (path.endsWith(".css"))
			mimeType = "text/css";
		else if (path.endsWith(".jpg") || path.endsWith(".jpeg"))
			mimeType = "image/jpeg";
		else if (path.endsWith(".png"))
			mimeType = "image/png";
		else if (path.endsWith(".gif"))
			mimeType = "image/gif";

		byte[] content = Files.readAllBytes(FileSystems.getDefault().getPath(
				path));
		sendResponse(client, content, mimeType);
	}

}
