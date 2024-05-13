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
		System.out.println("------ TESTE 3 ------ FindAll");
	    list = sellerDao.findAll();
		for(Seller x : list) {
			System.out.println(x);
		}
		System.out.println("------ Teste 4 ------ Insert");
		Seller newSeller = new Seller(null, "Cauet,", "cauetcampos@outlook.com", new Date(), 30000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Seller inserted: " + newSeller.getId());
		
		System.out.println("------ TESTE 5 ------ update");
		seller = sellerDao.findById(1);
		seller.setName("sheila");
		sellerDao.update(seller);
		System.out.println("update Complete");
		
		System.out.println("------ TESTE 6 ------ DELETE");
		sellerDao.deleteById(7);
		System.out.println("Delete complete");
	}
	

}
