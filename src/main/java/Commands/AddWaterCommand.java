package Commands;

import Items.Water;
import Services.WaterService;

import java.io.IOException;
import java.time.LocalDate;

public class AddWaterCommand extends Command {
    private final WaterService waterService;

    public AddWaterCommand(WaterService waterService) {
        this.waterService = waterService;
    }

    public Water Execute(LocalDate date, int waterAmount) throws IOException {
        Water water = new Water(waterAmount);
        return waterService.AddWater(date, water);
    }
}
