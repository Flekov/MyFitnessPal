package UI;

import Mappers.DateFormatter;

import java.time.LocalDate;
import java.util.Scanner;

public class DataInputReader {
    DateFormatter dateFormatter;
    Scanner scanner;

    public DataInputReader(DateFormatter dateFormatter, Scanner scanner) {
        this.dateFormatter = dateFormatter;
        this.scanner = scanner;
    }

    public LocalDate ReadDate() {
        System.out.println("When:");
        System.out.print(">");
        String dateString = scanner.nextLine();
        return dateFormatter.ParseDate(dateString);
    }

    public int ReadWaterAmount() {
        System.out.println("How much (ml):");
        System.out.print(">");
        String amountString = scanner.nextLine();
        return Integer.parseInt(amountString);
    }

    public String ReadName() {
        System.out.println("Name:");
        System.out.print(">");
        return scanner.nextLine();
    }

    public int ReadServingSize() {
        System.out.println("Serving size (g):");
        System.out.print(">");
        String servingSizeString = scanner.nextLine();
        return Integer.parseInt(servingSizeString);
    }

    public int ReadNumberOfServings() {
        System.out.println("Servings per container (g):");
        System.out.print(">");
        String numberOfServingsString = scanner.nextLine();
        return Integer.parseInt(numberOfServingsString);
    }

    public int ReadCalories() {
        System.out.println("Calories (kcal):");
        System.out.print(">");
        String caloriesString = scanner.nextLine();
        return Integer.parseInt(caloriesString);
    }

    public double ReadCarbs() {
        System.out.println("Carbs (g):");
        System.out.print(">");
        String carbsString = scanner.nextLine();
        return Double.parseDouble(carbsString);
    }

    public double ReadFat() {
        System.out.println("Fat (g):");
        System.out.print(">");
        String fatString = scanner.nextLine();
        return Double.parseDouble(fatString);
    }

    public double ReadProtein() {
        System.out.println("Protein (g):");
        System.out.print(">");
        String proteinString = scanner.nextLine();
        return Double.parseDouble(proteinString);
    }
}
