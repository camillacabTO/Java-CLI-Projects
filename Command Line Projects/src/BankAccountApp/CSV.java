package BankAccountApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSV {

    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<String[]>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String[] dataRow;

            while ((line = reader.readLine()) != null) {
                dataRow = line.split(",");
                data.add(dataRow);
            }
        } catch (Exception e) {
            System.out.println("Could not find file");
            e.printStackTrace();
        }
        return data;
    }
}
