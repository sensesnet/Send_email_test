package com.readAcctxt;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * read accounts.txt
 */
public class Readtxt {
    static Logger logger = Logger.getLogger(Readtxt.class.getName());
    //Create a file object

    private File file = new File("src/main/resources/accounts.txt");
    private Map<String, String> hashmap = new HashMap<String, String>();

    public Map<String, String> read() throws FileNotFoundException {

        try {
            //file read in buffer
            logger.info(" - read file with accounts");
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //read line in file
                String s;
                hashmap.clear();
                while ((s = in.readLine()) != null) {
                    char[] arr = s.toCharArray();
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == ';') {
                            String userName = s.substring(0, i);
                            String password = s.substring(i + 1, arr.length);
                            System.out.print(userName + "  ");
                            System.out.println(password);
                            hashmap.put(userName,password);
                        }
                    }
                }
            } finally {
                //close file
                in.close();
                logger.info(" - close file with accounts");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //return line from file
        return hashmap;
    }
}
