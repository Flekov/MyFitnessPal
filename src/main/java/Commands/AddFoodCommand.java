package Commands;

import Items.Food;
import Services.FoodService;

import java.io.IOException;

public class AddFoodCommand extends Command {
    private final FoodService foodService;

    public AddFoodCommand(FoodService foodService) {
        this.foodService = foodService;
    }

    public Food Execute(String name, int servingSize, int numberOfServings, int calories, double carbs, double fat, double protein) throws IOException {
        Food food = new Food(name, servingSize, numberOfServings, calories, carbs, fat, protein);
        return foodService.AddFood(food);
    }



}
