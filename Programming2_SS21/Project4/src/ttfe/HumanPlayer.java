package ttfe;

public class HumanPlayer implements PlayerInterface {

    @Override
    public MoveDirection getPlayerMove(SimulatorInterface game, UserInterface ui) {
        return ui.getUserMove();
    }
    
}
