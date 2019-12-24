package com.example.legacy.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "anotherServlet", urlPatterns = "/anotherServlet", asyncSupported = true, initParams = {
		@WebInitParam(name = "firstName", value = "Roy"), @WebInitParam(name = "lastName", value = "Zhang") })
public class AnotherServlet extends HttpServlet {

	private static final long serialVersionUID = 2734212784679009034L;
    
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = getServletConfig().getInitParameter("firstName");
        String lastName = getServletConfig().getInitParameter("lastName");

        resp.getOutputStream().println("First Name is " + firstName);
        resp.getOutputStream().println("Last Name is " + lastName);
    }

}
