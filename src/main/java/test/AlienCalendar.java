package test;

/*
*
* Alien Calendar - eQ Technologic
* Modular code with accurate formatting (spaces only, no tabs)
*
*/

public class AlienCalendar {

    public static void main(String[] args) {
        PrintMonths(2718, 9, 122);
    }

    public static void PrintMonths(int startYear, int startMonth, int numberOfMonths) {
        int startDayIndex = FirstMonthStartsOn() - 1; // Xo index = 1 => zero-based index = 0

        for (int i = 0; i < numberOfMonths; i++) {
            int monthIndex = (startMonth - 1 + i) % 11;
            int yearOffset = (startMonth - 1 + i) / 11;
            int currentYear = startYear + yearOffset;

            int daysInMonth = getMonthDays(currentYear, monthIndex);

            printHeader(monthIndex, currentYear);
            printSeparator();
            printWeekdays();
            printSeparator();
            printMonthDays(currentYear, monthIndex, startDayIndex, daysInMonth);
            printSeparator();
            System.out.println();

            startDayIndex = (startDayIndex + daysInMonth) % 10;
        }
    }

    public static int FirstMonthStartsOn() {
        return 2; // Xo
    }

    static final String[] WEEKDAYS = {"Za", "Xo", "Cu", "Vo", "Bi", "Ne", "Ma", "Lu", "Ki", "Kl"};
    static final String[] MONTHS = {"Ra", "Ta", "Ut", "Ip", "Ok", "Py", "Ar", "Sy", "Du", "Fi", "Gr"};
    static final int[] MONTH_DAYS = {28, 39, 26, 29, 31, 29, 33, 34, 35, 27, 43};

    private static int getMonthDays(int year, int monthIndex) {
        if (monthIndex == 8 && year % 11 == 0) {
            return 34; // Du in leap year (with # mark)
        }
        return MONTH_DAYS[monthIndex];
    }

    private static void printHeader(int monthIndex, int year) {
        System.out.printf(" %s %d\n", MONTHS[monthIndex], year);
    }

    private static void printSeparator() {
        System.out.println("+----+----+----+----+----+----+----+----+----+----+");
    }

    private static void printWeekdays() {
        System.out.print("|");
        for (String day : WEEKDAYS) {
            System.out.printf(" %s |", day);
        }
        System.out.println();
    }

    private static void printMonthDays(int year, int monthIndex, int startDayIndex, int totalDays) {
        int dayCounter = 1;
        boolean isLeapYearDu = (monthIndex == 8 && year % 11 == 0);

        while (dayCounter <= totalDays) {
            System.out.print("|");
            for (int i = 0; i < 10; i++) {
                if (dayCounter == 1 && i < startDayIndex) {
                    System.out.print("    |");
                } else if (dayCounter <= totalDays) {
                    if (isLeapYearDu && dayCounter == totalDays) {
                        System.out.printf("%3d#|", dayCounter); // mark last day of Du in leap year
                    } else {
                        System.out.printf("%3d |", dayCounter);
                    }
                    dayCounter++;
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
            startDayIndex = 0; // only first row may be offset
        }
    }
}

