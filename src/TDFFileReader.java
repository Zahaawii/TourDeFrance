import java.io.*;
import java.util.*;

public class TDFFileReader {
    private String fileName;

    public TDFFileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Cyclist> readFile() {
        List<Cyclist> cyclists = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length >= 3) { // Tjekker at vi har nok data
                    String name = parts[1].trim();
                    String team = parts[2].trim();
                    cyclists.add(new Cyclist(name, team));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cyclists;
    }
}
