import java.io.*;
public class FileRead{
    public static void main(String[] args) {
        // Taking data from a file with 200 Lorem Random words from html file.
        try (BufferedReader br = new BufferedReader(new FileReader("Lorem.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
