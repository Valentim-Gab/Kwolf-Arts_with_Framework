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
    <title>Logar-se</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">

        <div class="titles">
            <h4 id="tituloLogin">Escolha o tipo de conta para logar</h4>
        </div>

        <div class="container superior">
            <div class="d-flex flex-column flex-lg-row gap-lg-5  w-100 justify-content-lg-center align-items-center">
                <input class="btn btn-light largeButton" type="button" value="COMPRADOR" alt="Comprador" onclick="loginComprador()">
                <input class="btn btn-light largeButton" type="button" value="ARTISTA" alt="Artista" onclick="loginArtista()">
            </div>

        </div>

        <form action="login" method="post">
            <div id="containerLogin" class="hide">
                <div class="d-flex flex-column gap-10 align-items-lg-center align-items-center">
                    <input class="campoLogin" type="email" placeholder="Email" name="email">
                    <input class="campoLogin" type="password" placeholder="Senha" name="senha">
                    <input class="campoLogin" type="hidden" id="tipo_conta" placeholder="Senha" name="tipo_conta">
                </div>
                <div class="d-flex flex-column gap-10 align-items-lg-center align-items-center mb-5">
                    <input class="btn btn-light largeButton" type="submit" value="LOGAR" alt="Logar" name="login">
                </div>
            </div>
            <div>
                <c:if test="${not empty erro}">
                    <div>
                        <h3>${erro}</h3>
                    </div>
                </c:if>
            </div>

        </form>

    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>
</html>
