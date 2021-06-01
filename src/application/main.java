package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Worker;
import entities.enums.WorkerLevel;
import entities.Department;
import entities.HourContract;

public class main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.printf("Name: ");
		String name = sc.nextLine();
		System.out.printf("Level: ");
		String level = sc.next();
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));

		System.out.printf("How many contracts to this worker? ");
		int numberContracts = sc.nextInt();

		for (int i = 0; i < numberContracts; i++) {
			System.out.printf("Enter contract #%d data: ", i+1);
			System.out.printf("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.printf("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration(Hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.printf("Enter month and year to calculate income (MM/YYYY): ");
		String monthandYear = sc.next();
		int month = Integer.parseInt(monthandYear.substring(0, 2));
		int year = Integer.parseInt(monthandYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDeparment().getName());
		System.out.println("Income for "+ monthandYear+ String.format(" %.2f", worker.income(year, month)));

		sc.close();
	}

}
