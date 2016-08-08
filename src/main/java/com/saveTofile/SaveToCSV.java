package com.saveTofile;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SaveToCSV {

    private String outputFile = "src/logs/accounts.csv";
    private String fileHeader = "userMail,password";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    static Logger logger = Logger.getLogger(SaveToCSV.class.getName());

    public void saveToSCV(String username,String password) {
        logger.info(" - save in csv");
        logger.info(" - before we open the file check to see if it already exists");
        // before we open the file check to see if it already exists
        boolean alreadyExists = new File(outputFile).exists();

        try {
            // use FileWriter constructor that specifies open for appending
            FileWriter csvOutput = new FileWriter(outputFile,true);

            // if the file didn't already exist then we need to write out the header line
            if (!alreadyExists) {
                csvOutput.append(fileHeader);
                csvOutput.append('\n');
            }
            // else assume that the file already has the correct header line
            logger.info(" - write out a few records");
            // write out a few records
            csvOutput.append(username);
            csvOutput.append(COMMA_DELIMITER);
            csvOutput.append(password);
            csvOutput.append(NEW_LINE_SEPARATOR);
            csvOutput.close();
            logger.info(" - close file");
            System.out.println("Account was saved in CSV");
        } catch (IOException e) {
            logger.error(" - printStackTrace exception");
            e.printStackTrace();
        }

    }
}
