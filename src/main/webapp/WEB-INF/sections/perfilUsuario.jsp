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
    <title>Seu perfil</title>
</head>

<body>
<header>
    <jsp:include page="../shared/header.jsp" />
</header>

<section>
    <div class="container principal">
        <div class="titles">
            <h4>Minha conta</h4>
        </div>
        <div id="containerEditar">
            <form action="/kwolf_arts/editar" method="post">
                <input type="hidden" name="id_comprador" value="${usuario.id_comprador}">
                <input type="hidden" name="tipo_conta" value="${usuario.tipo_conta}">
                <div class="d-flex flex-column flex-lg-row align-items-start gap-10">
                    <input class="campo" type="text" placeholder="Primeiro nome" name="primeiro_nome" id="primeiro_nome" value="${usuario.primeiro_nome}">
                    <input class="campo" type="text" placeholder="Segundo nome" name="segundo_nome" id="segundo_nome" value="${usuario.segundo_nome}">
                </div>
                <div class="d-flex flex-column flex-lg-row align-items-start gap-10">
                    <input class="campo" type="email" placeholder="Endereço de email" name="email" id="email" value="${usuario.email}">
                    <input class="campo" type="text" placeholder="CPF" name="cpf" id="cpf" value="${usuario.cpf}">
                </div>
                <div class="d-flex flex-column flex-lg-row align-items-start gap-10">
                    <input class="campo" type="password" placeholder="Senha" name="senha" id="senha">
                    <input class="campo" type="password" placeholder="Digite a senha novamente" id="rSenha">
                </div>
                <div class="d-flex flex-column flex-lg-row align-items-start gap-10">
                    <input class="campo" type="text" placeholder="Telefone" name="telefone" value="${usuario.telefone}">
                    <input class="campo" type="text" placeholder="Nacionalidade" name="nacionalidade" value="${usuario.nacionalidade}">
                </div>
                <div class="d-flex flex-column flex-lg-row align-items-start gap-2">
                    <p>Data de nascimento:</p>
                    <input type="date" name="data_nascimento" id="data_nascimento"
                           style="background: transparent; color: #FFFFFF" value="${usuario.data_nascimento}">
                </div>
                <br/>
                <div class="right">
                    <input class="btn btn-light largeButton" type="submit" value="CONFIRMAR"
                           alt="Confirmar alterações" style="display: none" id="editarUsuarioCampos">
                    <input class="btn btn-light largeButton" type="button" value="CONFIRMAR"
                           alt="Confirmar alterações" onclick="cadastrarUsuarioCampos('editar')">
                </div>
            </form>
            <form action="/kwolf_arts/deletar" method="post">
                <div>
                    <input type="hidden" name="id" value="${usuario.id_comprador}">
                    <input type="hidden" name="tipo_conta" value="${usuario.tipo_conta}">

                    <input class="btn btn-light" type="submit" id="inputDeletarConfirmar" value="DELETAR CONTA"
                           alt="Deletar sua conta" style="display: none">

                    <input class="btn btn-light" type="button" id="inputDeletar" value="DELETAR CONTA"
                           alt="Deletar sua conta" onclick="deletarConta()">
                </div>
            </form>
        </div>
    </div>
</section>

<footer>
    <p>&copy; KwolfArts</p>
</footer>
</body>
</html>