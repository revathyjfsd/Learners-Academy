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
 * Servlet Filter implementation class ClassFilter
 */
public class ClassFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ClassFilter() {
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

		String cid=request.getParameter("id");
		String csection = request.getParameter("section");
		if(!(cid.matches("[0-9]+")))
		{
			return "Entered Invalid Class ID. Please enter proper value"; 
		}
		else if(!(csection.matches("[A-Za-z]")))
		{
			return "Entered Invalid Section. Please enter proper value"; 
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
