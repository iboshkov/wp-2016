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
public class PizzaOrder extends HttpServlet {
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

        String size = request.getParameter("size");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + request.getParameter("size") + "</h1>");


        if (size == null) {
            throw new ServletException("Pizza size not set");
        }


        request.getSession().setAttribute("PizzaSize", size);
        request.getRequestDispatcher("deliveryInfo.jsp").forward(request, response);

    }

    public void destroy()
    {
        // do nothing.
    }
}
