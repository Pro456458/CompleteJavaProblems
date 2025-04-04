package topic.corejavaconcepts.iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReadWriteDataFromFile {

    public static void main(String[] args) {

        Path file1 = Paths.get("C:\\Dev\\workspace\\IJ\\Incubation2025\\JavaIncubation\\src\\topic\\corejavaconcepts\\iostream\\simple1.txt");
        Path file2 = Paths.get("C:\\Dev\\workspace\\IJ\\Incubation2025\\JavaIncubation\\src\\topic\\corejavaconcepts\\iostream\\simple2.txt");
        Path outputFile = Paths.get("C:\\Dev\\workspace\\IJ\\Incubation2025\\JavaIncubation\\src\\topic\\corejavaconcepts\\iostream\\output.txt");

        BinaryOperator<String> operator = (s1, s2) -> s1 + s2;

        ReadWriteDataFromFile readWriteDataFromFile = new ReadWriteDataFromFile();
        try {
            readWriteDataFromFile.merge(file1, file2, outputFile, operator);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



    public Path merge(Path file1, Path file2 , Path outputFile, BinaryOperator<String> operator) throws IOException {

        List<String> stringList1 = Files.readAllLines(file1);
        int file1LineSize = stringList1.stream().toList().size();

        List<String> stringList2 = Files.readAllLines(file2);
        int file2LineSize =stringList2.stream().toList().size();

        if(file1LineSize != file2LineSize) {
            throw new IllegalArgumentException("Both files should have same number of lines");
        }

        try (BufferedReader bufferedReader1 = Files.newBufferedReader(file1);
             BufferedReader bufferedReader2 = Files.newBufferedReader(file2);

             BufferedWriter bufferedWriter = Files.newBufferedWriter(outputFile)) {

            String line1;
            String line2;

            while ((line1 = bufferedReader1.readLine()) != null && (line2 = bufferedReader2.readLine()) != null) {
                String apply = operator.apply(line1, line2);
                bufferedWriter.write(apply);
                bufferedWriter.newLine();
            }
        }

        return outputFile;


    }

}
