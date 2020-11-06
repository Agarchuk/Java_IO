package OptionalTasks.Task3;

import java.io.*;

public class ReverseLines {
    public static void main(String[] args) {
//        3.     Прочитать текст Java-программы и записать в другой файл в обратном порядке символы каждой строки.

        try(FileReader reader = new FileReader("data/Airline.java");
            BufferedReader bufferedReader = new BufferedReader(reader);
            FileWriter writer = new FileWriter("data/Task3.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line = null;

            while ((line = bufferedReader.readLine()) != null ){
                StringBuffer bufferLine= new StringBuffer(line);
                bufferLine.reverse();
                line = bufferLine.toString();
                bufferedWriter.write(line, 0, line.length());
                bufferedWriter.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
