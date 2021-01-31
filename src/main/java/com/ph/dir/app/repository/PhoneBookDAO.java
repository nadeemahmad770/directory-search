package com.ph.dir.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ph.dir.app.exception.NoDataFoundException;
import com.ph.dir.app.model.EmployeeEntity;

@Repository
public class PhoneBookDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PhoneBookDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<EmployeeEntity> searchContact(String dataSearch) throws NoDataFoundException{
		List<EmployeeEntity> statusMasterList = null;
		try {
			StringBuilder selectQuery = new StringBuilder();
			selectQuery.append("SELECT name FROM TBL_EMPLOYEES where lower(name) like '"+dataSearch.toLowerCase()+"%'");
			final RowMapper<EmployeeEntity> mapper = new RowMapper<EmployeeEntity>() {
				public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
					return EmployeeEntity.toObject(rs);
				}
			};
			statusMasterList = jdbcTemplate.query(selectQuery.toString(),mapper);
		} catch (Exception e) {
			LOGGER.info("PhoneBookDAO: searchContact: Exception :: ", e);
			return Collections.emptyList();
		}
		return statusMasterList;
	}

}
