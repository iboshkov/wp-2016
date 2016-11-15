package mk.ukim.finki.wp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 131223 on 11/15/2016.
 */
public class AddressInfo extends HttpServlet {
    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World123";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h4>" + request.getHeader("User-Agent") + "</h4>");
        out.println("<h4>" + request.getParameter("name") + "</h4>");
        out.println("<h4>" + request.getParameter("address") + "</h4>");
        out.println("<h4>" + request.getSession().getAttribute("PizzaSize") + "</h4>");
    }

    public void destroy()
    {
        // do nothing.
    }
}
