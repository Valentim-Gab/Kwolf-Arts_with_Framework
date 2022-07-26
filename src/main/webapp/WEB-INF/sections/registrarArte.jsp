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
    <title>Registre sua arte</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">
        <form action="/kwolf_arts/registre-sua-arte" method="post">
            <div class="d-flex flex-column flex-lg-row gap-5 justify-content-center align-items-center">
                <div>
                    <input type="file" id="arteUp" name="arteUp" accept="image/*"/>
                    <h4>Clique para alterar</h4>
                    <div class="arte d-flex justify-content-center align-items-center">
                        <div class="max-width">
                            <!--<input class="btn btn-light mb-2" type="button" value="ESCOLHER IMAGEM" alt="selecione uma imagem">-->
                            <div>
                                <img src="images/uploadArte.png" alt="Selecione uma imagem" id="imgArteUp" />
                                <input type="hidden" id="imagem" name="imagem" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="w-50">
                    <h4>Registre sua arte</h4>
                    <input class="campo" type="text" name="nome" placeholder="Nome">
                    <input class="campo" type="text" name="copyright" placeholder="Copyright">
                    <input class="campo" type="text" name="valor" placeholder="Valor (R$) ">
                    <input class="campo" type="text" name="adicional" placeholder="Adicional (opcional)">
                    <div class="right">
                        <input class="btn btn-light largeButton" type="submit" value="CADASTRAR" alt="Cadastrar">
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