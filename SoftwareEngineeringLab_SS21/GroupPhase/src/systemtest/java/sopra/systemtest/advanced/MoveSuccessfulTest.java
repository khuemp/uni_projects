package sopra.systemtest.advanced;

import java.util.Set;
import sopra.comm.MoralChange;
import sopra.comm.TimeoutException;
import sopra.systemtest.api.SystemTest;
import sopra.systemtest.api.Utils;

public class MoveSuccessfulTest extends SystemTest {
  public MoveSuccessfulTest() {
    super(MoveSameLocationTest.class, false);
  }

  @Override
  protected String createConfig() {
    return Utils.loadResource(MoveSuccessfulTest.class, "basicConfig.json");
  }

  @Override
  protected long createSeed() {
    return 20;
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
    this.assertCharacters(1, 2010, 2006, 2007, 2003);
    this.sendSelectCharacters(1, 2010, 2006);
    this.assertCharacterSpawned(1, 0, 2006);
    this.assertCharacterSpawned(1, 0, 2010);
    this.assertCardDrawn(1, 0, 1022);
    this.assertCardDrawn(1, 0, 1001);
    this.assertCardDrawn(1, 0, 1012);
    this.assertCardDrawn(1, 0, 1013);
    this.assertCardDrawn(1, 0, 1034);
    this.assertNextRound(1, 1);
    this.assertCrisis(1, 4010);
    this.assertDieRolled(1, 0, 1);
    this.assertDieRolled(1, 0, 4);
    this.assertDieRolled(1, 0, 2);
    this.assertActNow(1);

    this.sendMove(1, 2010, 3001);
    this.assertCommandFailed(1);
    this.assertActNow(1);
    this.sendEndTurn(1);

    this.assertColonyPhaseStarted(1);
    this.assertStarvationTokenAdded(1);
    this.assertMoralChanged(1, -1, MoralChange.STARVATION_TOKEN);
    this.assertMoralChanged(1, 0, MoralChange.WASTE);
    this.assertMoralChanged(1, -2, MoralChange.CRISIS);
    this.assertGameEnd(1, true);
  }
}
