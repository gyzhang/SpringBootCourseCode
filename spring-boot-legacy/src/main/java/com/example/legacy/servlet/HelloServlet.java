package com.example.legacy.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -2973573158529464736L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = getServletConfig().getInitParameter("firstName");
        String lastName = getServletConfig().getInitParameter("lastName");

        resp.getOutputStream().println("First Name is " + firstName);
        resp.getOutputStream().println("Last Name is " + lastName);
    }
}
