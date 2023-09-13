package tictactoe.io;

public class Terminal {
    public static void clear() {
        System.out.print("\033[2J\033[H");
    }

    public static void printInfo(String info) {
        System.out.println(Color.Blue.colorize(" INFO: ") + info);
    }
}
