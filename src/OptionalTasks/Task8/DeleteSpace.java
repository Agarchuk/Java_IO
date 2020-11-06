package OptionalTasks.Task8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeleteSpace {
    public static void main(String[] args) {
//        Прочитать текст Java-программы и удалить из него все «лишние» пробелы и табуляции, оставив только необходимые для разделения операторов.
    String path = "data/Data8.txt";
    List<String> text = readFile(path);
    writeFile(deleteSpace(text), path);

    }

    public static List<String> readFile (String path){
         List<String> text = null;
         try {
            text = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
             e.printStackTrace();
         }
         return text;
    }
    public static List<String> deleteSpace(List<String> text){
        List<String> newText = new ArrayList<>();
        for (String line: text) {
            newText.add(deleteFromLine(line));
        }
        return newText;
    }

    public static String deleteFromLine (String line){
        StringBuffer finishLine = new StringBuffer();
        String[] words = line.split("\\s{1,}|\\t");
        for (String word: words) {
            System.out.println(word);
            finishLine.append(word).append(" ");
        }
        String finish = finishLine.toString().replaceAll("\\s,",",");
        return finish.trim();
    }

    public static void writeFile(List<String> lines, String path){
        try(FileWriter writer = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String line: lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
