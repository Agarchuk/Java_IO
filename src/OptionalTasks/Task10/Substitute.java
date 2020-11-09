package OptionalTasks.Task10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Substitute {
    public static void main(String[] args) {
        //Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.
        String path = "data/Data7.txt";
        List<String> text = readFile(path);
        List<String> newText = substitute(text);
        writeFile(newText, "data/out10.txt");
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

    public static List<String> substitute(List<String> text) {
        List<String> words = new ArrayList<>();
        List<String> newText = new ArrayList<>();
        for (String line : text) {
            words = lineToWords(line);
            line = line.replaceAll(words.get(words.size()-1), words.get(0));
            line = line.replaceFirst(words.get(0), words.get(words.size()-1));
            newText.add(line);
        }
        return newText;
    }

    public static  ArrayList<String> lineToWords(String line){
        ArrayList<String> words = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, " ,:.");
        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }
        return words;
    }
    public static void writeFile(List<String> text, String path){
        try(FileWriter writer = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (String line: text) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
