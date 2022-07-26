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
    <title>Edite sua arte</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">
        <form action="/kwolf_arts/editar-arte" method="post">
            <div class="d-flex flex-column flex-lg-row gap-5 justify-content-center align-items-center">
                <div>
                    <h4>Arte</h4>
                    <div class="arte d-flex justify-content-center align-items-center">
                        <div class="max-width">
                            <!--<input class="btn btn-light mb-2" type="button" value="ESCOLHER IMAGEM" alt="selecione uma imagem">-->
                            <div class="imageContainer">
                                <img src="${arte.imagem}" alt="Arte imagem" width="300px"/>
                                <input type="hidden" name="id_imagem" value="${arte.id_arte}" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="w-50">
                    <h4>Edite sua arte</h4>
                    <input class="campo" type="hidden" name="id_arte" value="${arte.id_arte}">
                    <input class="campo" type="text" name="nome" placeholder="Nome" value="${arte.nome}">
                    <input class="campo" type="text" name="copyright" placeholder="Copyright" value="${arte.copyright}">
                    <input class="campo" type="text" name="valor" placeholder="Valor (R$)" value="${arte.valor}">
                    <input class="campo" type="text" name="adicional" placeholder="Adicional (opcional)" value="${arte.adicional}">
                    <div class="right">
                        <input class="btn btn-light largeButton" type="submit" value="CONFIRMAR" alt="Confirmar">
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>
</html>