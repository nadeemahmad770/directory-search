package com.ph.dir.app.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeEntity {

	private Long id;
	private String name;
	private String address;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", firstName=" + name + "]";
	}

	public static EmployeeEntity toObject(final ResultSet rs) throws SQLException {
		EmployeeEntity statusMasterDTO = new EmployeeEntity();
		statusMasterDTO.setName(rs.getString("name"));
		return statusMasterDTO;
	}
}