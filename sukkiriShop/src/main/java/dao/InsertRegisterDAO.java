package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRegisterDAO {
    // データベースのURL
    private static final String URL = "jdbc:mariadb://localhost/sukkirishop";
	
    // データベースにアクセスするユーザー
    private static final String USER = "root";
	
    // データベースにアクセスするユーザーのパスワード
    private static final String PASSWORD = "pass";
	
    /**
     * データベースの接続を取得する
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
	
    /**
     * データベースにデータを登録する
     * @param title
     * @param price
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int insertregister(String name1, String pass1,
    		String mail1, String calendar1, String name2,
    		String name3, String calendar2, String gendar1)
    				throws ClassNotFoundException, SQLException {
		
        // 登録した行数を保持する変数
        int result = 0;
		
        // 実行するSQL
        String sql = "INSERT INTO account(name,pass,mail,birthdate,user_id,petname,petbirthdate,petgender) values(?, ?, ?, ?, ?, ?, ?, ?);";
		
        // DBに接続する
        try (Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
			
            // パラメータの設定
            pstmt.setString(1, name1);
            pstmt.setString(2, pass1);
            pstmt.setString(3, mail1);
            pstmt.setString(4, calendar1);
            pstmt.setString(5, name2);
            pstmt.setString(6, name3);
            pstmt.setString(7, calendar2);
            pstmt.setString(8, gendar1);


			
            // SQLの実行
            result = pstmt.executeUpdate();
        }		
        return result;
    }
}
