package MainTask;

import java.io.File;
import java.util.Scanner;

public class Dir {
    public static void main(String[] args) {
        //Реализовать программу которая будет получать в качестве аргумента командной строки путь к директории, например "D:/movies".
        // Записать в текстовый файл структуру папок и файлов в виде, похожем на выполнение программы tree /F.

        String path = readDirectory();
        showStructure(path);



    }
    public static String readDirectory(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к директории: ");
        String path = scanner.nextLine();
        return path;
    }


    public static void showStructure(String path){
        File file = new File(path);
        String[] structure = null;
        if(file.exists()){
            if(file.isDirectory()) {
                showStructureOfDirectory(file);
            }
        }
    }

    public static void showStructureOfDirectory(File file){
        for (File item: file.listFiles()){
            if(item.isDirectory()){
                System.out.println("|-----" + item.getName());
                String str = file+item.getName();
            } else {
                System.out.println("|       " + item.getName());
            }
        }
    }


}
