package application;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("::::::::::::::: TEST 1: seller findById :::::::::::::::");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println();

		System.out.println("::::::::::::::: TEST 2: seller findByDepartment :::::::::::::::");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();

		System.out.println("::::::::::::::: TEST 3: seller findAll :::::::::::::::");
		List<Seller> list2 = sellerDao.findAll();

		for (Seller obj : list2) {
			System.out.println(obj);
		}

		System.out.println();

		System.out.println("::::::::::::::: TEST 4: seller insert :::::::::::::::");
		Seller newSeller = new Seller(null, "Silver Mello", "silver@gemail.com", new Date(), 4100.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: " + newSeller.getId());
		
		System.out.println();

		System.out.println("::::::::::::::: TEST 5: seller update :::::::::::::::");
		seller = sellerDao.findById(10);
		seller.setName("Sandra Waine");
		seller.setEmail("sandra@gemail.com");
		sellerDao.update(seller);
		System.out.println("Updated! completed in: " + seller.getId());
		
		System.out.println();

		System.out.println("::::::::::::::: TEST 6: seller delete :::::::::::::::");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted! completed");
		

		sc.close();
	}

}
