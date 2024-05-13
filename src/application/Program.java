package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Program {
	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("------ TESTE 1 ------ FindById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("------ TESTE 2 ------ FindByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller x : list) {
			System.out.println(x);
		}
	
		
	}

}
