package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Sales;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Sales> list = new ArrayList<>();
			
			String line = br.readLine();
				while (line != null) {
					String[] fiealds = line.split(",");
					list.add(new Sales(Integer.parseInt(fiealds[0]),Integer.parseInt(fiealds[1]),fiealds[2], Integer.parseInt(fiealds[3]), Double.parseDouble(fiealds[4])));
					line = br.readLine();
				}
			System.out.println();
			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio: ");		
		
				Comparator<Sales> comp = (x, y) -> x.avaragePrice().compareTo(y.avaragePrice());
				
				list.stream()
				.filter(p -> p.getYear() == 2016)
				.sorted(comp.reversed())
				.limit(5)
				.forEach(System.out::println);
				
			double sum = list.stream()
					.filter(p -> (p.getSeller().toUpperCase().equals("LOGAN") && (p.getMonth() == 1 || p.getMonth() == 7)))
					.map(s -> s.getTotal()).reduce(0.0, (x, y) -> x + y);
			
			System.out.println();
			System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f", sum);
			
		}			
		catch (IOException e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}
		
		
		sc.close();

	}

}
