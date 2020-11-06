package OptionalTasks.Task2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PublicToPrivate {
    public static void main(String[] args) {
//        2.     Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

        {
            try(FileWriter writer = new FileWriter("data/Task2.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                FileReader reader = new FileReader("data/Airline.java");
                BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line = null;

                while ((line = bufferedReader.readLine()) !=null){
                    line = line.replaceAll("public", "private");
                    bufferedWriter.write(line, 0, line.length());
                    bufferedWriter.newLine();
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
