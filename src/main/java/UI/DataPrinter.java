package UI;

import Items.Food;
import Items.Water;
import Mappers.DateFormatter;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataPrinter {
    private final DateFormatter dateFormatter;

    public DataPrinter(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    public boolean PrintWaterIntakes(ArrayList<Water> waterIntakes, LocalDate date) {
        if (waterIntakes.isEmpty()) {
            System.out.println("There is no water with that date!");
        } else {
            System.out.println(dateFormatter.Format(date) + ":");
            for (Water water: waterIntakes) {
                System.out.println(water);
            }
        }
        return true;
    }

    public boolean PrintFoods(ArrayList<Food> foods) {
        if (foods.isEmpty()) {
            System.out.println("There are no foods!");
        } else {
            for(int i = 0, size = foods.size(); i < size; i++) {
                System.out.println((i + 1) + ". " + foods.get(i));
            }
        }
        return true;
    }
}
