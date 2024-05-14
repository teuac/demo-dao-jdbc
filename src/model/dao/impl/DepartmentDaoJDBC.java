package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import models.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement pst= null;
		try {
			pst = conn.prepareStatement(
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES "
					+ "(?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, obj.getName());
			
			int rows_affected = pst.executeUpdate();
			if(rows_affected > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}
	
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("UPDATE department "
					+ "SET Name = ? "
					+ "WHERE Id = ? ");
			pst.setString(1, obj.getName());
			pst.setInt(2, obj.getId());
			
			pst.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("DELETE FROM department "
					+ "WHERE Id = ?");
			pst.setInt(1, id);
			pst.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(pst);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT Id, Name FROM department WHERE Id = ? ");
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				
				return dep;
			}
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
		return null;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst =  conn.prepareStatement("SELECT * FROM department");
			
			rs = pst.executeQuery();
		
			List<Department> list = new ArrayList<>();
			while(rs.next()) {
				Department dep = new Department();
				
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				
				list.add(dep);
			}
			
			
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
	
	}

}
