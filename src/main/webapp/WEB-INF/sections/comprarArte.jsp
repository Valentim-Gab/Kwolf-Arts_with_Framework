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
    <title>Compre uma arte</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">

        <div class="titles">
            <h4>Comprar arte</h4>
        </div>

        <div class="d-flex flex-column flex-lg-row gap-2 justify-content-center align-items-center">
            <div>
                <div class="d-flex flex-column justify-content-center align-items-center gap-3">
                    <div class="arteComprar">
                        <img class="arteVenda" src="${arte.imagem}" alt="Arte para comprar" />
                    </div>
                    <p class="bigValor"> ${arte.valor}R$ </p>

                    <c:if test="${arte.nome == 'Gojou'}">
                        <audio controls autoplay>
                            <source src="images/jujutsuOp.mp3" type="audio/mpeg">
                        </audio>
                    </c:if>
                </div>
            </div>
            <div class="w-50 d-flex flex-column justify-content-center gap-4">
                <p>Nome da arte: ${arte.nome}</p>
                <p>Artista: <a href="#">${arte.usuario.primeiro_nome}</a></p>
                <p>Copyright: ${arte.copyright}</p>
                <p>Adicional: ${arte.adicional}</p>

                <div class="right">
                    <form action="/kwolf_arts/confirmar-compra" method="post">
                        <input type="hidden" name="id_arte" value="${arte.id_arte}">
                        <input class="btn btn-light largeButton" type="submit" value="COMPRAR" alt="Comprar">
                    </form>
                </div>
            </div>

        </div>

    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>

</html>