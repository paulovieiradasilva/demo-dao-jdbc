package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("::::::::::::::: TEST 1: seller findById :::::::::::::::");
		Seller seller  = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("::::::::::::::: TEST 2: seller findByDepartment :::::::::::::::");
		Department dep = new Department(2, null);
		List<Seller> list  = sellerDao.findByDepartment(dep);

		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("::::::::::::::: TEST 3: seller findAll :::::::::::::::");
		List<Seller> list2 = sellerDao.findAll();

		for (Seller obj : list2) {
			System.out.println(obj);
		}
	}

}
