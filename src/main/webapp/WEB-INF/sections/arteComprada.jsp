<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 04/05/2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="pt-Br">

<head>
    <jsp:include page="../shared/head.jsp"></jsp:include>
    <title>Artes compradas</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">
        <div class="d-flex flex-column gap-5">
            <h1>Suas compras</h1>
            <c:forEach items="${artesCompradas}" var="a">
                <div>
                    <div>
                        <form action="/kwolf_arts/ver-arte" method="post">
                            <button type="submit" class="arteComprada" style="width: 100%">
                                <input type="hidden" name="id_arte_comprada" value="${a.id_arte}">
                                <div class="d-flex flex-lg-row flex-column gap-5">
                                    <div style="width: 225px">
                                        <img src="${a.imagem}" alt="..." width="100%">
                                    </div>
                                    <div class="d-flex flex-column gap-4 align-self-center" style="text-align: justify">
                                        <h5 class="card-title">${a.nome}</h5>
                                        <p>Copyright: ${a.copyright}</p>
                                        <p>Adicional: ${a.adicional}</p>
                                    </div>
                                </div>
                                <hr/>
                            </button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>

</html>