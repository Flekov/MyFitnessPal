package Mappers;

import Items.Food;

public class FoodParser implements ItemParser<Food> {
    @Override
    public Food ParseItem(String line) {
        String[] foodProperties = line.split("<->");
        if(foodProperties.length == 7) {
            String name = foodProperties[0].trim();
            int servingSize = Integer.parseInt(foodProperties[1].trim());
            int numberOfServings = Integer.parseInt(foodProperties[2].trim());
            int calories = Integer.parseInt(foodProperties[3].trim());
            double carbs = Double.parseDouble(foodProperties[4].trim());
            double fat = Double.parseDouble(foodProperties[5].trim());
            double protein = Double.parseDouble(foodProperties[6].trim());
            return new Food(name, servingSize, numberOfServings, calories, carbs, fat, protein);
        }
        return new Food();
    }

    @Override
    public String FormatItem(Food food) {
        return food.getName() + "<->" +
                food.getServingSize() + "<->" +
                food.getNumberOfServings() + "<->" +
                food.getCalories() + "<->" +
                food.getCarbs() + "<->" +
                food.getFat() + "<->" +
                food.getProtein();
    }
}
