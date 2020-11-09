package OptionalTasks.Task13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhonesAndOwners {
    public static void main(String[] args) {
        // Сохранить в файл, связанный с выходным потоком, записи о телефонах и их вла-дельцах.
        // Вывести в файл записи, телефоны в которых начинаются на k и на j.
        String path = "data/PhonesAndOwners.txt";
        ArrayList<String> text = reafFile(path);
        String pattern = inputNumbers();
        ArrayList<String> newText = divide(text, pattern);
        outputFile(newText);


    }
    public static ArrayList<String> reafFile(String path){
        ArrayList<String> text = new ArrayList<>();
        try(FileInputStream file = new FileInputStream(path)) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                text.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static String inputNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите две цифры, с которых будут начинаться номера:");
        System.out.print("Первая цифра: ");
        int first = scanner.nextInt();
        System.out.print("Вторая цифра: ");
        int second = scanner.nextInt();
        String pattern = "["+String.valueOf(first)+String.valueOf(second)+"]"+".*";
        return pattern;
    }

    public static ArrayList<String> divide(ArrayList<String> lines, String pattern) {
        ArrayList<String> newText = new ArrayList<>();
        for (String line : lines) {
            String[] words = line.split(": ");
            if (words[1].matches(pattern)) {
                newText.add(line);
            }
        }
        return newText;
    }

    public static void outputFile(ArrayList<String> text){
            try(FileOutputStream outputStream = new FileOutputStream("data/phones.txt");) {
                for(String line: text){
                    outputStream.write(line.getBytes());
                    outputStream.write("\n".getBytes());
                }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
