package com.learners.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.beans.Class;
import com.learners.services.AcademyServices;
import com.learners.services.AcademyServicesImpl;

/**
 * Servlet implementation class ClassDetailsController
 */
public class ClassDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {	
		if(request.getParameter("button").toString().equals("Cancel"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("classDetails.jsp");
			rd.include(request, response);	
		}
		else
		{	
		Class c = new Class();
		response.setContentType("text/html; charset=utf-8");
		System.out.println("id in Classs details controller"+request.getParameter("id"));
		c.setClassId(Integer.parseInt(request.getParameter("id")));
		c.setName(request.getParameter("name"));
		c.setSection(request.getParameter("section"));
		com.learners.services.AcademyServices service = new AcademyServicesImpl();
	
		if(request.getParameter("button").toString().equals("Update"))
		{
		service.updateClassDetails(c);
		out.println("<SPAN style='color:MediumSeaGreen'><h3> Class "+c.getClassId()+" - "+c.getName()+" details are updated successfully </h3></span>");
		RequestDispatcher rd = request.getRequestDispatcher("classDetails.jsp");
		rd.include(request, response);	
		}
		else if(request.getParameter("button").toString().equals("Add"))
		{
			service.insertClassDetails(c);
			out.println("<SPAN style='color:MediumSeaGreen'><h3> Class "+c.getClassId()+" - "+c.getName()+" details are inserted successfully </h3></span>");
			RequestDispatcher rd = request.getRequestDispatcher("classDetails.jsp");
			rd.include(request, response);	
		}
		}
		}
		catch(Exception e)
		{
			if(e.getMessage()!=null && e.getMessage().contains("ConstraintViolationException"))
			{
				out.println("<SPAN style='color:red'><h4><b>Duplicate entry of Class Id has been entered</b></h4></span>"+ e.getMessage()+"<br>");
			}
			else
			{
				out.println("<SPAN style= 'color:red'>"+ e.getMessage()+"</SPAN><br>");
			}
		}
	}

}
