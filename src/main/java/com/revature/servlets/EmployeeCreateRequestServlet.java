package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.ReimbursementsDao;
import com.revature.dao.ReimbursementsDaoImpl;
import com.revature.models.Reimbursements;

/**
 * Servlet implementation class EmployeeCreateRequestServlet
 */
@MultipartConfig(maxFileSize = 1699999999)
public class EmployeeCreateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeCreateRequestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		if (session != null) {
			request.getRequestDispatcher(
					"Views/employeeCreateRequest.html").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int reimbursementId = (int)(Math.random()*1000);
				//Integer.parseInt(request.getParameter("reimbursementId"));
		float reimbursementAmount = Float.parseFloat(request.getParameter("reimbursementAmount"));
		int managerId = Integer.parseInt(request.getParameter("managerId"));;
			//	Integer.parseInt(request.getParameter("managerId"));
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		
		
		Part filePart = request.getPart("pic");
		InputStream fis = filePart.getInputStream();
		int length = (int) filePart.getSize();
		
		// need to test this.
		Reimbursements r = new Reimbursements();
		r.setReimbursementId(reimbursementId);
		r.setReimbursementAmount(reimbursementAmount);
		r.setManagerId(managerId);
		r.setEmployeeId(employeeId);
		r.setPicFis(fis);
		r.setPicLength(length);
		System.out.println(r);
		
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		int numCreated = rd.createReimbursement(r);
		System.out.println(numCreated);
		
		if (numCreated==1) {
			response.sendRedirect("employeehome");
		} else {
			response.sendRedirect("create");
		}
		
		
	}

}
