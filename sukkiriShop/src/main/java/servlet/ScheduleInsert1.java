package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ScheduleInsert1")
public class ScheduleInsert1 extends HttpServlet {
	private static final long serialVersionUID = 1L;






	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("Shift-JIS");
		response.setContentType("text/html;charset=Shift_Jis");
		PrintWriter out = response.getWriter();

		int year;
		int month;
		int day;
		String appetite;
		String poop;
		String snot;
		String mucus;

//		パラメーターが正しく入力されているかの判定

		String param = request.getParameter("YEAR");
		if (param == null || param.length() == 0) {
			year = -999;
		}else {
			try {
				year = Integer.parseInt(param);
			}catch(NumberFormatException e) {
				year = -999;
			}
		}

		param = request.getParameter("MONTH");
		if (param == null || param.length() == 0) {
			month = -999;
		}else {
			try{
				month = Integer.parseInt(param);
			}catch (NumberFormatException e) {
				month = -999;
			}
		}

        param = request.getParameter("DAY");
        if (param == null || param.length() == 0){
            day = -999;
        }else{
            try{
                day = Integer.parseInt(param);
            }catch (NumberFormatException e){
                day = -999;
            }
        }


        param = request.getParameter("APPETITE");
        if (param == null || param.length() == 0){
            appetite = " ";
        }else{
            try{
                appetite = param;
            }catch (NumberFormatException e){
                appetite = " ";
            }
        }

        param = request.getParameter("POOP");
        if (param == null || param.length() == 0){
            poop = " ";
        }else{
            try{
                poop = param;
            }catch (NumberFormatException e){
                poop = " ";
            }
        }

        param = request.getParameter("SNOT");
        if (param == null || param.length() == 0){
            snot = " ";
        }else{
            try{
                snot = param;
            }catch (NumberFormatException e){
                snot = " ";
            }
        }

        param = request.getParameter("MUCUS");
        if (param == null || param.length() == 0){
            mucus = " ";
        }else{
            try{
                mucus = param;
            }catch (NumberFormatException e){
                mucus = " ";
            }
        }

        /* 日付が不正な値で来た場合はパラメータ無しで「MonthView」へリダイレクトする */
        if (year == -999 || month == -999 || day == -999) {
        	response.sendRedirect("/sukkiriShop/MonthView5");
        }
        String dateStr = year + "-" + month + "-" + day;

//　データベースに登録

        Connection conn = null;
        String url = "jdbc:mariadb://localhost/sukkiriShop";
        String user = "root";
        String password = "pass";

        try {


        	conn = DriverManager.getConnection(url,user,password);

        	String sql = "insert into schedule(userid,scheduledate,appetite,poop,snot,mucus) values(?,?,?,?,?,?)";
        	PreparedStatement pstmt = conn.prepareStatement(sql);

        	pstmt.setInt(1, 1);
        	pstmt.setString(2, dateStr);
        	pstmt.setString(3, appetite);
        	pstmt.setString(4, poop);
        	pstmt.setString(5, snot);
        	pstmt.setString(6, mucus);
        	int num = pstmt.executeUpdate();


        	pstmt.close();


        }catch(SQLException e) {
        	out.println("SQLException:" + e.getMessage());
        }catch(Exception e) {
        	out.println("Exception:" + e.getMessage());
        }finally {
        	try {
        		if (conn != null) {
        			conn.close();
        		}
        	}catch (SQLException e){
        		out.println("SQLException:" + e.getMessage());
        	}
        }


        StringBuffer sb = new StringBuffer();
        sb.append("/sukkiriShop/MonthView5");
        sb.append("?YEAR=");
        sb.append(year);
        sb.append("&MONTH=");
        sb.append(month - 1);
        response.sendRedirect(new String(sb));

	}

}
