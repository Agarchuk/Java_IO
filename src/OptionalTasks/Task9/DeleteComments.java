package OptionalTasks.Task9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteComments {
    public static void main(String[] args) {
        //Из текста Java-программы удалить все виды комментариев.
        // 1. //
        // 2. /*   */
        String path = "data/Data9.txt";
        List<String> text = readFile(path);
        writeFile(deleteComments(readFile(path)), path);

    }

    public static List<String> readFile(String path) {
        List<String> text = null;
        try {
            text = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static List<String> deleteComments(List<String> text) {
        List<String> newText = new ArrayList<>();
        for (int i = 0; i < text.size(); i++) {
            if(text.get(i).matches(".+\\/\\/.*")) {
                newText.add(text.get(i).replaceAll("\\/\\/.*", ""));
            }else if (text.get(i).matches("\\/\\/.+")) {
                i++;
            }else if (text.get(i).matches("\\/\\*.*")) {
                while (!text.get(i).matches("(\\n*.*)*\\*\\/")) {
                    i++;
                }
            }else {
                newText.add(text.get(i));
            }


        }
        return newText;
    }

    public static void writeFile(List<String> text, String path){
        try(FileWriter writer = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            for (String line: text) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

