package ro.sci.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CurrentDateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		StringBuilder sb = new StringBuilder();
		sb.append("Current Date: ");
		sb.append(new SimpleDateFormat("dd.MM.yyyy").format(date));
		resp.getWriter().println(sb.toString());
		
	}

}
