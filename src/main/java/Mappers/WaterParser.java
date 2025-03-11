package Mappers;

import Items.Water;

public class WaterParser implements ItemParser<Water> {
    @Override
    public Water ParseItem(String waterAmount) {
        int amount = Integer.parseInt(waterAmount.trim());
        return new Water(amount);
    }

    @Override
    public String FormatItem(Water water) {
        return water.toString();
    }
}
