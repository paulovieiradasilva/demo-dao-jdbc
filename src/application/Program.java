package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Department obj = new Department(1, "Books");
		Seller obj2 = new Seller(1, "Bob", "bob@gmail.com", sdf.parse("12/04/1987"), 3000.0, obj);

		System.out.println(obj2);
	}

}
