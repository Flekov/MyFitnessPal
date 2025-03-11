package UI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        startProgram();
    }

    private static boolean startProgram() {
        ConsoleProgram consoleProgram = new ConsoleProgram(){};
        try{
            consoleProgram.Run();
            return true;
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}