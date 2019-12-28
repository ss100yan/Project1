package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementsDao;
import com.revature.dao.ReimbursementsDaoImpl;
import com.revature.models.Reimbursements;

/**
 * Servlet implementation class ManagerCreateRequestServlet
 */
@MultipartConfig(maxFileSize = 1699999999)
public class ManagerCreateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerCreateRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}





protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	HttpSession session = request.getSession(false);

	if (session != null) {
		request.getRequestDispatcher(
				"Views/MangerRequest.html").forward(request, response);
	} else {
		response.sendRedirect("login");
	}
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	int reimbursementId = (int)(Math.random()*1000);
			//Integer.parseInt(request.getParameter("reimbursementId"));
	float reimbursementAmount = Float.parseFloat(request.getParameter("reimbursementAmount"));
	int managerId = 2;
		//	Integer.parseInt(request.getParameter("managerId"));
	int employeeId = Integer.parseInt(request.getParameter("employeeId"));
//	Part filePart = request.getPart("pic");
//	InputStream fis = filePart.getInputStream();
//	int length = (int) filePart.getSize();
	
	// need to test this.
	Reimbursements r = new Reimbursements();
	r.setReimbursementId(reimbursementId);
	r.setReimbursementAmount(reimbursementAmount);
	r.setManagerId(managerId);
	r.setEmployeeId(employeeId);
	
	System.out.println(r);
	
	ReimbursementsDao rd = new ReimbursementsDaoImpl();
	int numCreated = rd.createReimbursement(r);
	System.out.println(numCreated);
	
	if (numCreated==1) {
		response.sendRedirect("managerhome");
	} else {
		response.sendRedirect("create");
	}
	
	
}

}

