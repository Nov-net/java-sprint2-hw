import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class ReadMonthlyReport {

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


    File[] readMonthlyFileFromDirectory() { // считываем файлы в директории
        File folder = new File("C:\\Users\\Katrin\\dev\\java-sprint2-hw — копия\\monthly files");
        return folder.listFiles();
    }


    void parsingMonthlyReport (HashMap<String, Integer> monthlyExpenses, HashMap<String, Integer> monthlyRevenue, String[] lineContents) {
        // считаем и записываем в массив сумму выручки и расходов по месяцам (сумма = количество * цена за штуку)

        if (lineContents[1].equals("TRUE")) {
            monthlyExpenses.put(lineContents[0], (Integer.parseInt(lineContents[2])) * (Integer.parseInt(lineContents[3])));

        } else {
            monthlyRevenue.put(lineContents[0], (Integer.parseInt(lineContents[2])) * (Integer.parseInt(lineContents[3])));
        }
    }


    public void readMonthFileContents() { //считываем данные отчетов, записываем в две хеш-таблицы (выручка и расходы)

        try {
            for (File file : readMonthlyFileFromDirectory()) {
                HashMap<String, Integer> monthlyRevenue = new HashMap<>();
                HashMap<String, Integer> monthlyExpenses = new HashMap<>();
                if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '1')) {
                    fileContents = Files.readAllLines(file.toPath());

                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport (monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(1,monthlyRevenue);
                    allMonthlyExpenses.put(1,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '2')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(2,monthlyRevenue);
                    allMonthlyExpenses.put(2,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '3')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(3,monthlyRevenue);
                    allMonthlyExpenses.put(3,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '4')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(4,monthlyRevenue);
                    allMonthlyExpenses.put(4,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '5')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(5,monthlyRevenue);
                    allMonthlyExpenses.put(5,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '6')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(6,monthlyRevenue);
                    allMonthlyExpenses.put(6,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '7')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(7,monthlyRevenue);
                    allMonthlyExpenses.put(7,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '8')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(8,monthlyRevenue);
                    allMonthlyExpenses.put(8,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '0') && (file.getName().charAt(7) == '9')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(9,monthlyRevenue);
                    allMonthlyExpenses.put(9,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '1') && (file.getName().charAt(7) == '0')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(10,monthlyRevenue);
                    allMonthlyExpenses.put(10,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '1') && (file.getName().charAt(7) == '1')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(11,monthlyRevenue);
                    allMonthlyExpenses.put(11,monthlyExpenses);

                } else if ((file.getName().charAt(6) == '1') && (file.getName().charAt(7) == '2')) {
                    fileContents = Files.readAllLines(file.toPath());
                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport(monthlyExpenses, monthlyRevenue, lineContents);
                    }
                    allMonthlyRevenue.put(12,monthlyRevenue);
                    allMonthlyExpenses.put(12,monthlyExpenses);

                }
            }

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл. Возможно, файл отсутствует.");

        }
    }


    void writeSumInMonthly(HashMap<Integer, HashMap<String, Integer>> dataMonthly, Integer[] monthlyData) {
        //проверяем есть ли данные для сверки по месяцам, считаем общую сумму из всех файлов
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