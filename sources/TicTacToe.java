import java.util.Scanner;
import tictactoe.game.Board;
import tictactoe.game.exceptions.AlreadySelectedCoordinateException;
import tictactoe.geometry.Coordinate;
import tictactoe.geometry.exceptions.InvalidNumberOfAxisValuesException;
import tictactoe.geometry.exceptions.OutOfRangeAxisValueException;
import tictactoe.io.Color;
import tictactoe.io.Terminal;

public class TicTacToe
{
    public static void main(String[] _arguments)
    {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        String info = "";
        while (true)
        {
            Terminal.clear();
            System.out.println(
                Color.Grey.colorize("󰩈 Use Ctrl + C to end the game."));
            board.draw();
            if (board.isWon())
            {
                Terminal.printInfo(board.getLastPlayer().getColoredName() +
                                   " won!");
                break;
            }
            if (board.isDraw())
            {
                Terminal.printInfo("Draw!");
                break;
            }
            if (info.length() != 0)
            {
                Terminal.printInfo(info);
            }
            try
            {
                System.out.print(
                    "[" + board.getCurrentPlayer().getColoredSymbol() + "][" +
                    board.getCurrentPlayer().getColoredName() +
                    " Player] Your coordinate: ");
                board.addCoordinate(Coordinate.fromString(scanner.nextLine()));
            }
            catch (AlreadySelectedCoordinateException |
                   InvalidNumberOfAxisValuesException |
                   OutOfRangeAxisValueException |
                   NumberFormatException exception)
            {
                info = exception.getMessage();
                continue;
            }
            catch (RuntimeException _exception)
            {
                System.exit(1);
            }
            info = "";
        }
        scanner.close();
    }
}
