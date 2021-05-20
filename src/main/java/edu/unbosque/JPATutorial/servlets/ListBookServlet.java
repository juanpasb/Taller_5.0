package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        BookService bookService = new BookService();
        List<BookPOJO> book =  bookService.listBook();

        String authorsJsonString = new Gson().toJson(book);

        PrintWriter out = response.getWriter();
        out.print(authorsJsonString);
        out.flush();

    }

}
