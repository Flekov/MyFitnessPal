package Repositories;

import Items.Item;
import Mappers.DateFormatter;
import Mappers.ItemParser;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReaderWriter<T extends Item> {
    private final FileWriter fileWriter;
    private final FileReader fileReader;
    private final ItemParser<T> itemParser;
    private final DateFormatter dateFormatter = new DateFormatter();

    public ReaderWriter(String fileName, ItemParser<T> parser) throws IOException {
        this.fileWriter = new FileWriter(fileName, true);
        this.fileReader = new FileReader(fileName);
        this.itemParser = parser;
    }

    public T AddToFileWithDate(LocalDate date, T item) throws IOException{
        String itemString = itemParser.FormatItem(item);
        String dateString = dateFormatter.Format(date);
        fileWriter.write(dateString + "<->" + itemString + "\n");
        fileWriter.flush();
        return item;
    }

    public T AddToFile(T item) throws IOException{
        String itemString =  itemParser.FormatItem(item);
        fileWriter.write(itemString);
        fileWriter.flush();
        return item;
    }

    public ArrayList<T> ReadFromFileOnDate(LocalDate date) throws IOException{
        ArrayList<T> itemList = new ArrayList<T>();
        String dateString = dateFormatter.Format(date);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(dateString)) {
                String[] lineArray = line.split("<->");
                if (lineArray.length == 2) {
                    T item = itemParser.ParseItem(lineArray[1]);
                    itemList.add(item);
                }
            }
        }
        return itemList;
    }

    public ArrayList<T> ReadFromFile() throws IOException{
        ArrayList<T> itemList = new ArrayList<T>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            T item = itemParser.ParseItem(line);
            itemList.add(item);
        }
        return itemList;
    }

    public boolean Close() throws IOException{
        this.fileWriter.close();
        this.fileReader.close();
        return true;
    }

}
