package utility;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Excel {

    public static List<String> extractEANCodes() throws CsvValidationException, IOException {
        List<String> list = new ArrayList<>();

        InputStream inputStream = Excel.class.getClassLoader().getResourceAsStream("data.txt");
        if (inputStream == null) {
            throw new RuntimeException("Fichier introuvable dans resources.");
        }

        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;
            csvReader.readNext(); // Ignorer la ligne d'entête

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[0]);
                }
            }
        }

        return list;
    }
    public static Map<String, List<String>> map() throws CsvValidationException, IOException {
        List<String> articles=new ArrayList<>();
        List<String> RHVITROLLESQuantities=new ArrayList<>();
        List<String> RHGRANDLITTORALQuantities=new ArrayList<>();
        List<String> RHBONNEVELESQuantities=new ArrayList<>();
        List<String> RHCARREFERENCESQuantities=new ArrayList<>();
        InputStream inputStream = Excel.class.getClassLoader().getResourceAsStream("data.txt");
        if (inputStream == null) {
            throw new RuntimeException("Fichier introuvable dans resources.");
        }

        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    articles.add(record[0]);
                    RHVITROLLESQuantities.add(record[9]);
                    RHGRANDLITTORALQuantities.add(record[11]);
                    RHBONNEVELESQuantities.add(record[10]);
                    RHCARREFERENCESQuantities.add(record[12]);
                }
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<articles.size();i++){
            map.put(articles.get(i),List.of(RHVITROLLESQuantities.get(i),RHGRANDLITTORALQuantities.get(i),RHBONNEVELESQuantities.get(i)));
        }
        return map;
    }
    public static List<String> extractEANCodesDoublons() throws CsvValidationException, IOException {
        List<String> list = new ArrayList<>();

        InputStream inputStream = Excel.class.getClassLoader().getResourceAsStream("data2.txt");
        if (inputStream == null) {
            throw new RuntimeException("Fichier introuvable dans resources.");
        }

        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;
            csvReader.readNext(); // Ignorer la ligne d'entête

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[0]);
                }
            }
        }

        return list;
    }
}
