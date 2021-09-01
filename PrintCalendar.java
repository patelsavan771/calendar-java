import java.util.Scanner;

public class PrintCalendar{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Enter Year : ");
		int year = input.nextInt();

		System.out.print("Enter Month (1 to 12) : ");
		int month = input.nextInt();

		printMonth(month,year);

	}

	public static void printMonth(int month, int year){
		printMonthTitle(month,year);
		printMonthBody(month,year);

	}


	public static void printMonthTitle(int month, int year){
		System.out.println("\n\n\t" + getMonthName(month) + "," + year);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
	}	

	public static String getMonthName(int month){
		String[] monthNames = {"January","February","March",
								"April","May","June",
								"July","August","September",
								"October","November","December"};
		return monthNames[month - 1];
	}



	public static void printMonthBody(int month, int year){
		int startDay = getStartDay(month, year);

		int numberOfDaysInMonth = getNumberOfDaysInMonth(month, year);

		for(int i = 0; i < startDay; i++){
			System.out.print("    ");
		}
		for(int i = 1; i <= numberOfDaysInMonth; i++){
			System.out.printf("%4d",i);
			if((i + startDay) % 7 == 0){
				System.out.println();
			}
		}
		if((numberOfDaysInMonth + startDay) % 7 != 0){
			System.out.println();
		}
		System.out.print("-----------------------------\n\n");

	}


	public static int getNumberOfDaysInMonth(int month, int year){
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(month == 2 && isLeapYear(year)){
			return 29;
		}
		return days[month - 1];
	}

	public static int getStartDay(int month, int year){
		final int DAY_ON_1_1_1800_IS = 3;
		int totalNumberOfDays = getTotalNumberOfDays(month, year);
		return (DAY_ON_1_1_1800_IS + totalNumberOfDays) % 7;
	}

	public static int getTotalNumberOfDays(int month, int year){
		int total = 0;
		for(int i = 1800; i < year; i++){
			if(isLeapYear(i)){
				total += 366;
			}
			else{
				total += 365;
			}
		}

		for(int i = 1; i < month; i++){
			total += getNumberOfDaysInMonth(i, year);
		}

		return total;
	}


	public static boolean isLeapYear(int year){
		if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
			return true;
		}
		else{
			return false;
		}
	}
}