import java.io.File;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* Reads lines of integers from an input file, calculates their sum,
* and writes the results or error messages to an output file.
*
* @author carel
* @version 1.0
* @since 2026-10-19
*/
public final class FileIO {

   /**
    * Private constructor to prevent class instantiation.
    */
   private FileIO() {
       // Prevents instantiation
   }

   /**
    * Main entry point of the program.
    *
    * @param args Command line arguments
    */
   public static void main(final String[] args) {
       final String errorEmpty =
           "Error: No integers were found on this line.";

       try {
           // Open input and output files
           File inputFile = new File("Unit2-02-input.txt");
           File outputFile = new File("Unit2-02-output.txt");

           Scanner fileScanner = new Scanner(inputFile);
           PrintWriter writer = new PrintWriter(outputFile);

           // Loop through each line in the input file
           while (fileScanner.hasNextLine()) {
               String line = fileScanner.nextLine();

               // Check if the line is empty
               if (line.trim().isEmpty()) {
                   writer.println(errorEmpty);
                   continue;
               }

               // Scanner to read through the current line
               Scanner lineScanner = new Scanner(line);
               int sum = 0;

               try {
                   // Read each integer on the line and add to sum
                   while (lineScanner.hasNext()) {
                       sum += lineScanner.nextInt();
                   }
                   // Write total sum to output file
                   writer.println(sum);

               } catch (InputMismatchException e) {
                   // Catch text or non-integer errors
                   String badinput = lineScanner.next();
                   writer.println("Error: " + badinput + " is not a number");
               }
           }

           // Close file resources
           fileScanner.close();
           writer.close();
           System.out.println("Done! Output saved.");

       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
   }
}
