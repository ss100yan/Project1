package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.models.Reimbursements;

import com.revature.dao.ReimbursementsDaoImpl;
import com.revature.dao.ReimbursementsDao;
//import com.project1.repository.Actions;
//import com.project1.repository.ActionsImpl;
/**

/**
 * Servlet implementation class GetPhoto
 */
public class GetPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public GetPhoto() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("intid"));
			ReimbursementsDao emp = new ReimbursementsDaoImpl();
		
			System.out.println(id);
			
			byte[] picture = emp.getReceipts(id);
			
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
	

	
	
	



