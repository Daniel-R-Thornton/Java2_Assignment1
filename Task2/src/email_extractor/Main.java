package email_extractor;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //check that args[0] contains a valid file path
        if (args.length == 0) {
            System.err.println("Please provide a file path");
            System.exit(0);
        }


        //get FilePath from arg0,
        String filePath = args[0];

        //initialize a list to hold the emails
        List<String> emails = new ArrayList<>();

        //read file and extract emails
        try {
            //initialise file reader
            var emailFile  = new FileReader(filePath);
            //initialise scanner to read file
            var emailScanner = new Scanner(emailFile);

            //loop each line while there are new lines, extract emails and add to list
            while(emailScanner.hasNextLine()) {

                //get next line
                String line = emailScanner.nextLine();

                //parse line extracting only the email
                String email = extractEmail(line);

                //if email is not null add to list
                if(email != null) {
                    emails.add(email);
                }

            }

            //close the scanner
            emailScanner.close();
            //close file reader
            emailFile.close();

        } catch (FileNotFoundException e) {
            //handle bad file paths
            System.err.println("Unable to extract emails, file not found at " + filePath);
           System.exit(0);

        } catch (IOException e) {
            //handle IO exceptions
            System.err.println("Unable to read file");
            System.exit(0);

        }

        printEmails(emails);



    }


    /**
     * Extracts an email from a line of text must be formatted as follows:
     * xxx:yyy:zzz Email is ZZZ
     * @param line String of text to extract email from
     * @return String email or null if no email found
     */
    private static String extractEmail(String line){
        //extract email from line format is
        String[] stringLines = line.split(":");
        //check that there are at least 3 elements in the array
        if(stringLines.length < 3) {
            return null;
        }
        
        return stringLines[2];
    }


    /**
     * Prints emails from a list to the console
     * @param emails List of emails to print
     */
    private static void printEmails(List<String> emails){
        for(String Email : emails){
            System.out.println(Email);
        }
    }
}
