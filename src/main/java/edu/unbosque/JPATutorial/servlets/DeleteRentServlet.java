package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.RentService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteRentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer rentId =Integer.parseInt(request.getParameter("rentId"));

        RentService rentService = new RentService();
        rentService.deleteRent(rentId);

        response.sendRedirect("./index.jsp");
    }
}
