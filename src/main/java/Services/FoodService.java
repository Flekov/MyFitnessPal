package Services;

import Items.Food;
import Repositories.ReaderWriter;

import java.io.IOException;
import java.util.ArrayList;

public class FoodService extends Service<Food> {
    public FoodService(ReaderWriter<Food> foodReaderWriter) throws IOException {
        readerWriter = foodReaderWriter;
    }

    public Food AddFood(Food food) throws IOException {
        return readerWriter.AddToFile(food);
    }

    public ArrayList<Food> GetFoods() throws IOException {
        return readerWriter.ReadFromFile();
    }
}
