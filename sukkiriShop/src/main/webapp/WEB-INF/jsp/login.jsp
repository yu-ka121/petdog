<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Mr+Dafoe&display=swap" rel="stylesheet">
<title>ログイン画面</title>
<style>

body {
	font-family: 'Mr Dafoe', cursive;
    font-size: 75px;
    background-image:url(../sukkiriShop/img/dog.jpg);
  /* 画像を常に天地左右の中央に配置 */
    background-position: center center;
   
  /* 画像をタイル状に繰り返し表示しない */
    background-repeat: no-repeat;
   
  /* コンテンツの高さが画像の高さより大きい時、動かないように固定 */
    background-attachment: fixed;
   
  /* 表示するコンテナの大きさに基づいて、背景画像を調整 */
    background-size: cover;
   
  /* 背景画像が読み込まれる前に表示される背景のカラー */
    background-color: #464646;
    
    text-align: center;
    background-size: 100% 100%;
    color: green;
}

input[type="text"],
input[type="password"]{
    height: 35px;
    width: 400px;
    text-align: center;
    padding-top: 100px;
}

input[type="submit"]{
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

input:hover[type="submit"]{
    background-color: #00FF33;
    color: #24292e;
    cursor: pointer;
    font-size: 55px;
    text-shadow: 5px 5px 0 rgb(140, 156, 140);
    
}

</style>
</head>
<body>
<form action="/sukkiriShop/LoginServlet" method="post">
USERID<br>
<input type="text" name="userId"><br>
PASSWORD<br>
<input type="password" name="pass"><br>
<input type="submit" value="Login">
</form>
</body>
</html>