
import java.io.*;
import java.util.*;
public class FileHelper {
    
    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "ISO-8859-1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}