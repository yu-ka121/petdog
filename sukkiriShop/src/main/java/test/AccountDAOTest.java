package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {
  public static void main(String[] args) {
    testFindByLogin1(); // ユーザーが見つかる場合のテスト
    testFindByLogin2(); // ユーザーが見つからない場合のテスト
  }

  public static void testFindByLogin1() {
    Login login = new Login("sayaka", "1234");
    AccountDAO dao = new AccountDAO();
    Account result = dao.findByLogin(login);
    if (result != null &&
    		result.getName().equals("湊さやか") &&
    		result.getPass().equals("1234") &&
    		result.getMail().equals("sayaka@sukkiri.com") &&
    		result.getBirthdate().equals("1995-12-01") &&
    		result.getUserId().equals("sayaka") &&
    		result.getPetname().equals("yuru") &&
    		result.getPetbirthdate().equals("2010-08-07") &&
    		result.getPetgender().equals("男の子")) {
      System.out.println("findByLogin1:成功しました");
    } else {
      System.out.println("findByLogin1:失敗しました");
    }
  }

  public static void testFindByLogin2() {
    Login login = new Login("minato", "12345");
    AccountDAO dao = new AccountDAO();
    Account result = dao.findByLogin(login);
    if (result == null) {
      System.out.println("findByLogin2:成功しました");
    } else {
      System.out.println("findByLogin2:失敗しました");
    }
  }
}