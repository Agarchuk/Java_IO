package OptionalTasks.Task9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DeleteComments {
    public static void main(String[] args) {
        //Из текста Java-программы удалить все виды комментариев.
        // 1. //
        // 2. /*   */
        String path = "data/Data9.txt";
        System.out.println(readFile(path));


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
}
