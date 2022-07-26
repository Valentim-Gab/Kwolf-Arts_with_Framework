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
    <title>Sobre</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">
        <div class="titles">
            <h4 id="tituloLogin">Sobre nós</h4>
        </div>

        <div>
            <h2>Objetivos:</h2>
            <h5>
                <strong>Kwolf Arts</strong> é uma extensão da empresa <strong>Kwolf</strong>. A Kwolf Arts é uma
                empresa focada em vendas de artes digitais, ou seja, repassar existentes na internet de pessoas para
                outras pessoas, mas com segurança e direitos reservados. Além disso, a empresa tem o objetivo de
                facilitar a criação de projetos que necessitam de imagens/artes mais trabalhadas.
            </h5>
            <hr/>
        </div>
        <br/>
        <div>
            <h2>História:</h2>
            <h5>
                A Kwolf nasceu como uma micro-empresa de alguns jovens que queriam se lançar no mercado de trabalho.
                Começou a partir de pequenos projetos e pequenas vendas e muito disso apenas usando redes sociais.
            </h5>
            <hr/>
        </div>
        <br/>
        <div>
            <h2>Local de origem:</h2>
            <h5>
                Cidade: Santa Maria
            </h5>
            <h5>
                Estado: Rio Grande do Sul
            </h5>
            <h5>
                País: Brasil
            </h5>
            <hr/>
        </div>
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>
</html>
