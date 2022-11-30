package com.learners.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learners.beans.Subject;
import com.learners.beans.Teacher;
import com.learners.exceptions.EntityExistsException;
import com.learners.beans.Class;
import com.learners.services.AcademyServices;
import com.learners.services.AcademyServicesImpl;

/**
 * Servlet implementation class ClassController
 */
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		try {
		Class c = new Class();
		HttpSession session = request.getSession();
		String classIdParam= request.getParameter("classId");
		String[] classSplit= classIdParam.split("-");
		int classId=(Integer.parseInt(classSplit[0]));
		Set<Class> classList=(HashSet<Class>)session.getAttribute("classList");
		for(Class c1:classList)
		{
			if(c1.getClassId()==classId)
			{
				c=c1;
			}
				
		}
		
		if(request.getParameter("button").toString().equals("Update"))
		{
		Subject s= new Subject();
		String subjectIdParam= request.getParameter("subjectId");
		String[] subjectSplit= subjectIdParam.split("-");
		int subjectId=(Integer.parseInt(subjectSplit[0]));
		Set<Teacher> teacherList= (HashSet<Teacher>)session.getAttribute("teacherList");
		
		Teacher t = new Teacher();
		String teacherIdParam= request.getParameter("teacherId");
		String[] teacherSplit= teacherIdParam.split("-");
		int teacherId=(Integer.parseInt(teacherSplit[0]));
		Set<Subject> subjectList= (HashSet<Subject>)session.getAttribute("subjectList");
		
		for(Teacher c1:teacherList)
		{
			if(c1.getTeacherId()==teacherId)
			{
				t=c1;
			}
				
		}
		for(Subject c1:subjectList)
		{
			if(c1.getSubjectId()==subjectId)
			{
				s=c1;
			}		
		}
		AcademyServices service = new AcademyServicesImpl();
		service.assignTeacherToClass(c,s,t);
		out.println("<h2 style='color:SlateBlue;'> Teacher <Strong style='color:MediumSeaGreen;'>"+teacherId+" -  "+teacherSplit[1]+"</Strong> has been sucessfully assigned to class <Strong style='color:MediumSeaGreen;'>"+classId+" - "+classSplit[1]+"</Strong> for <Strong style='color:MediumSeaGreen;'>"+subjectId+" - "+subjectSplit[1]+"-"+subjectSplit[2]+"</Strong> subject</h2><br>");
		RequestDispatcher rd=request.getRequestDispatcher("assignClassSubjects.jsp");
		rd.include(request, response);
		
		}
		else if(request.getParameter("button").toString().equals("Get Data"))
		{
			request.setAttribute("selectedClass", c);
			RequestDispatcher rd = request.getRequestDispatcher("classReport.jsp");
			rd.include(request, response);	
		}
		}
		catch(Exception e)
		{
			if(e.getMessage()!=null && (e.getMessage().contains("EntityExistsException") || e.getMessage().contains("NonUniqueObjectException")))
			{
				out.println("<SPAN style='color:red'><h4><b>"+ "<br>Already selected Teacher "+request.getParameter("teacherId")+"/Subject "+request.getParameter("subjectId")+" has been assigned to this class.<br> Try again with assigning other teacher/subject for this Class "+request.getParameter("classId")+"</b></h4></span><br>");
				RequestDispatcher rd = request.getRequestDispatcher("assignClassSubjects.jsp");
				rd.include(request, response);	
			}
			else
			{
				out.println("<SPAN style= 'color:red'>"+ e.getMessage()+"</SPAN><br>");
			}
	
		}
	}

}
