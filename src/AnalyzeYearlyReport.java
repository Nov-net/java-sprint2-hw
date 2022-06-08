
public class AnalyzeYearlyReport {
    String[] monthName = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

    // считаем сумму за год
    public int getSumYears(Integer[][] yearlyData1) {
        int sum = 0;
        for (Integer[] integers : yearlyData1)
            for (Integer integer : integers) {
                sum += integer;
            }
        final int sumYear = sum; // добавила final
        return sumYear;
    }

    // считаем среднее за год
    public int getYearlyAverage(Integer[] yearlyData1) {
        int sum = 0;
        for (Integer integer : yearlyData1) {
            sum += integer;
        }
        final int average = sum / yearlyData1.length;
        return average;
    }

    // считаем прибыль по месяцам
    public void getAndPrintMonthlyProfit(Integer[][] yearlyData1) {
        int profit;
        int j = 0;
        System.out.println("Прибыль составила: ");
        for (int i = 0; i < yearlyData1[j].length; i++) {
            if (yearlyData1[0][i] != 0 || yearlyData1[1][i] != 0 ) {
                profit = yearlyData1[0][i] - yearlyData1[1][i];
                System.out.println(monthName[i] + ": " + profit + " руб.");

            }
        }
        System.out.println();
    }


}
