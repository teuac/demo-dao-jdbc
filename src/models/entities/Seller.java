package models.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String email;
	private Date birth_date;
	private Double base_salary;
	
	private Department department;

	public Seller() {
		
	}

	public Seller(Integer id, String name, String email, Date birth_date, Double base_salary, Department department) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth_date = birth_date;
		this.department = department;
		this.base_salary = base_salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public Double getBase_salary() {
		return base_salary;
	}
	
	public void setBase_salary(Double base_salary) {
		this.base_salary = base_salary;
	}
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birth_date, department, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(birth_date, other.birth_date) && Objects.equals(department, other.department)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", email=" + email + ", birth_date=" + birth_date
				+ ", department=" + department + "]";
	}
	
	
	

}
