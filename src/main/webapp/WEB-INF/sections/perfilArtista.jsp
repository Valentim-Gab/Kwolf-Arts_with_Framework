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
    <title>Perfil do artista</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">
        <div class="titles">
            <h1 id="tituloLogin">Perfil do artista ${artista.primeiro_nome}</h1>
        </div>
        <br/>
        <div class="d-flex flex-column aligm-items-center gap-5">
            <figure style="margin: auto">
                <img src="<c:url value="/images/perfil_nulo.png"/>" alt="Foto do artista" width="200px">
            </figure>
            <div class="d-flex flex-column gap-3 align-items-center justify-content-center" style="text-align: left">
                <h4>Primeiro nome:</h4>
                <h5>${artista.primeiro_nome}</h5>
                <br/>
                <h4>Segundo nome:</h4>
                <h5>${artista.segundo_nome}</h5>
                <br/>
                <h4>Nacionalidade:</h4>
                <h5>${artista.nacionalidade}</h5>
                <br/>
                <h4>Data de Nascimento:</h4>
                <input type="date" value="${artista.data_nascimento}" style="border: none;
                    background: transparent; color: #FFFFFF; text-align: center" disabled/>
                <br/>
                <h4>Número de artes:</h4>
                <h5>${artista.num_artes}</h5>
            </div>
        </div>
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>
</html>
