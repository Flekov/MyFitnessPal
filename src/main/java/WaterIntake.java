import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WaterIntake extends Item {
    LocalDate date;
    int amount;

    public WaterIntake(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public WaterIntake(String line) {
        String[] tokens = line.split("<->");
        LocalDate date = LocalDate.parse(tokens[0], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int amount = Integer.parseInt(tokens[1]);
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "<->" + amount;
    }


}
