<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Mr+Dafoe&display=swap" rel="stylesheet">
<title>welcome to my page</title>
<style>
:root {
    --bg-color: rgb(209, 209, 209);
    --type-Speed: 6s;
    --type-Size: 20;
  }
  
  * {
    margin: 0;
    padding: 0;
  }
  
  body {
	font-family: 'Mr Dafoe', cursive;
    background-color: var(--bg-color);
    display: grid;
    place-content: center;
    height: 100vh;
    background-image: url("..//sukkiriShop/img/welcomedog.jpg");
  }
  
  main {
    text-align: center;
    font-size: 75px;
    
  }
  main a {
 	text-decoration: none;
 	
  }
  main a:hover {
 	color: green;
 	transition: text-shadow .25s;
 	text-shadow: 5px 5px 0 red;
 	font-size: 150px;
  }
  
  
  main h1 {
    font-size: 100px;
    font-weight: 400;
    position: relative;
    overflow: hidden;
  }
  
  main h1::before,
  h1::after {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
  }
  
  main h1::before {
    animation: typeWrite var(--type-Speed) steps(var(--type-Size)) 1s forwards;
    background: var(--bg-color);
  }
  
  main h1::after {
    animation: typeWrite var(--type-Speed) steps(var(--type-Size)) 1s forwards,
      blink 500ms steps(var(--type-Size)) infinite;
    background: black;
    width: 0.1em;
  }
  
  @keyframes typeWrite {
    to {
      left: 100%;
    }
  }
  
  @keyframes blink {
    to {
      background: transparent;
    }
  }
</style>

</head>
<body>
<main>
<h1>Welcome To</h1>


<a href="/sukkiriShop/petdog/main.jsp">My Page</a>
</main>


</body>
</html>
