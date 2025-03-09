import java.io.*;
import java.util.ArrayList;
public class ReaderWriter {
    FileWriter fileWriter;
    FileReader fileReader;
    ItemParser itemParser;

    public ReaderWriter(String fileName) throws IOException {
        try {
            this.fileWriter = new FileWriter(fileName);
            this.fileReader = new FileReader(fileName);
            this.itemParser = new ItemParser();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean AddToFileWithDate(String date, Item item) throws IOException{
        try {
            String fileInput =  item.toString();
            fileWriter.write(date + "<->" + fileInput);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean AddToFile(Item item) throws IOException{
        try {
            String fileInput =  item.toString();
            fileWriter.write(fileInput);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> ReadFromFileOnDate(String date) throws IOException{
        ArrayList<String> itemList = new ArrayList<String>();

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(date)) {
                    String[] lineArray = line.split("<->");
                    if (lineArray.length == 2) {
                        String itemString = lineArray[1];
                        itemList.add(lineArray[0]);
                    }
                }
            }
            return itemList;

        } catch (IOException e) {
            return null;
        }
    }

    public ArrayList<String> ReadFromFileOnDate(String date) throws IOException {
        ArrayList<String> itemList = new ArrayList<String>();

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                itemList.add(line);
            }
            return itemList;

        } catch (IOException e) {
            return null;
        }
    }
}
