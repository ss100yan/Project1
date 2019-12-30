package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementsDaoImpl;
import com.revature.dao.ReimbursementsDao;
/**
 * Servlet implementation class GetReceiptWithID
 */
public class GetReceiptWithID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReceiptWithID() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("intid"));
		
	
		
		ReimbursementsDao action = new ReimbursementsDaoImpl();
		
		byte[] picture = action.getReceipts(id);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		ObjectMapper imTheMap = new ObjectMapper();
		writer.write(imTheMap.writeValueAsString(picture));
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}