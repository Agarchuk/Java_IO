package OptionalTasks.Task7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeleteFromFile {
    public static void main(String[] args) {
// Из файла удалить все слова, содержащие от трех до пяти символов,
// но при этом из каждой строки должно быть удалено только максимальное четное количество таких слов.
    String path = "data/Data7.txt";
    readFile(path).forEach(System.out::println);
    deleteWords(path);


    }

    public static List<String> readFile(String path){
        List<String> text = null;
        try {
           text = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;


    }

    public static int countOfWrongWordsInLine(String line){
        int count = 0;
        String[] words = lineToWords(line);
        for (String word: words) {
            if(word.length()>=3 & word.length()<=5){
                count++;
            }

        };
        return count;
    }

    public static String[] lineToWords(String line){
        line.trim();
        String[] words = line.split(" ");
        return words;
    }

    public static String deleteWordsInLine (String line){
        StringBuffer buffer = new StringBuffer("");
        int countWrongWords = countOfWrongWordsInLine(line);
        String[] words = lineToWords(line);

        while (countWrongWords > 0){
            if(countWrongWords % 2 != 0 ){
                countWrongWords --;
            }
            for (String word: words) {
                if (word.length()<3 | word.length()>5){
                    buffer.append(word).append(" ");

                } else {
                    countWrongWords --;
                }

            }
        }
        return buffer.toString().trim();
    }

    public static void deleteWords(String path){
        List<String> text = new ArrayList<>();
        for (String line: readFile(path)) {
            text.add(deleteWordsInLine(line)) ;   }
        writeFile(path, text);

    }

    public static void writeFile(String path, List<String> text){
        try(FileWriter writer = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String line: text){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
