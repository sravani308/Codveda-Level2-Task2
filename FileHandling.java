import java.io.*;

public class FileHandling {

    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;

            while ((line = reader.readLine()) != null) {

                lineCount++;

                charCount += line.length();

                String[] words = line.split("\\s+");

                wordCount += words.length;
            }

            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            writer.write("===== FILE ANALYSIS REPORT =====");
            writer.newLine();
            writer.write("Total Lines      : " + lineCount);
            writer.newLine();
            writer.write("Total Words      : " + wordCount);
            writer.newLine();
            writer.write("Total Characters : " + charCount);
            writer.newLine();

            writer.close();

            System.out.println("=================================");
            System.out.println("File Processing Completed");
            System.out.println("Output saved in output.txt");
            System.out.println("=================================");

        } catch (FileNotFoundException e) {

            System.out.println("Input file not found!");

        } catch (IOException e) {

            System.out.println("Error while processing file!");
        }
    }
}