package test;

public class AlienCalender1 {

    public static void main(String[] args) {
        PrintMonths(2718, 9, 121);
    }

    public static void PrintMonths(int startYear, int startMonth, int numberOfMonths) {
        int startDayIndex = FirstMonthStartsOn() - 1;

        for (int i = 0; i < numberOfMonths; i++) {
            int absoluteMonthNumber = (startMonth - 1) + i;
            int monthIndex = absoluteMonthNumber % 11;
            int yearOffset = absoluteMonthNumber / 11;
            int currentYear = startYear + yearOffset;

            boolean isLeapDu = isLeapDu(absoluteMonthNumber, monthIndex);

            int daysInMonth = getDays(monthIndex);
            String monthName = MONTHS[monthIndex];

            printMonthHeader(monthName, currentYear);
            printBorder();
            printWeekdays();
            printBorder();
            printMonthBody(startDayIndex, daysInMonth, isLeapDu);
            printBorder();
            System.out.println();

            int daysUsed = isLeapDu ? daysInMonth - 1 : daysInMonth;
            startDayIndex = (startDayIndex + daysUsed) % 10;
        }
    }

    public static int FirstMonthStartsOn() {
        return 2; // Xo
    }

    static final String[] WEEKDAYS = {"Za", "Xo", "Cu", "Vo", "Bi", "Ne", "Ma", "Lu", "Ki", "Kl"};
    static final String[] MONTHS = {"Ra", "Ta", "Ut", "Ip", "Ok", "Py", "Ar", "Sy", "Du", "Fi", "Gr"};
    static final int[] DEFAULT_DAYS = {28, 39, 26, 29, 31, 29, 33, 34, 35, 27, 43};

    private static boolean isLeapDu(int absoluteMonthNumber, int monthIndex) {
        // Leap Du every 121 months (11 years), when month is Du (index 8)
        return monthIndex == 8 && (absoluteMonthNumber - 8) % 121 == 0 && absoluteMonthNumber >= 8;
    }

    private static int getDays(int monthIndex) {
        return DEFAULT_DAYS[monthIndex];
    }

    private static void printMonthHeader(String name, int year) {
        System.out.printf(" %s %d\n", name, year);
    }

    private static void printBorder() {
        System.out.println("+----+----+----+----+----+----+----+----+----+----+");
    }

    private static void printWeekdays() {
        System.out.print("|");
        for (String day : WEEKDAYS) {
            System.out.printf(" %s |", day);
        }
        System.out.println();
    }

    private static void printMonthBody(int startIndex, int totalDays, boolean isLeapDu) {
        int day = 1;
        boolean firstRow = true;
        int actualLastDay = isLeapDu ? totalDays - 1 : totalDays;

        while (day <= actualLastDay) {
            System.out.print("|");
            for (int i = 0; i < 10; i++) {
                if (firstRow && i < startIndex) {
                    System.out.print("    |");
                } else if (day <= actualLastDay) {
                    if (isLeapDu && day == actualLastDay) {
                        System.out.printf("%3d#|", day); // e.g., " 33#|"
                    } else {
                        System.out.printf("%3d |", day);
                    }
                    day++;
                } else {
                    System.out.print("    |");
                }
            }
            System.out.println();
            firstRow = false;
            startIndex = 0;
        }
    }
}
