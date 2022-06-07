import java.util.HashMap;

public class AnalyzeMonthlyReport {

    String[] monthName = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};


    void checkReports(Integer[] monthlyData, Integer[] yearlyData1) { // сверяем годов и месячные отчеты
        String x = null;
        for (int j = 0; j < yearlyData1.length; j++) {

            if ((yearlyData1[j] - monthlyData[j]) !=0) {
                System.out.println("Выявлены отклонения в месяце " + (j + 1) + " на сумму: " + (yearlyData1[j] - monthlyData[j]));
                System.out.println("В годовом отчете указано: " + yearlyData1[j]);
                System.out.println("В месячном отчете указано: " + monthlyData[j]);
                x = "Выявлены расхождения";

            }

        }

        if (x == null) {
            System.out.println("Сверка отчетов прошла успешно, отклонения не выявлены");
        }

    }


    public Integer getSumFromAllMonths(Integer[] monthlyData) { // считаем сумму выручки или расходов за все месяца
        int sumFromAllMonths = 0;
        for (Integer monthlyDatum : monthlyData) {
            sumFromAllMonths += monthlyDatum;
        }

        return sumFromAllMonths;

    }


    public void getMaxInMonthly(HashMap<Integer, HashMap<String, Integer>> dataMonthly) { // считаем максимумальный доход и расход за месяц

        for (Integer month : dataMonthly.keySet()) {
            System.out.println(monthName[(month-1)] + ":");
            HashMap<String, Integer> valueMonth = dataMonthly.get(month);
            int maxValue = 0;
            String maxName = "";
            for (String name : valueMonth.keySet()) {
                if (valueMonth.get(name) > maxValue) {
                    maxValue = valueMonth.get(name);
                    maxName = name;
                }
            }
            System.out.println(maxName + " на сумму " + maxValue + " руб.");
            System.out.println();

        }

    }


}
