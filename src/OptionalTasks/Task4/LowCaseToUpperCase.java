package OptionalTasks.Task4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LowCaseToUpperCase {
    public static void main(String[] args) {

//         Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.

        try(FileWriter writer = new FileWriter("data/OptionalTasks.Task4.txt");
            FileReader reader = new FileReader("data/Data4.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line = null;
            String word = null;
            StringBuffer buffer = new StringBuffer();
            Pattern pattern = Pattern.compile(".{2,}");

            while ((line = bufferedReader.readLine()) != null) {
                Scanner scan = new Scanner(line);
                while (scan.hasNext()) {
                    word = scan.next();
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.matches()) {
                        buffer.append(matcher.group().toUpperCase() + " ");
                    } else {
                        buffer.append(word + " ");
                    }

                }
                bufferedWriter.write(buffer.toString(), 0, line.length());
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
