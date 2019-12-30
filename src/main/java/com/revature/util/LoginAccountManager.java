package com.revature.util;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.EmployeesDaoImpl;
import com.revature.models.Employees;

public class LoginAccountManager {

	public String determineAccountType(HttpServletRequest request) {

		Employees e = new EmployeesDaoImpl().getEmployeeByUsername(request.getParameter("username"));

		if (e.getId() == 0) {
			return "login";
		}

		String password = request.getParameter("password");

	
		if (password.equals(e.getPassword())) {
		
			if (e.getIsManager() == 0) {
				return "employeehome";
	
			} else if (e.getIsManager() == 1) {
				return "managerhome";
			}

		}

		return "login";

	}
}
