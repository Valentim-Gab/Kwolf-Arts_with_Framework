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
    <title>Início</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp"></jsp:include>
</header>

<section>
    <div class="container principal">
        <div class="titles">
            <h1>Kwolf Arts - Artes digitais</h1>
            <h3>Venda suas artes com facilidade</h3>
        </div>


        <h2>Suas artes a venda </h2>
        <c:forEach items="${artes}" var="a">
            <div class="d-flex flex-lg-row flex-column align-items-left gap-5 mt-5" style="width: 100%">
                <div style="width: 100px">
                    <img src="${a.imagem}" alt="..." width="100%">
                </div>
                <div>
                    <h5 class="card-title">${a.nome}</h5>

                    <p class="valor" style="text-align: left;">${a.valor}R$</p>
                </div>

                <div class="d-flex flex-row align-self-center right" style="width: 100%">
                    <form action="/kwolf_arts/editar-arte" method="get">
                        <input type="hidden" name="id_arte" value="${a.id_arte}" />
                        <input class="btn btn-light" type="submit"
                               value="EDITAR" alt="EDITAR" />
                    </form>
                    <form action="/kwolf_arts/deletar-arte" method="post">
                        <input type="hidden" name="id_arte" value="${a.id_arte}" />
                        <input class="btn btn-light" type="submit" value="EXCLUIR" alt="EXCLUIR"
                               onclick="return confirm('Deseja mesmo excluir essa arte?')" />
                    </form>
                </div>
            </div>
            <hr/>
        </c:forEach>
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>

</html>

