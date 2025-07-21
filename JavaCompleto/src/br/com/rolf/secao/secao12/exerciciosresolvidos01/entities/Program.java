package br.com.rolf.secao.secao12.exerciciosresolvidos01.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.rolf.secao.secao12.exerciciosresolvidos01.entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		//formatando a entrada da data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter departament's name: ");
		String departarmentName = sc.nextLine();

		System.out.println("Enter worker data:");
		System.out.println("Name: ");
		String workerName = sc.nextLine();

		System.out.println("Level: ");
		String workerLevel = sc.nextLine();

		System.out.println("Base salary: ");
		double baseSalary = sc.nextDouble();

		// instanciando um obj trabalhador
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Departament(departarmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		sc.nextLine();
 
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			sc.nextLine();
			
			//apos a entrada dos dados pode-se instaciar o obj HourContract
			HourContract contract  = new HourContract(contractDate, valuePerHour, hours);
			//associando o contrato com o trabalhador
			worker.addContract(contract);
						
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY)");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
//		Date d = sdf2.parse(sc.next());
		
		String monthAndYear = sc.next();
		int month = Integer.parseInt( monthAndYear.substring(0, 2));
		int year = Integer.parseInt( monthAndYear.substring(3));
//		
//		System.out.println("Name: " + worker.getName());
//		System.out.println("Departament: " + worker.getDepartament().getName());
//		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		String output = """
				Name: %s
				Departament: %s
				Income for %s: %.2f
				""".formatted(worker.getName(), worker.getDepartament().getName(), monthAndYear, worker.income(year, month));
		
		System.out.println(output);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
