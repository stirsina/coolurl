package md.fcim.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultPageController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2939532042937460213L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher view = req
				.getRequestDispatcher("WEB-INF/views/index.jsp");
		view.forward(req, resp);
	}

}
