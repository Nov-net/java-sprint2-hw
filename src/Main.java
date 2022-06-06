import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        ReadYearlyReport readYearlyReport = new ReadYearlyReport();
        ReadMonthlyReport readMonthlyReport = new ReadMonthlyReport();
        AnalyzeMonthlyReport analyzeMonthlyReport = new AnalyzeMonthlyReport();
        AnalyzeYearlyReport analyzeYearlyReport = new AnalyzeYearlyReport();


        while (true) {
            menu.printMenu();
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    readMonthlyReport.readMonthFileContents();
                    readMonthlyReport.writeSumInMonthly(readMonthlyReport.allMonthlyRevenue, readMonthlyReport.monthlyRevenueData);
                    readMonthlyReport.writeSumInMonthly(readMonthlyReport.allMonthlyExpenses, readMonthlyReport.monthlyExpensesData);
                    break;

                case 2:
                    readYearlyReport.readYearlyData();
                    break;

                case 3:
                    if ((analyzeMonthlyReport.getSumFromAllMonths(readMonthlyReport.monthlyRevenueData) != 0)
                        && (analyzeMonthlyReport.getSumFromAllMonths(readMonthlyReport.monthlyExpensesData) != 0)
                        && (analyzeYearlyReport.getSumYears(readYearlyReport.yearlyData) != 0)) {

                        System.out.println("Сравнение данных по выручке:");
                        analyzeMonthlyReport.checkReports(readMonthlyReport.monthlyRevenueData, readYearlyReport.yearlyData[0]);
                        System.out.println();

                        System.out.println("Сравнение данных по расходам:");
                        analyzeMonthlyReport.checkReports(readMonthlyReport.monthlyExpensesData, readYearlyReport.yearlyData[1]);
                        System.out.println();

                    }  else if ((analyzeMonthlyReport.getSumFromAllMonths(readMonthlyReport.monthlyRevenueData) == 0)
                        && (analyzeMonthlyReport.getSumFromAllMonths(readMonthlyReport.monthlyExpensesData) == 0)) {

                        System.out.println("Считайте отчеты за месяц");
                        System.out.println();

                    } else {
                        System.out.println("Считайте годовой отчет");
                        System.out.println();

                    }
                    break;

                case 4:
                    if ((analyzeMonthlyReport.getSumFromAllMonths(readMonthlyReport.monthlyRevenueData) != 0)
                            && (analyzeMonthlyReport.getSumFromAllMonths(readMonthlyReport.monthlyExpensesData) != 0)) {

                        System.out.println("Максимальная выручка:");
                        analyzeMonthlyReport.getMaxInMonthly(readMonthlyReport.allMonthlyRevenue);
                        System.out.println("Максимальные затраты:");
                        analyzeMonthlyReport.getMaxInMonthly(readMonthlyReport.allMonthlyExpenses);

                    }  else {

                        System.out.println("Считайте отчеты за месяц");
                        System.out.println();

                    }

                    break;

                case 5:
                    if (analyzeYearlyReport.getSumYears(readYearlyReport.yearlyData) != 0) {
                        System.out.print("Год: ");
                        readYearlyReport.readYearlyReportName();
                        analyzeYearlyReport.getAndPrintMonthlyProfit(readYearlyReport.yearlyData);
                        System.out.println("Средняя выручка: " +
                                analyzeYearlyReport.getYearlyAverage(readYearlyReport.yearlyData[0]) + " руб. в месяц");
                        System.out.println();
                        System.out.println("Средний расход: " +
                                analyzeYearlyReport.getYearlyAverage(readYearlyReport.yearlyData[1]) + " руб. в месяц");
                        System.out.println();

                    }  else {

                        System.out.println("Считайте годовой отчет");
                        System.out.println();

                    }
                    break;

                case 0:
                    System.out.println("Программа завершена");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Извините, такой команды пока нет");
                    break;
            }

        }

    }
}
