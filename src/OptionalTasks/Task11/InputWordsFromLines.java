package OptionalTasks.Task11;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputWordsFromLines {
    public static void main(String[] args) {
//        Ввести из текстового файла, связанного с входным потоком, последовательность строк.
//        Выбрать и сохранить m последних слов в каждой из по-следних n строк.
        String path = "data/Data7.txt";
        List<String> lines = readStream(path);
        output(lines);
    }
    public static List<String> readStream(String path){
        List<String> lines = new ArrayList<>();
        try(FileInputStream file = new FileInputStream(path)) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static String[] lineToWords(String line){
        String[] words = null;
        words = line.split("[\\s.:,;]");
   //     System.out.println(Arrays.toString(words));
        return words;
    }
    public static void output(List<String> lines){
        String[] words = null;
        int n = inputN(lines.size());
        int m = inputM();
        try {
            for (int i = lines.size()-n; i<lines.size(); i++){
                words = lineToWords(lines.get(i));
                try {
                    for (int j = words.length - m; j < words.length; j++) {
                        System.out.print(words[j] + " ");
                        if (m > words.length) {
                            throw new ArrayIndexOutOfBoundsException("\n\"Количество слов превышено!\"");
                        }
                    }
                }catch (Exception e){
                    System.out.println("\nКоличество строк превышено!");
                }

                System.out.print("\n");
            }
        } catch (Exception e){
            System.out.println("\nКоличество строк превышено!");
        }


    }
    public static int inputM(){
        Scanner scanner = new Scanner(System.in);
        int M =0;
            System.out.print("Введите количество последних слов M -> ");
            M = scanner.nextInt();
        return M;
    }

    public static int inputN(int numOfLines){
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        System.out.print("Введите количество последних строк N (максимум: "+numOfLines+")-> ");
        N = scanner.nextInt();
        return N;
    }
}
