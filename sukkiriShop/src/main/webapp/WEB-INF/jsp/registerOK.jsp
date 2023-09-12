<%@page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>確認画面</title>
	<style>
		body {
		width: 100%;
		background-image:url(../sukkiriShop/img/kinnikudog.png);
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
		    font-size: 50px;
		}
	

		
		
		a {
		    height: 55px;
		    width: 400px;
		    text-align: center;
		    padding-top: 100px;
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
	<h2>登録が完了しました！</h2>
	<a href="/sukkiriShop/startpege/start.html">トップへ</a>
</body>
</html>

