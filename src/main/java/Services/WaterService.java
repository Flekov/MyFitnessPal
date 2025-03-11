package Services;

import Items.Water;
import Repositories.ReaderWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class WaterService extends Service<Water> {
    public WaterService(ReaderWriter<Water> waterReaderWriter) throws IOException{
        readerWriter = waterReaderWriter;
    }

    public Water AddWater(LocalDate date, Water water) throws IOException {
        return readerWriter.AddToFileWithDate(date, water);
    }

    public ArrayList<Water> GetWater(LocalDate date) throws IOException {
        return readerWriter.ReadFromFileOnDate(date);
    }
}
