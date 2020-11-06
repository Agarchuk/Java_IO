package OptionalTasks.Task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class createFile {
    public static void main(String[] args) {
//        1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.

        File dir = new File("data");
        dir.mkdir();

        try(FileWriter file = new FileWriter("data/File.txt")){
            file.write(String.valueOf(sortArray(createArrayList(10))));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> createArrayList(int count){
        ArrayList<Integer> array = new ArrayList<Integer>(count);
        for (int i = 0; i<count; i++){
            array.add((int)(Math.random()*10));
        }
        return array;
    }

    public static ArrayList<Integer> sortArray(ArrayList<Integer> array){
        Collections.sort(array);
        return array;
    }
}
