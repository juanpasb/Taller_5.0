package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.RentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "cretateRentServlet", value = "/create-rent")
public class CreateRentServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("title");
        Integer edition_id = Integer.parseInt(request.getParameter("authorId"));
        String renting_date = request.getParameter("genre");


        RentService rentService = new RentService();
        rentService.saveRent(email, edition_id, renting_date);

        response.sendRedirect("./index.jsp");

    }
}
