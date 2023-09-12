package servlet;

import java.io.IOException;
import java.sql.SQLException;

import dao.InsertRegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

@WebServlet("/RegisterServlet2")
public class RegisterServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * データベースにデータを登録する
     */
    protected void doPost(HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 文字化け防止
		
        // セッションの値を受け取る
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("account");
        
        
        String name1 = account.getName();
        String pass1 = account.getPass();
        String mail1 = account.getMail();
        String calendar1 = account.getBirthdate();
        String name2 = account.getUserId();
        String name3 = account.getPetname(); 
        String calendar2 = account.getPetbirthdate();
        String gendar1 = account.getPetgender(); 
        
        // データベースに登録する
        InsertRegisterDAO dao = new InsertRegisterDAO();
        try {
            int result = dao.insertregister(name1,pass1,mail1,calendar1,
            									name2,name3,calendar2,gendar1);
            // 登録完了画面にフォワード
            RequestDispatcher rd =
            		request.getRequestDispatcher("/WEB-INF/jsp/registerOK.jsp");
            rd.forward(request, response);

         } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 	
    }
}