package md.fcim.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResultController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6742958232266740570L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		req.setAttribute("resultURL", session.getAttribute("resultURLSession"));
		session.removeAttribute("resultURLSession");			
		
		RequestDispatcher view = req
				.getRequestDispatcher("WEB-INF/views/result.jsp");
		view.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.setAttribute("resultURLSession", "http://livetv.sx/");
		
		resp.sendRedirect("Result");		
		
	}
}
