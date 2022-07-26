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
    <title>Artistas mais populares</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">
        <div class="titles">
            <h4 id="tituloLogin">Artistas mais populares</h4>
        </div>
        <br/>
        <div>
            <c:forEach items="${artista}" var="a">
                <div>
                    <div>
                        <form action="/kwolf_arts/perfil-artista" method="post">
                            <button type="submit" class="arteComprada" style="width: 100%">
                                <input type="hidden" name="id_artista" value="${a.id_comprador}">
                                <div class="d-flex flex-lg-row flex-column gap-5 align-items-center">
                                    <div style="width: 200px">
                                        <img src="images/perfil_nulo.png" alt="..." width="80%">
                                    </div>
                                    <div class="d-flex flex-column gap-3 align-self-center" style="text-align: left">
                                        <h5 class="card-title">${a.primeiro_nome} ${a.segundo_nome}</h5>
                                        <p>Nacionalidade: ${a.nacionalidade}</p>
                                        <p>Data de Nascimento: ${a.data_nascimento}</p>
                                        <p>Número de artes: ${a.num_artes}</p>
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
