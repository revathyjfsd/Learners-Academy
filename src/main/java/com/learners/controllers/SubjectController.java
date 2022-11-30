package com.learners.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.beans.Subject;
import com.learners.services.AcademyServices;
import com.learners.services.AcademyServicesImpl;

/**
 * Servlet implementation class SubjectController
 */
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
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
			RequestDispatcher rd = request.getRequestDispatcher("subjectDetails.jsp");
			rd.include(request, response);	
		}
		else
		{	
		Subject s = new Subject();
		response.setContentType("text/html; charset=utf-8");
		s.setSubjectId(Integer.parseInt(request.getParameter("id")));
		s.setSubjectName(request.getParameter("name"));
		s.setSubjectShortcut(request.getParameter("shortCut"));
		com.learners.services.AcademyServices service = new AcademyServicesImpl();
		if(request.getParameter("button").toString().equals("Update"))
		{
		service.updateSubjectDetails(s);
		out.println("<SPAN style='color:MediumSeaGreen'><h3>Subject "+s.getSubjectId()+" - "+s.getSubjectName()+" details are updated successfully </h3></span>");
		RequestDispatcher rd = request.getRequestDispatcher("subjectDetails.jsp");
		rd.include(request, response);	
		}
		else if(request.getParameter("button").toString().equals("Add"))
		{
			service.insertSubjectDetails(s);
			out.println("<SPAN style='color:MediumSeaGreen'><h3>Subject "+s.getSubjectId()+" - "+s.getSubjectName()+" details are inserted successfully </h3></span>");
			RequestDispatcher rd = request.getRequestDispatcher("subjectDetails.jsp");
			rd.include(request, response);	
		}
		}
		}
		catch(Exception e)
		{
			if(e.getMessage()!=null && e.getMessage().contains("ConstraintViolationException"))
			{
				out.println("<SPAN style='color:red'><h4><b>Duplicate entry of Subject Id has been entered</b></h4></span>"+ e.getMessage()+"<br>");
			}
			else
			{
				out.println("<SPAN style= 'color:red'>"+ e.getMessage()+"</SPAN><br>");
			}
		}
	}

}
