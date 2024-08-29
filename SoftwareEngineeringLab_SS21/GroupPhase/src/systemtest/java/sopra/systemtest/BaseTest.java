package sopra.systemtest;

import java.util.Set;
import sopra.comm.TimeoutException;
import sopra.systemtest.api.SystemTest;
import sopra.systemtest.api.Utils;

public class BaseTest extends SystemTest {
  public BaseTest() {
    super(BaseTest.class, false);
  }

  @Override
  protected String createConfig() {
    return Utils.loadResource(BaseTest.class, "basicConfig.json");
  }

  @Override
  protected long createSeed() {
    return 0;
  }

  @Override
  protected Set<Integer> createSockets() {
    return Set.of(1);
  }

  @Override
  protected void run() throws TimeoutException, AssertionError {
    this.sendRegister(1, "Jeff");
    this.assertConfig(1, createConfig());
    this.sendStartGame(1);
    this.assertGameStarted(1);
    this.assertPlayer(1, 0, "Jeff");
    this.assertCharacters(1, 2002, 2000, 2006, 2004);
    this.sendSelectCharacters(1, 2004, 2006);
    this.assertCharacterSpawned(1, 0, 2004);
    this.assertCharacterSpawned(1, 0, 2006);
    this.assertCardDrawn(1, 0, 1030);
    this.assertCardDrawn(1, 0, 1012);
    this.assertCardDrawn(1, 0, 1033);
    this.assertCardDrawn(1, 0, 1031);
    this.assertCardDrawn(1, 0, 1032);
  }
}
