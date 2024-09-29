package health.parsingStrategy;

import health.parsingStrategy.ParserStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileImporter<T> {
    private ParserStrategy<T> strategy;

    public FileImporter(ParserStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public List<T> loadCSV(String filename) {
        List<T> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                T data = strategy.parse(line);
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
