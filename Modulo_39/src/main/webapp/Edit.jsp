<jsp:useBean id="levels" scope="request" type="java.util.Collection"/>
<jsp:useBean id="level" scope="request" type="java.lang.String"/>
<jsp:useBean id="title" scope="request" type="java.lang.String"/>
<jsp:useBean id="description" scope="request" type="java.lang.String"/>
<%--
  Created by IntelliJ IDEA.
  User: klsp2
  Date: 19/02/2025
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <title>To do list java</title>
    <link rel="stylesheet" type="text/css" href="css/global.css">
    <link rel="stylesheet" type="text/css" href="css/Forms.css">
  </head>
  <body>

    <div class="container">
      <aside class="aside">
        <a class="aside-link button" href="PageServlet?userid=${param.userid}" onclick="iniciarLoader()">Return to task list</a>
      </aside>
      <main class="mainContainer">

        <h2 class="title">Edit task</h2>

        <form class="form"
              action="<%=
              request.getContextPath() %>/EditServlet?userid=${param.userid}&taskid=${param.taskid}"
              method="post"
              onsubmit="iniciarLoader()"
        >
          <label for="title" class="form-label">Title: </label>
          <input id="title"
                 class="form-input"
                 type="text"
                 required
                 maxlength="50"
                 name="title"
                 placeholder="Title"
                 value="${title}"
          />

          <label for="description" class="form-label">Description: </label>
          <textarea id="description"
                    class="form-input"
                    required
                    maxlength="150"
                    name="description"
                    placeholder="Description">${description}</textarea>

          <label class="form-label">Level: </label>

          <c:forEach var="entry" items="${levels}">
            <label class="form-checkbox">
              <input type="checkbox"
                     name="options"
                     value="${entry}"
                     class="checkbox-option"
                     onclick="onlyOne(this)"
                ${entry == level ? 'checked' : ''}
              >
                ${entry}
            </label>
          </c:forEach>

          <% if (request.getAttribute("errorMessageOptions") != null) { %>
          <p class="error"><%= request.getAttribute("errorMessageOptions") %></p>
          <% } %>

          <div class="buttons">
            <button class="form-button button" type="submit" onclick="iniciarLoader()">Save</button>
            <a class="aside-link button" href="PageServlet?userid=${param.userid}&title=&filter=" onclick="iniciarLoader()">Cancel</a>
          </div>

        </form>
      </main>
    </div>

    <script src="Js/add.js" defer></script>
    <script src="Js/global.js" defer></script>
  </body>
</html>
