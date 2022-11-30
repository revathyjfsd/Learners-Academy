package com.learners.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.beans.Student;
import com.learners.beans.Class;
import com.learners.services.AcademyServices;
import com.learners.services.AcademyServicesImpl;

/**
 * Servlet implementation class StudentFormController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
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
			RequestDispatcher rd = request.getRequestDispatcher("studentDetails.jsp");
			rd.include(request, response);	
		}
		else
		{	
		Student s = new Student();
		response.setContentType("text/html; charset=utf-8");	
		System.out.println("id in controller"+request.getParameter("id"));
		s.setStudentId(Integer.parseInt(request.getParameter("id")));
		s.setStudentName(request.getParameter("name"));
		s.setStudentAge(Integer.parseInt(request.getParameter("age")));
		s.setStudentEmail(request.getParameter("email"));
		s.setStudentAddress(request.getParameter("address"));
		s.setStudentPhone(Long.parseLong(request.getParameter("phone")));
		Class c = new Class();
		String classId= request.getParameter("classId");
		String[] classSplit= classId.split("-");
		c.setClassId(Integer.parseInt(classSplit[0]));
		s.setLearnerClass(c);
		AcademyServices service = new AcademyServicesImpl();
		if(request.getParameter("button").toString().equals("Update"))
		{
		service.updateStudentDetails(s);
		out.println("<SPAN style='color:MediumSeaGreen'><h3>Student "+s.getStudentId()+" - "+s.getStudentName()+" details are updated successfully </h3></span>");
		RequestDispatcher rd = request.getRequestDispatcher("studentDetails.jsp");
		rd.include(request, response);	
		}
		else if(request.getParameter("button").toString().equals("Add"))
		{
			service.insertStudentDetails(s); 
			out.println("<SPAN style='color:MediumSeaGreen'><h3>Student "+s.getStudentId()+" - "+s.getStudentName()+" details are inserted successfully </h3></span>");
			RequestDispatcher rd = request.getRequestDispatcher("studentDetails.jsp");
			rd.include(request, response);	
		}
		}
		}
		catch(Exception e)
		{
			if(e.getMessage()!=null && e.getMessage().contains("ConstraintViolationException"))
			{
				out.println("<SPAN style='color:red'><h4><b>Duplicate entry of Student Id has been entered</b></h4></span>"+ e.getMessage()+"<br>");
			}
			else
			{
				out.println("<SPAN style= 'color:red'>"+ e.getMessage()+"</SPAN><br>");
			}
		}
	}
}
