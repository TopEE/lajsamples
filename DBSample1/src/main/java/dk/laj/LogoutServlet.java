/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.laj;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


           @WebServlet(name = "Logout", urlPatterns = "/logout")
@ServletSecurity(
       
)
public class LogoutServlet extends HttpServlet {

    public static final Logger logger = Logger.getLogger(LogoutServlet.class.getCanonicalName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("---- Principal = " + request.getUserPrincipal());
        request.logout();
        logger.info("---- Principal = " + request.getUserPrincipal());
        response.sendRedirect("index.html");
    }

}
