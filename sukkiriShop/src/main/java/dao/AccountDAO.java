package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL =
          "jdbc:mariadb://localhost/sukkirishop";
  private final String DB_USER = "root";
  private final String DB_PASS = "pass";
  Connection conn =null;
  public Account findByLogin(Login login) {
    Account account = null;

    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(
        JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文を準備
      String sql = "SELECT NAME, PASS, MAIL, BIRTHDATE, USER_ID, PETNAME, PETBIRTHDATE, PETGENDER FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, login.getUserId());
      pStmt.setString(2, login.getPass());

      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();
     
      // 一致したユーザーが存在した場合
      // そのユーザーを表すAccountインスタンスを生成
      if (rs.next()) {
        // 結果表からデータを取得
    	  String name = rs.getString("NAME");
    	  String pass = rs.getString("PASS");
    	  String mail = rs.getString("MAIL");
    	  String birthdate = rs.getString("BIRTHDATE");
    	  String userId = rs.getString("USER_ID");
    	  String petname = rs.getString("PETNAME");
    	  String petbirthdate = rs.getString("PETBIRTHDATE");
    	  String petgender = rs.getString("PETGENDER");
       
        account = new Account(name, pass, mail, birthdate, userId, petname, petbirthdate, petgender);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    // 見つかったユーザーまたはnullを返す
    return account;
  }
}