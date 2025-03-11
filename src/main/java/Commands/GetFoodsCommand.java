package Commands;

import Items.Food;
import Services.FoodService;

import java.io.IOException;
import java.util.ArrayList;

public class GetFoodsCommand extends Command {
    private final FoodService foodService;

    public GetFoodsCommand(FoodService foodService) {
        this.foodService = foodService;
    }

    public ArrayList<Food> Execute() throws IOException {
        return foodService.GetFoods();
    }
}
