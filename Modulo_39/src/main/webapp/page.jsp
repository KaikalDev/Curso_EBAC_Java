<%--
  Created by IntelliJ IDEA.
  User: klsp2
  Date: 19/02/2025
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>To do list java</title>
    <link rel="stylesheet" type="text/css" href="css/global.css">
    <link rel="stylesheet" type="text/css" href="css/Forms.css">
    <link rel="stylesheet" type="text/css" href="css/page.css">
</head>
    <body>
        <div id="loader">
            <div class="spinner"></div>
        </div>

        <div class="container">
        <jsp:useBean id="WorksSize" scope="request" type="java.lang.Long"/>
        <jsp:useBean id="filterCounts" scope="request" type="java.util.Map"/>
        <jsp:useBean id="Works" scope="request" type="java.util.Collection"/>
            <aside class="aside">
                <form class="form-filter" method="post" action="<%= request.getContextPath() %>/PageServlet?userid=${param.userid}" id="filterForm">
                    <label>
                        <input id="searchInput"
                               class="form-input"
                               type="text"
                               placeholder="Buscar"
                               name="title"
                               value="${param.title}"
                        >
                    </label>
                    <div class="aside-filters">
                        <c:forEach var="entry" items="${filterCounts}">
                            <button class="filter ${param.filter == entry.key ? 'active' : ''}"
                                    value="${entry.key}"
                                    type="submit"
                                    name="filter"
                            >
                                <p>${entry.value}</p>
                                <p>${entry.key}</p>
                            </button>
                        </c:forEach>
                        <button class="filter ${param.filter == "" ? 'active' : ''}" type="submit" name="filter" value="">
                            <p>${WorksSize}</p>
                            <p>Todas</p>
                        </button>
                    </div>
                </form>
            </aside>
            <main class="mainContainer">
                <c:forEach var="work" items="${Works}">
                    <div class="card">
                        <label class="card-title" for="${work.title}">
                            <input id="${work.title}"
                                   type="checkbox"
                                   onclick="(function() {
                                        iniciarLoader();
                                        setTimeout(() => {
                                            window.location.href = 'EditServlet?userid=${param.userid}&taskid=${work.id}&completed=true';
                                        }, 200);
                                   })()"
                                ${work.status == 'CONCLUIDA' ? 'checked' : ''}
                            />

                            <h2 class="card-title-text title">${work.title}</h2>
                        </label>

                        <div class="tags">
                            <span class="tag ${work.status}">${work.status}</span>
                            <span class="tag ${work.level}">${work.level}</span>
                        </div>

                        <label>
                            <textarea class="card-textarea" disabled>${work.description}</textarea>
                        </label>

                        <div>
                            <a class="button form-button" href="EditServlet?userid=${param.userid}&taskid=${work.id}">Edit</a>
                            <button class="button aside-link" onclick=" (
                                    function confirmDelete() {
                                    const confirmation = confirm('Are you sure you want to delete this task?');
                                    if (confirmation) {
                                    window.location.href = `DeleteServlet?userid=${param.userid}&taskid=${work.id}`;
                                    }
                                    }
                                    )() ">Delete</button>
                        </div>
                    </div>

                </c:forEach>
            </main>
        </div>

        <a  class="addButton" href="${pageContext.request.contextPath}/AddServlet?userid=${param.userid}">+</a>

        <script src="Js/page.js" defer></script>
        <script src="Js/global.js" defer></script>
    </body>
</html>
