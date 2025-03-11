package UI;

import Commands.AddFoodCommand;
import Commands.AddWaterCommand;
import Commands.GetFoodsCommand;
import Commands.GetWaterCommand;
import Items.Food;
import Items.Water;
import Mappers.DateFormatter;
import Mappers.FoodParser;
import Mappers.WaterParser;
import Repositories.ReaderWriter;
import Services.FoodService;
import Services.WaterService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CommandExecutor {
    private final WaterService waterService;
    private final FoodService foodService;

    private final DataInputReader dataInputReader;
    private final DataPrinter dataPrinter;

    public CommandExecutor(DateFormatter dateFormatter, Scanner scanner) throws IOException {
        this.dataInputReader = new DataInputReader(dateFormatter, scanner);
        this.dataPrinter = new DataPrinter(dateFormatter);

        ReaderWriter<Water> waterReaderWriter = new ReaderWriter<Water>("data/water_data.txt", new WaterParser());
        this.waterService = new WaterService(waterReaderWriter);
        ReaderWriter<Food> foodReaderWriter = new ReaderWriter<Food>("data/food_data.txt", new FoodParser());
        this.foodService = new FoodService(foodReaderWriter);
    }

    public boolean ExecuteAddWaterCommand() throws IOException {
        LocalDate date = this.dataInputReader.ReadDate();
        int waterAmount = this.dataInputReader.ReadWaterAmount();
        AddWaterCommand addWaterCommand = new AddWaterCommand(waterService);
        addWaterCommand.Execute(date, waterAmount);
        return true;
    }

    public boolean ExecuteGetWaterCommand() throws IOException {
        LocalDate date = this.dataInputReader.ReadDate();
        GetWaterCommand getWaterCommand = new GetWaterCommand(waterService);
        ArrayList<Water> waterIntakes = getWaterCommand.Execute(date);
        this.dataPrinter.PrintWaterIntakes(waterIntakes, date);
        return true;
    }

    public boolean ExecuteAddFoodCommand() throws IOException {
        String name = this.dataInputReader.ReadName();
        int servingSize = this.dataInputReader.ReadServingSize();
        int numberOfServings = this.dataInputReader.ReadNumberOfServings();
        int calories = this.dataInputReader.ReadCalories();
        double carbs = this.dataInputReader.ReadCarbs();
        double fat = this.dataInputReader.ReadFat();
        double protein = this.dataInputReader.ReadProtein();
        AddFoodCommand addFoodCommand = new AddFoodCommand(foodService);
        addFoodCommand.Execute(name, servingSize, numberOfServings, calories, carbs, fat, protein);
        return true;
    }

    public boolean ExecuteGetFoodsCommand() throws IOException {
        GetFoodsCommand getFoodsCommand = new GetFoodsCommand(foodService);
        ArrayList<Food> foods = getFoodsCommand.Execute();
        this.dataPrinter.PrintFoods(foods);
        return true;
    }

    public boolean CloseServices() throws IOException {
        this.waterService.Close();
        this.foodService.Close();
        return true;
    }
}
