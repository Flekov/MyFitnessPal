package Commands;

import Items.Water;
import Services.WaterService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GetWaterCommand extends Command {
    private final WaterService waterService;

    public GetWaterCommand(WaterService waterService) {
        this.waterService = waterService;
    }

    public ArrayList<Water> Execute(LocalDate date) throws IOException {
        return waterService.GetWater(date);
    }

}
