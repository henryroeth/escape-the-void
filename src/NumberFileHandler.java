import java.io.*;

public class NumberFileHandler {

    private static final String FILE_NAME = "resources/number.txt";

    public static void saveNumberToFile(int number) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println(number);
            System.out.println("Number saved to file: " + number);
        } catch (IOException e) {
            System.err.println("Error saving number to file: " + e.getMessage());
        }
    }

    public static int readNumberFromFile() {
        int number = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                number = Integer.parseInt(line);
                System.out.println("Number read from file: " + number);
            } else {
                System.out.println("File is empty. Returning default number (0).");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading number from file: " + e.getMessage());
        }
        return number;
    }

//    public static void main(String[] args) {
//        // Example usage:
//        int numberToSave = 42;
//        saveNumberToFile(numberToSave);
//
//        int readNumber = readNumberFromFile();
//        System.out.println("Number retrieved from file: " + readNumber);
//    }
}
