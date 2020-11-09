package OptionalTasks.Task12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Search {
    public static void main(String[] args) {
        //Из текстового файла ввести последовательность строк.
        // Выделить отдельные слова, разделяемые пробелами.
        // Написать метод поиска слова по образцу-шаблону.
        // Вывести найденное слово в другой файл.

        String path = "data/Data7.txt";
        List<String> strings = readFile(path);
        System.out.println(strings);
        ArrayList<String> words = selectWords(strings);
        ArrayList<String> findedWords = findWord(words);
        System.out.println(findedWords);
        writeFile(words);
    }

    public static List<String> readFile(String path){
        List<String> strings = null;
        try {
            strings = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }


    public static ArrayList<String> selectWords(List<String> strings){
        ArrayList<String> allWords = new ArrayList<>();
        for (String line: strings) {
            String[] words = line.split("[ ,.;:]");
            for (String word : words) {
                allWords.add(word.toLowerCase());
            }
        }
        return allWords;
    }

    public static ArrayList<String> findWord(ArrayList<String> allWords){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> findedWords = new ArrayList<>();
        System.out.print("Введите шаблон для поиска: ");
        String template = scanner.nextLine();
        for (String word: allWords){
            if(word.matches(template)){
                findedWords.add(word);
            }
        }
        return findedWords;
    }

    public static void writeFile(ArrayList<String> findedWords){
        try(FileWriter writer = new FileWriter("data/Finded.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String word:findedWords){
                bufferedWriter.write(word+"; ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
