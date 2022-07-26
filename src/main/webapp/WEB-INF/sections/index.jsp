<%--
  Created by IntelliJ IDEA.
  User: Aluno
  Date: 04/05/2022
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div class="container">
        <div class="titles">
            <h1>Kwolf Arts - Artes digitais</h1>
            <h3>Compre artes para usar em seu negócio!</h3>
        </div>

        <h2>Artes a venda</h2>
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                        class="active" aria-current="true" aria-label="Slide 0"></button>

                <c:forEach items="${artes}" step="3" begin="3" varStatus="theCount">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${theCount.count}"
                                aria-label="Slide ${theCount.count}"></button>
                </c:forEach>

            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="row align-items-start">

                        <c:forEach items="${artes}" var="a" end="2" varStatus="theCount">
                        <div class="col">
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
                        </div>
                        </c:forEach>

                    </div>
                </div>

                <c:forEach items="${artes}" var="c" step="3" begin="3" varStatus="theCount">
                <div class="carousel-item">
                    <div class="row align-items-start">
                        <c:forEach items="${artes}" var="a" begin="${theCount.index}" end="${theCount.index+2}">
                            <div class="col">
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
                            </div>
                        </c:forEach>

                    </div>
                </div>
                </c:forEach>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev" style="width: 125px">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next" style="width: 125px">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>

</html>

