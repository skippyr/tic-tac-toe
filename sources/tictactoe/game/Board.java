package tictactoe.game;

import tictactoe.game.exceptions.AlreadySelectedCoordinateException;
import tictactoe.geometry.Coordinate;
import tictactoe.io.Color;

public class Board
{
    private Player cross, circle;
    private boolean isCrossPlaying;

    public Board()
    {
        this.cross = new Player("Cross", "X", Color.Green);
        this.circle = new Player("Circle", "O", Color.Blue);
        this.isCrossPlaying = true;
    }

    public Player getLastPlayer()
    {
        return isCrossPlaying ? this.circle : this.cross;
    }

    public Player getCurrentPlayer()
    {
        return isCrossPlaying ? this.cross : this.circle;
    }

    public boolean isWon()
    {
        return this.cross.isWinner() || this.circle.isWinner();
    }

    public boolean isDraw()
    {
        return this.cross.getCoordinates().size() +
            this.circle.getCoordinates().size() ==
            9;
    }

    public void addCoordinate(Coordinate coordinate)
        throws AlreadySelectedCoordinateException
    {
        if (this.cross.hasCoordinate(coordinate) ||
            this.circle.hasCoordinate(coordinate))
        {
            throw new AlreadySelectedCoordinateException(
                "the coordinate " + coordinate + " is already selected.");
        }
        if (isCrossPlaying)
        {
            this.cross.addCoordinate(coordinate);
        }
        else
        {
            this.circle.addCoordinate(coordinate);
        }
        this.isCrossPlaying = !this.isCrossPlaying;
    }

    public void draw()
    {
        System.out.println(Color.Grey.colorize("\n  󰵈 x"));
        System.out.println(" 0  1  2");
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                Coordinate coordinate = new Coordinate(x, y);
                if (this.cross.hasCoordinate(coordinate))
                {
                    System.out.print("[" + this.cross.getColoredSymbol() + "]");
                }
                else if (this.circle.hasCoordinate(coordinate))
                {
                    System.out.print("[" + this.circle.getColoredSymbol() +
                                     "]");
                }
                else
                {
                    System.out.print(Color.Grey.colorize("[ ]"));
                }
            }
            System.out.println(" " + y +
                               Color.Grey.colorize((y == 1 ? " y 󰵈 " : "")));
        }
        System.out.println();
    }
}
