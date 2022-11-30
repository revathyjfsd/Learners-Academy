package com.learners.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class SubjectFilter
 */
public class SubjectFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SubjectFilter() {
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
			if(error!=null)
			{
				out.print("<SPAN style= 'color:red'>"+error+"</SPAN>");
				request.setAttribute("flag", "true");
				if(request.getParameter("button").toString().equals("Update"))
					request.getRequestDispatcher("subjectEditForm.jsp").include(request, response);
				else if(request.getParameter("button").toString().equals("Add"))
				{
					request.getRequestDispatcher("newSubjectForm.jsp").include(request, response);
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
		String sshortcut = request.getParameter("shortCut");
		if(!(sid.matches("[0-9]+")))
		{
			return "Entered Invalid Subject ID. Please enter proper value"; 
		}
		else if(!(sshortcut.matches("[A-Za-z]+")))
		{
			return "Entered Invalid shortcut. Please enter proper value"; 
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
