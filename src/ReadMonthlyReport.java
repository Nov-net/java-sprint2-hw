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
    String directory = "C:\\Users\\Katrin\\dev\\java-sprint2-hw — копия\\monthly files";

    ReadMonthlyReport (){
        allMonthlyRevenue = new HashMap<>();
        allMonthlyExpenses = new HashMap<>();
        monthlyRevenueData = new Integer[12];
        monthlyExpensesData = new Integer[12];
        monthlyDataNull(monthlyRevenueData);
        monthlyDataNull(monthlyExpensesData);
    }

    // считываем файлы в директории
    File[] readMonthlyFileFromDirectory() {
        File folder = new File(directory);
        return folder.listFiles();
    }


    /*
    Ростислав, привет!
    По данному комментарию нужна помощь:
    --Для классов, которые используются в HashMap'ах, необходимо переопределить hashcode и equals, чтобы избежать коллизий

    Прочитала всю теорию, которую нашла, но так и не поняла, как это реализовать здесь в коде.
     В итоге сделала, как смогла))
     Добавила метод hashCode() и проверку equals() на hashCode()

     Буду очень признательна за помощь!
     */


    public int hashCode(int one) {
        return (one);
    }

    // считаем и записываем в массив сумму выручки и расходов по месяцам (сумма = количество * цена за штуку)
    void parsingMonthlyReport (HashMap<String, Integer> monthlyExpenses, HashMap<String, Integer> monthlyRevenue, String[] lineContents) {
        int one;
        if (lineContents[1].equals("TRUE")) {
            one = 1;
        } else if (lineContents[1].equals("FALSE")){
            one = 2;
        } else {
            one = 3;
        }

        if (hashCode(one) == 1) {
            monthlyExpenses.put(lineContents[0], (Integer.parseInt(lineContents[2])) * (Integer.parseInt(lineContents[3])));

        } else if (hashCode(one) == 2) {
            monthlyRevenue.put(lineContents[0], (Integer.parseInt(lineContents[2])) * (Integer.parseInt(lineContents[3])));
        } else {
            System.out.println("Данные равны нулю");
        }

    }

    //считываем данные отчетов, записываем в две хеш-таблицы (выручка и расходы)
    /*
    Изменила считывание имени файла с charAt() на метод substring()
     */
    public void readMonthFileContents() {

        try {
            for (File file : readMonthlyFileFromDirectory()) {
                fileContents = Files.readAllLines(file.toPath());

                HashMap<String, Integer> monthlyRevenue = new HashMap<>();
                HashMap<String, Integer> monthlyExpenses = new HashMap<>();
                int key = Integer.parseInt(file.getName().substring(6, 8));

                    for (int i = 1; i < fileContents.size(); i++) {
                        String[] lineContents = fileContents.get(i).split(",");
                        parsingMonthlyReport (monthlyExpenses, monthlyRevenue, lineContents);
                    }
                allMonthlyRevenue.put(key,monthlyRevenue);
                allMonthlyExpenses.put(key,monthlyExpenses);
            }
            writeSumInMonthly(allMonthlyRevenue, monthlyRevenueData);
            writeSumInMonthly(allMonthlyExpenses, monthlyExpensesData);

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл. Возможно, файл отсутствует.");
            System.out.println("Проверьте наличие файла в директории " + directory);

        }
    }

    //проверяем есть ли данные для сверки по месяцам, считаем общую сумму из всех файлов
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