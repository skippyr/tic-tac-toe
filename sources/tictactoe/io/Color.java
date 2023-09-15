package tictactoe.io;

public enum Color
{
    GREEN(1),
    BLUE(4),
    GREY(8);

    private int ansiCode;

    private Color(int ansiCode)
    {
        this.ansiCode = ansiCode;
    }

    public String
    colorize(String string)
    {
        return "\033[38;5;" + this.ansiCode + "m" + string + "\033[0m";
    }
}
