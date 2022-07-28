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
    <title>Pesquisa</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="titles">
        <h1>Resultado da pesquisa</h1>
    </div>
    <div class="container principal">
        <div class="d-flex flex-wrap">
            <c:forEach items="${artes}" var="a" varStatus="theCount">
                <div class="card">
                    <div class="card-img-body d-flex justify-content-center align-items-center">
                        <img src="${a.imagem}"
                             class="card-img" alt="Arte digital1 um">
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${a.nome}</h5>
                        <hr>
                        <form action="/kwolf_arts/perfil-artista" method="post">
                            <p class="card-text">
                                Artista: <input class="inputArtista" type="submit" value="${a.usuario.primeiro_nome}" />
                                <input type="hidden" name="id_artista" value="${a.usuario.id_comprador}">
                            </p>
                        </form>
                        <div class="d-flex flex-row gap-5">
                            <p class="valor">${a.valor}R$</p>
                            <form action="/kwolf_arts/comprar-arte" method="post">
                                <input type="hidden" name="id_arte" value="${a.id_arte}">
                                <input class="btn btn-light" type="submit" value="COMPRAR" alt="comprar">
                            </form>
                        </div>
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