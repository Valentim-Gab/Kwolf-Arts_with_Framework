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
    <title>Cadastre-se</title>

</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">

        <div class="titles">
            <h4 id="tituloCadastro">Escolha o tipo de conta para cadastrar</h4>
        </div>

        <div class="container superior">
            <div class="d-flex flex-column flex-lg-row gap-lg-5 w-100 justify-content-lg-center align-items-center">
                <input class="btn btn-light largeButton" type="button" value="COMPRADOR" alt="Comprador" onclick="cadastrarComprador()">
                <input class="btn btn-light largeButton" type="button" value="ARTISTA" alt="Artista" onclick="cadastrarArtista()">
            </div>

        </div>

        <form action="/kwolf_arts/cadastrar" method="post">
            <div id="containerCadastro" class="hide">
                <div class="d-flex flex-column flex-lg-row align-items-start gap-10">
                    <input class="campo" type="text" placeholder="Primeiro nome" name="primeiro_nome" id="primeiro_nome">
                    <input class="campo" type="text" placeholder="Segundo nome" name="segundo_nome" id="segundo_nome">
                </div>
                <div class="d-flex flex-column flex-lg-row align-items-start gap-10">
                    <input class="campo" type="email" placeholder="Endereço de email" name="email" id="email">
                    <input class="campo" type="text" placeholder="CPF" id="cpf" name="cpf">
                </div>
                <div class="d-flex flex-column flex-lg-row align-items-start gap-10">
                    <input class="campo" type="password" placeholder="Senha" name="senha" id="senha">
                    <input class="campo" type="password" placeholder="Digite a senha novamente" id="rSenha">
                </div>
                <br/>
                <div class="d-flex flex-column flex-lg-row align-items-start gap-2">
                    <p>Data de nascimento:</p>
                    <input type="date" name="data_nascimento" id="data_nascimento"
                           style="background: transparent; color: #FFFFFF">
                </div>
                <div class="right">
                    <input id="btnCadastrar" type="hidden" name="tipo_conta" />
                    <input class="btn btn-light largeButton" type="submit" value="CADASTRAR"
                           alt="Cadastrar" style="display: none;" id="cadastrarUsuarioConfirmar">

                    <input class="btn btn-light largeButton" type="button" value="CADASTRAR" alt="Cadastrar" id="cadastrarUsuario"
                    onclick="cadastrarUsuarioCampos('cadastrar')">
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