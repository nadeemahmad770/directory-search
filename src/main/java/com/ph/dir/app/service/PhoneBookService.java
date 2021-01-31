package com.ph.dir.app.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph.dir.app.constants.Constants;
import com.ph.dir.app.exception.NoDataFoundException;
import com.ph.dir.app.model.EmployeeEntity;
import com.ph.dir.app.repository.PhoneBookDAO;
import com.ph.dir.app.util.Utility;

@Service
public class PhoneBookService {

	@Autowired
	PhoneBookDAO phoneBookDAO;

	public String loadSearchData(String contactName) throws NoDataFoundException, JSONException {
		JSONObject responseObj = new JSONObject();
		JSONArray dataArry = new JSONArray();
		try {
			if(Utility.isNotBlank(contactName)){
				List<EmployeeEntity> employeeList = phoneBookDAO.searchContact(contactName);
				if (!employeeList.isEmpty() && employeeList.size() > Constants.ZERO) {
					employeeList.stream().forEach(employe -> dataArry.put(employe.getName()));
				}
				responseObj.put(Constants.DATA, dataArry);
				responseObj.put(Constants.STATUS, Constants.STATUS_200);
			}
		} catch (Exception e) {
			throw new NoDataFoundException("No Data Found");
		}
		return responseObj.toString();
	}

}
