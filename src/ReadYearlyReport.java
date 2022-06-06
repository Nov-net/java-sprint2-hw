import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class ReadYearlyReport {


    Integer[][] yearlyData; // 0 - выручка, 1 - расходы
    String path;

    ReadYearlyReport () {
        yearlyData = new Integer[2][12];
        yearlyDataInitiate();
        path = "y.2021.csv";
    }

    void yearlyDataInitiate() {
        for (Integer[] yearlyDatum : yearlyData) {
            Arrays.fill(yearlyDatum, 0);
        }
    }
    void readYearlyData() {
        String[] lines = readYearFileContentsOrNull().split(System.lineSeparator());

        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");

            if (lineContents[2].equals("true")) {
                yearlyData[1][(Integer.parseInt(lineContents[0])-1)] = Integer.parseInt(lineContents[1]);

            } else {
                yearlyData[0][(Integer.parseInt(lineContents[0])-1)] = Integer.parseInt(lineContents[1]);
            }
        }

    }


    public String readYearFileContentsOrNull() {

        try {
            return Files.readString(Path.of(path));

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл. Возможно, файл отсутствует.");
            return null;
        }
    }

    void printYearlyData() {
        System.out.println("Доходы и расходы в отчете за год:");
        int a = 0;
        for (int j = 0; j < yearlyData[a].length; j++) {
            if ((yearlyData[0][j] + yearlyData[1][j]) != 0) {
                System.out.println("Месяц " + (j + 1) + ": ");
                System.out.println("Выручка:");
                System.out.println(yearlyData[0][j] + " руб.");
                System.out.println("Расходы:");
                System.out.println(yearlyData[1][j] + " руб.");
                System.out.println(" ");
            }
        }
    }

    public void readYearlyReportName(){
        char[] chArray = path.toCharArray();
        System.out.print(chArray[2]);
        System.out.print(chArray[3]);
        System.out.print(chArray[4]);
        System.out.print(chArray[5]);
        System.out.println();
    }
}
