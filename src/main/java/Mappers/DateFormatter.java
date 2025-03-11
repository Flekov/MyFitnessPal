package Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DateFormatter() {}

    public String Format(LocalDate date){
        return dateFormatter.format(date);
    }

    public LocalDate ParseDate(String dateString){
        return LocalDate.parse(dateString, dateFormatter);
    }

}
