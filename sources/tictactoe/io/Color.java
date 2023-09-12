package tictactoe.io;

public enum Color
{
    Green(1),
    Blue(4),
    Grey(8);

    private int ansiCode;

    private Color(int ansiCode)
    {
        this.ansiCode = ansiCode;
    }

    public String colorize(String string)
    {
        return "\033[38;5;" + this.ansiCode + "m" + string + "\033[0m";
    }
}
