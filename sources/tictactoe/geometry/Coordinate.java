package tictactoe.geometry;

import java.util.ArrayList;
import tictactoe.geometry.exceptions.InvalidNumberOfAxisValuesException;
import tictactoe.geometry.exceptions.OutOfRangeAxisValueException;

public class Coordinate
{
    private int x, y;

    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public boolean isEqualTo(Coordinate coordinate)
    {
        return this.x == coordinate.getX() && this.y == coordinate.getY();
    }

    public boolean isContainedInArrayList(ArrayList<Coordinate> coordinates)
    {
        for (Coordinate coordinate : coordinates)
        {
            if (this.isEqualTo(coordinate))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isGroupContainedInArrayList(
        Coordinate[] coordinateGroup, ArrayList<Coordinate> coordinates)
    {
        for (Coordinate coordinate : coordinateGroup)
        {
            if (!coordinate.isContainedInArrayList(coordinates))
            {
                return false;
            }
        }
        return true;
    }

    private static int parseStringToAxisValue(String string, String axis)
        throws OutOfRangeAxisValueException
    {
        int axisValue;
        try
        {
            axisValue = Integer.parseInt(string);
        }
        catch (NumberFormatException _exception)
        {
            throw new NumberFormatException("the " + axis + " value, \"" +
                                            string + "\", must be a number.");
        }
        if (axisValue < 0 || axisValue > 2)
        {
            throw new OutOfRangeAxisValueException(
                "the " + axis + " value, \"" + string +
                "\", must be between 0 and 2.");
        }
        return axisValue;
    }

    public static Coordinate fromString(String string)
        throws InvalidNumberOfAxisValuesException, OutOfRangeAxisValueException
    {
        String[] stringSplits = string.split(",");
        if (stringSplits.length != 2)
        {
            throw new InvalidNumberOfAxisValuesException(
                "the coordinate must be like: 1,2.");
        }
        int x, y;
        try
        {
            x = parseStringToAxisValue(stringSplits[0], "X");
            y = parseStringToAxisValue(stringSplits[1], "Y");
        }
        catch (NumberFormatException | OutOfRangeAxisValueException exception)
        {
            throw exception;
        }
        return new Coordinate(x, y);
    }

    public String toString()
    {
        return "(x: " + this.x + ", y: " + this.y + ")";
    }
}
