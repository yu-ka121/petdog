<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>確認画面</title>
	<style>
		body {
		width: 100%;
		background-image:url(../sukkiriShop/img/yasumuradog.png);
		/* 画像を常に天地左右の中央に配置 */
		background-position: center center;
		/* 画像をタイル状に繰り返し表示しない */
		background-repeat: no-repeat;
		/* 表示するコンテナの大きさに基づいて、背景画像を調整 */
		background-size: cover;  
		/* 背景画像が読み込まれる前に表示される背景のカラー */
		background-color: #464646;    
		text-align: center;
		/*  background-size: 100% 100%; */
		}
		
		h2 {
		    font-size: 30px;
		}
		
		.menu {
		    font-size: 40px;
		}
		

		
		
		input[type="submit"],
		input[type="reset"]{
		    height: 55px;
		    width: 400px;
		    text-align: center;
		    padding-top: 100px;
		}
		
		input[type="submit"],
		input[type="reset"]{
		    border: 1px solid #24292e;
		    background-color: #66FF99;
		    width: 300px;
		    height: 100px;
		    padding: 15px 0;
		    color: #fff;
		    transition: all 0.5s;
		    font-family: 'Mr Dafoe', cursive;
		    font-size: 30px;
		    margin-top: 50px;
		    
		}
		
		input:hover[type="submit"],
		input:hover[type="reset"]{
		    background-color: #00FF33;
		    color: #24292e;
		    cursor: pointer;
		    font-size: 60px;
		    text-shadow: 5px 5px 0 rgb(140, 156, 140);
		}
		

		a {
		    border: 1px solid #24292e;
		    background-color: #66FF99;
		    width: 300px;
		    height: 100px;
		    padding: 15px 0;
		    color: #fff;
		    transition: all 0.5s;
		    font-family: 'Mr Dafoe', cursive;
		    font-size: 30px;
		    margin-top: 50px;
		    
		}
		
		a:hover {
		    background-color: #00FF33;
		    color: #24292e;
		    cursor: pointer;
		    font-size: 60px;
		    text-shadow: 5px 5px 0 rgb(140, 156, 140);
		}
		

		
	</style>
</head>
  
<body>
	<h2>入力情報を確認して登録ボタンを押してください</h2>
	<form action="/sukkiriShop/RegisterServlet2" method="post">
	<div class="menu">
		お名前：<strong><c:out value="${account.name}" /></strong><br/>
		パスワード：<strong><c:out value="${account.pass}" /></strong><br/>
		メールアドレス：<strong><c:out value="${account.mail}" /></strong><br/>
		生年月日：<strong><c:out value="${account.birthdate}" /></strong><br/>
		ユーザーID：<strong><c:out value="${account.userId}" /></strong><br/>
		愛犬のお名前：<strong><c:out value="${account.petname}" /></strong><br/>
		愛犬の生年月日：<strong><c:out value="${account.petbirthdate}" /></strong><br/>
		愛犬の性別：<strong><c:out value="${account.petgender}" /></strong><br/>
	</div>
	<input type="submit" value="登録" />
		<a href="/sukkiriShop/html/register.html">戻る</a>
	<br/><br/>
	（この画面はフォワード先のJSPで出力しています）
	</form>

</body>
</html>

