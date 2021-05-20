package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.CustomerService;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListCustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        CustomerService customerService = new CustomerService();
        List<CustomerPOJO> customer =  customerService.listCustomer();

        String authorsJsonString = new Gson().toJson(customer);

        PrintWriter out = response.getWriter();
        out.print(authorsJsonString);
        out.flush();

    }
}
