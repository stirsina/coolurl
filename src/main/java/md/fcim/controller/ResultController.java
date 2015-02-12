package md.fcim.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import md.fcim.service.GenerateUrlService;
import md.fcim.utils.CoolURLUtils;
import md.fcim.utils.CoolUrlConstants;

import org.apache.commons.lang.StringEscapeUtils;

public class ResultController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6742958232266740570L;
	private static URI uri;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		req.setAttribute("fakeURL", session.getAttribute("fakeURLSession"));
		req.setAttribute("resultURL", session.getAttribute("originalURLSession"));
		session.removeAttribute("fakeURLSession");	
		session.removeAttribute("originalURLSession");			

		
		RequestDispatcher view = req
				.getRequestDispatcher("WEB-INF/views/result.jsp");
		view.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String originalUrl = req.getParameter("url");
		String aliasUrl = req.getParameter("alias");
		
		GenerateUrlService createService = new GenerateUrlService();
		boolean canWrite = createService.createNewUrl(aliasUrl, originalUrl);

		HttpSession session = req.getSession();
		session.setAttribute("originalURLSession", canWrite ? originalUrl : "errorPage");
		session.setAttribute("fakeURLSession", canWrite ? CoolUrlConstants.HTTP + aliasUrl : "errorPage");

		
		resp.sendRedirect("Result");		
		
	}
	

	public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
		String valueNonAscii = "автоматическиеворота.рфsdfsafd";
		String HTTP = "http://";
		
//		String value = URLEncoder.encode(valueNonAscii, "UTF8") ;
//		try {
//			uri = new URI(HTTP + valueNonAscii);
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		URL url = new URL(uri.toASCIIString());
		String valueASC = "\u0414\u043e\u043c\u0430\u0448\u043d\u044f\u044f \u0441\u0442\u0440\u0430\u043d\u0438\u0446\u0430";
		System.out.println(valueASC);
		
		String test = StringEscapeUtils.escapeJava(valueNonAscii);
		String test1 = StringEscapeUtils.unescapeJava(test);
		
			
		System.out.println(test);
		System.out.println(test1);
		
		String asd = "tieba.baidu.com/photo/g?kw=%E4%B8%9D%E7%AB%B9%E8%8B%91&ie=utf-8";
		System.out.println(StringEscapeUtils.escapeJava(asd));
		System.out.println(StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJava(asd)));
//		String valueUTF8 = new String(uri.toASCIIString().getBytes(), "UTF-8");
//		System.out.println(valueUTF8);
		
//		HttpSession session = req.getSession();
//		session.setAttribute("resultURLSession", uri.toASCIIString());
		
	}
}
