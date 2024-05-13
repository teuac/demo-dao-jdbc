package application;

import java.util.Date;

import models.entities.Department;
import models.entities.Seller;

public class Program {
	public static void main(String[] args) {
		Department obj = new Department(1, "Livros");
		
		Seller sell = new Seller(1, "Bob", "bibinhogemiio@", new Date(), 3000.0, obj );
		
		System.out.println(sell);
	}

}
