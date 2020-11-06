package OptionalTasks.Task5;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToLowerCaseByMark {
    public static void main(String[] args) {
//        5.     В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов, которые имеют средний балл более 7.
        try (FileReader reader = new FileReader("data/StudentsWithMarks");
             BufferedReader bufferedReader = new BufferedReader(reader);
             FileWriter writer = new FileWriter("data/tmp.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line = null;
            Pattern pattern = Pattern.compile("\\d");
            while ((line = bufferedReader.readLine()) != null) {
                double sum = 0;
                String[] secondNameAndMarks = line.split("\\s");
                for (String elem : secondNameAndMarks) {
                    Matcher matcher = pattern.matcher(elem);
                    if (matcher.matches()) {
                        sum += Integer.valueOf(matcher.group());
                    }
                }
                if ((sum / (secondNameAndMarks.length - 1) > 7)) {
                    line = line.replaceFirst("\\D+", (secondNameAndMarks[0].toUpperCase()) + " ");
                }
                    bufferedWriter.write(line, 0, line.length());
                    bufferedWriter.newLine();

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try(FileReader reader1 = new FileReader("data/tmp.txt");
            BufferedReader bufferedReader1 = new BufferedReader(reader1);
            FileWriter writer1 = new FileWriter("data/StudentsWithMarks");
            BufferedWriter bufferedWriter1 = new BufferedWriter(writer1)) {

            String line = null;
            while ((line = bufferedReader1.readLine()) != null){
                bufferedWriter1.write(line, 0, line.length());
                bufferedWriter1.newLine();
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("data/tmp.txt");
        file.delete();
    }
}


