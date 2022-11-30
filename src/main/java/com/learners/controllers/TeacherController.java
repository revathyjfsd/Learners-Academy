package com.learners.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learners.beans.Class;
import com.learners.beans.Teacher;
import com.learners.beans.Subject;
import com.learners.beans.Teacher;
import com.learners.services.AcademyServices;
import com.learners.services.AcademyServicesImpl;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	PrintWriter out = response.getWriter();
		try {	
		if(request.getParameter("button").toString().equals("Cancel"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("teacherDetails.jsp");
			rd.include(request, response);	
		}
		else
		{
		Teacher t = new Teacher();
		response.setContentType("text/html; charset=utf-8");
		t.setTeacherId(Integer.parseInt(request.getParameter("id")));
		t.setTeacherName(request.getParameter("name"));
		t.setTeacherAge(Integer.parseInt(request.getParameter("age")));
		t.setTeacherEmail(request.getParameter("email"));
		t.setTeacherAddress(request.getParameter("address"));
		t.setTeacherPhone(Long.parseLong(request.getParameter("phone")));
		com.learners.services.AcademyServices service = new AcademyServicesImpl();
	
		if(request.getParameter("button").toString().equals("Update"))
		{
		service.updateTeacherDetails(t);
		out.println("<SPAN style='color:MediumSeaGreen'><h3>Teacher "+t.getTeacherId()+" - "+t.getTeacherName()+" details are updated successfully </h3></span>");
		RequestDispatcher rd = request.getRequestDispatcher("teacherDetails.jsp");
		rd.include(request, response);	
		}
		else if(request.getParameter("button").toString().equals("Add"))
		{
			service.insertTeacherDetails(t);
			out.println("<SPAN style='color:MediumSeaGreen'><h3>Teacher "+t.getTeacherId()+" - "+t.getTeacherName()+" details are inserted successfully </h3></span>");
			RequestDispatcher rd = request.getRequestDispatcher("teacherDetails.jsp");
			rd.include(request, response);	

		}
		
		}
		}
		catch(Exception e)
		{
			if(e.getMessage()!=null && e.getMessage().contains("ConstraintViolationException"))
			{
				out.println("<SPAN style='color:red'><h4><b>Duplicate entry of Teacher Id has been entered</b></h4></span>"+ e.getMessage()+"<br>");
			}
			else
			{
				out.println("<SPAN style= 'color:red'>"+ e.getMessage()+"</SPAN><br>");
			}
		}
	}

}
