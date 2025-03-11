package UI;
import Mappers.DateFormatter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleProgram {
    private final Scanner scanner = new Scanner(System.in);
    private final DateFormatter dateFormatter = new DateFormatter();
    private CommandExecutor commandExecutor;

    public ConsoleProgram() {}

    public boolean Run() throws IOException {
        PrintCommands();
        InitializeCommandExecutor();
        StartInterpreter();
        End();
        return true;
    }

    private boolean PrintCommands() {
        System.out.println("1.Drink Water");
        System.out.println("2.Check Water");
        System.out.println("3.Create Food");
        System.out.println("4.View All Foods");
        return true;
    }

    private boolean InitializeCommandExecutor() throws IOException {
        commandExecutor = new CommandExecutor(dateFormatter, scanner);
        return true;
    }

    private boolean StartInterpreter() throws IOException {
        String command = ReadCommand();
        while(!command.equals("exit")){
            ExecuteCommand(command);
            command = ReadCommand();
        }
        return true;
    }

    private String ReadCommand(){
        System.out.print(">");
        return scanner.nextLine();
    }

    private boolean ExecuteCommand(String command) throws IOException {
        LocalDate date;
        switch (command) {
            case "1":
                this.commandExecutor.ExecuteAddWaterCommand();
                break;
            case "2":
                this.commandExecutor.ExecuteGetWaterCommand();
                break;
            case "3":
                this.commandExecutor.ExecuteAddFoodCommand();
                break;
            case "4":
                this.commandExecutor.ExecuteGetFoodsCommand();
                break;
            default:
                System.out.print("Invalid command!\n");
                break;
        }
        return true;
    }

    private boolean End() throws IOException {
        this.commandExecutor.CloseServices();
        System.out.println("Bye");
        return true;
    }
}
