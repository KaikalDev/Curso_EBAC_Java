<%--
  Created by IntelliJ IDEA.
  User: klsp2
  Date: 19/02/2025
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>To do list java</title>
    <link rel="stylesheet" type="text/css" href="css/global.css">
    <link rel="stylesheet" type="text/css" href="css/Forms.css">
</head>
<body>
    <div class="container">
        <aside class="aside">
            <a class="aside-link button" href="Register.jsp">Register</a>
            <a class="aside-link button" href="login.jsp">Login</a>
        </aside>
        <main class="mainContainer">
            <h2 class="title">Register</h2>
            <form class="form" action="<%= request.getContextPath() %>/RegisterServlet" method="post" onsubmit="iniciarLoader()">
                <label for="name" class="form-label">User name: </label>
                <input id="name"
                       class="form-input"
                       type="text"
                       required
                       maxlength="50"
                       name="name"
                >

                <% if (request.getAttribute("errorMessageUser") != null) { %>
                <p class="error"><%= request.getAttribute("errorMessageUser") %>
                </p>
                <% } %>


                <label for="email" class="form-label">E-mail: </label>
                <input id="email"
                       class="form-input"
                       type="email"
                       required
                       maxlength="100"
                       name="email"
                >

                <label for="password" class="form-label">Password: </label>
                <input id="password"
                       class="form-input"
                       type="text"
                       required
                       maxlength="8"
                       minlength="8"
                       name="password"
                >

                <label for="confirmPassword" class="form-label">Confirm Password: </label>
                <input id="confirmPassword"
                       class="form-input"
                       type="password"
                       required
                       maxlength="8"
                       minlength="8"
                       name="confirmPassword"
                >

                <% if (request.getAttribute("errorMessagePassword") != null) { %>
                <p class="error"><%= request.getAttribute("errorMessagePassword") %>
                </p>
                <% } %>

                <button class="form-button button" onclick="iniciarLoader()">Register</button>

                <% if (request.getAttribute("errorMessage") != null) { %>
                <p class="error"><%= request.getAttribute("errorMessage") %>
                </p>
                <% } %>

            </form>
        </main>
    </div>
    <script src="Js/global.js" defer></script>
</body>
</html>
