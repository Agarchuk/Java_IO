package OptionalTasks.Task6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DetermineType {
    public static void main(String[] args) {

        //Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить все данные, тип которых вводится из командной строки.

        try(FileReader reader = new FileReader("data/Data6.txt")) {

            Scanner scan = new Scanner(reader);

            while (scan.hasNext()){
                if (scan.hasNextBoolean()){
                    System.out.println("boolean: " + scan.nextBoolean());
                } else if(scan.hasNextInt()){
                    System.out.println("int: " + scan.nextInt());
                } else if(scan.hasNextDouble()){
                    System.out.println("double: " + scan.nextDouble());

                } else if(scan.hasNext()){
                    String str = scan.next();
                    if(str.length() == 1){
                        System.out.println("char: " + str);
                    } else{
                        System.out.println("string: " + str);
                    }

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
