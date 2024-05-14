package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import models.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("Teste 1 -------- INSERT");
		Department depIns = new Department(null, "Alimenticio");
		depDao.insert(depIns);
		System.out.println(depIns);
		System.out.println("Insert Sucefully");
		
		System.out.println(" ");
		
		System.out.println("Teste 2 --------- UPDATE");
		Department depUp = new Department(5, "Arroz");
		depDao.update(depUp);
		System.out.println(depUp);
		System.out.println("Update Sucefully");
		
		System.out.println(" ");
		
		System.out.println("Teste 3 --------- Delete");
		depDao.deleteById(7);
		System.out.println("Delete Sucefully");
		
		System.out.println("");
		
		System.out.println("Teste 4 --------- FindById");
		Department depFindId = depDao.findById(4);
		System.out.println(depFindId);
		
		System.out.println(" ");
		
		System.out.println("TESTE 5 -------- FindAll");
		List<Department> listDep = depDao.findAll();
		for(Department d : listDep) {
			System.out.println(d);
		}
		
	}

}
