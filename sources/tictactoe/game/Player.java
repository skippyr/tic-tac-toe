package tictactoe.game;

import java.util.ArrayList;
import tictactoe.geometry.Coordinate;
import tictactoe.io.Color;

public class Player
{
    private String                name, symbol;
    private Color                 color;
    private ArrayList<Coordinate> coordinates;

    public Player(String name, String symbol, Color color)
    {
        this.name        = name;
        this.symbol      = symbol;
        this.color       = color;
        this.coordinates = new ArrayList<>();
    }

    public String
    getColoredName()
    {
        return this.color.colorize(this.name);
    }

    public String
    getColoredSymbol()
    {
        return this.color.colorize(this.symbol);
    }

    public ArrayList<Coordinate>
    getCoordinates()
    {
        return this.coordinates;
    }

    public boolean
    isWinner()
    {
        Coordinate[][] winCoordinateGroups = {
            /* Horizontal Lines */
            {new Coordinate(0, 0), new Coordinate(1, 0), new Coordinate(2, 0)},
            {new Coordinate(0, 1), new Coordinate(1, 1), new Coordinate(2, 1)},
            {new Coordinate(0, 2), new Coordinate(1, 2), new Coordinate(2, 2)},
            /* Vertical Lines */
            {new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(0, 2)},
            {new Coordinate(1, 0), new Coordinate(1, 1), new Coordinate(1, 2)},
            {new Coordinate(2, 0), new Coordinate(2, 1), new Coordinate(2, 2)},
            /* Diagonals */
            {new Coordinate(0, 0), new Coordinate(1, 1), new Coordinate(2, 2)},
            {new Coordinate(2, 0), new Coordinate(1, 1), new Coordinate(0, 2)}};
        for (Coordinate[] winCoordinateGroup : winCoordinateGroups)
        {
            if (Coordinate.isGroupContainedInArrayList(winCoordinateGroup,
                                                       coordinates))
            {
                return true;
            }
        }
        return false;
    }

    public boolean
    hasCoordinate(Coordinate coordinate)
    {
        return coordinate.isContainedInArrayList(this.coordinates);
    }

    public void
    addCoordinate(Coordinate coordinate)
    {
        this.coordinates.add(coordinate);
    }
}
