import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class ReadMonthlyReport {

    HashMap<String, Integer> monthlyRevenue1 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue2 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue3 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue4 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue5 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue6 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue7 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue8 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue9 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue10 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue11 = new HashMap<>();
    HashMap<String, Integer> monthlyRevenue12 = new HashMap<>();

    HashMap<String, Integer> monthlyExpenses1 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses2 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses3 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses4 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses5 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses6 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses7 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses8 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses9 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses10 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses11 = new HashMap<>();
    HashMap<String, Integer> monthlyExpenses12 = new HashMap<>();

    HashMap<Integer, HashMap<String, Integer>> allMonthlyRevenue;
    HashMap<Integer, HashMap<String, Integer>> allMonthlyExpenses;

    List<String> fileContents;
    Integer[] monthlyRevenueData;
    Integer[] monthlyExpensesData;
    void monthlyDataNull(Integer[] data) {
        Arrays.fill(data, 0);
    }

    ReadMonthlyReport (){
        allMonthlyRevenue = new HashMap<>();
        allMonthlyExpenses = new HashMap<>();
        monthlyRevenueData = new Integer[12];
        monthlyExpensesData = new Integer[12];
        monthlyDataNull(monthlyRevenueData);
        monthlyDataNull(monthlyExpensesData);
    }


    File[] readMonthlyFileFromDirectory() {
        File folder = new File("C:\\Users\\Katrin\\dev\\java-sprint2-hw\\monthly files");
        return folder.listFiles();
    }


    void parsingMonthlyReport (HashMap<String, Integer> monthlyExpenses, HashMap<String, Integer> monthlyRevenue, String[] lineContents) {

        if (lineContents[1].equals("TRUE")) {
            monthlyExpenses.put(lineContents[0], (Integer.parseInt(lineContents[2])) * (Integer.parseInt(lineContents[3])));

        } else {
            monthlyRevenue.put(lineContents[0], (Integer.parseInt(lineContents[2])) * (Integer.parseInt(lineContents[3])));
        }
    }


    public void readMonthFileContents() {

        try {
            for (File file : readMonthlyFileFromDirectory()) {
                if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '1')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport (monthlyExpenses1, monthlyRevenue1, lineContents);
                    }
                    allMonthlyRevenue.put(1,monthlyRevenue1);
                    allMonthlyExpenses.put(1,monthlyExpenses1);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '2')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses2, monthlyRevenue2, lineContents);
                    }
                    allMonthlyRevenue.put(2,monthlyRevenue2);
                    allMonthlyExpenses.put(2,monthlyExpenses2);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '3')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses3, monthlyRevenue3, lineContents);
                    }
                    allMonthlyRevenue.put(3,monthlyRevenue3);
                    allMonthlyExpenses.put(3,monthlyExpenses3);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '4')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses4, monthlyRevenue4, lineContents);
                    }
                    allMonthlyRevenue.put(4,monthlyRevenue4);
                    allMonthlyExpenses.put(4,monthlyExpenses4);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '5')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses5, monthlyRevenue5, lineContents);
                    }
                    allMonthlyRevenue.put(5,monthlyRevenue5);
                    allMonthlyExpenses.put(5,monthlyExpenses5);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '6')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses6, monthlyRevenue6, lineContents);
                    }
                    allMonthlyRevenue.put(6,monthlyRevenue6);
                    allMonthlyExpenses.put(6,monthlyExpenses6);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '7')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses7, monthlyRevenue7, lineContents);
                    }
                    allMonthlyRevenue.put(7,monthlyRevenue7);
                    allMonthlyExpenses.put(7,monthlyExpenses7);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '8')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses8, monthlyRevenue8, lineContents);
                    }
                    allMonthlyRevenue.put(8,monthlyRevenue8);
                    allMonthlyExpenses.put(8,monthlyExpenses8);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '9')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses9, monthlyRevenue9, lineContents);
                    }
                    allMonthlyRevenue.put(9,monthlyRevenue9);
                    allMonthlyExpenses.put(9,monthlyExpenses9);

                } else if ((file.getName().charAt(6) == '1') && (file.getName().charAt(7) == '0')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses10, monthlyRevenue10, lineContents);
                    }
                    allMonthlyRevenue.put(10,monthlyRevenue10);
                    allMonthlyExpenses.put(10,monthlyExpenses10);

                } else if ((file.getName().charAt(6) == '1') && (file.getName().charAt(7) == '1')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses11, monthlyRevenue11, lineContents);
                    }
                    allMonthlyRevenue.put(11,monthlyRevenue11);
                    allMonthlyExpenses.put(11,monthlyExpenses11);

                } else if ((file.getName().charAt(6) == '1') && (file.getName().charAt(7) == '2')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses12, monthlyRevenue12, lineContents);
                    }
                    allMonthlyRevenue.put(12,monthlyRevenue12);
                    allMonthlyExpenses.put(12,monthlyExpenses12);

                }
            }

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл. Возможно, файл отсутствует.");

        }
    }


    void writeSumInMonthly(HashMap<Integer, HashMap<String, Integer>> dataMonthly, Integer[] monthlyData) {

        for (Integer month : dataMonthly.keySet()) {
            HashMap<String, Integer> valueMonth = dataMonthly.get(month);
            int sumInMonthly = 0;

            for (String name : valueMonth.keySet()) {
                sumInMonthly += valueMonth.get(name);

            }
            monthlyData[(month - 1)] = sumInMonthly;
        }
    }

}