package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateEditionServlet", value = "/create-edition")
public class CreateEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String description = request.getParameter("description");
        String release_year = request.getParameter("release_year");
        Integer book_id = Integer.parseInt(request.getParameter("book_id"));

        EditionService editionService = new EditionService();
        editionService.saveEdition(description, release_year, book_id);

        response.sendRedirect("./index.jsp");

    }

}
