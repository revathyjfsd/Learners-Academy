package com.learners.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class TeacherFilter
 */
public class TeacherFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TeacherFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		request.setAttribute("flag", "false");
		if(!(request.getParameter("button").toString().equals("Cancel")))
		{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			String error = validate(request,response);
			if(error!=null && !(request.getParameter("button").toString().equals("Cancel")))
			{
				out.print("<SPAN style= 'color:red'>"+error+"</SPAN>");
				request.setAttribute("flag", "true");
				if(request.getParameter("button").toString().equals("Update"))
					request.getRequestDispatcher("teacherEditForm.jsp").include(request, response);
				else if(request.getParameter("button").toString().equals("Add"))
				{
					request.getRequestDispatcher("newTeacherForm.jsp").include(request, response);
				}
				
			}
			else
				chain.doFilter(request, response);
		}
		else
			chain.doFilter(request, response);
	}
	public static String validate(ServletRequest request, ServletResponse response)
	{

		String sid=request.getParameter("id");
		String sname= request.getParameter("name");
		String age = request.getParameter("age");
		String email=request.getParameter("email");
		String address =request.getParameter("address");
		String phone= request.getParameter("phone");
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
		if(!(sid.matches("[0-9]+")))
		{
			return "Entered Invalid Student ID. Please enter proper value"; 
		}
		else if(!(sname.matches("[A-Za-z\\\\s]+")))
		{
			return "Entered Invalid Name. Please enter proper value"; 
		}
		else if(!(age.matches("[0-9]+")))
		{
			return "Entered Invalid Age. Please enter proper value"; 
		}
		else if(!(phone.matches("[0-9]+")))
		{
			return "Entered Invalid Phone number. Please enter proper value"; 
		}
		else if(!(matcher.matches()))
		{
			return "Entered Invalid Email id. Please enter proper value"; 
		}
		return null;
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
