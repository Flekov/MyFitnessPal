package Commands;

import Mappers.DateFormatter;

import java.util.Scanner;

public abstract class Command {

    protected DateFormatter dateFormatter = new DateFormatter();
    protected Scanner scanner = new Scanner(System.in);
}
