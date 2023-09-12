package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

@WebServlet("/GendarServlet")
public class GendarServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse res)
      throws IOException, ServletException {
	request.setCharacterEncoding("utf-8");
    String name1 = request.getParameter("name1");
    String pass1 = request.getParameter("pass1");
    String mail1 = request.getParameter("mail1");
    String calendar1 = request.getParameter("calendar1");
    String name2 = request.getParameter("name2");
    String name3 = request.getParameter("name3"); 
    String calendar2 = request.getParameter("calendar2");
    String gender1 = request.getParameter("gender1");

    Account account = new Account(name1, pass1, mail1, calendar1, 
    		name2, name3, calendar2, gender1 );
    HttpSession session = request.getSession();
    
    session.setAttribute("account", account);
    
    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
    rd.forward(request, res);
  }
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
  }
}
