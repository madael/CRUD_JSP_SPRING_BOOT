<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Formulário de projeto</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container my-5">
    <h3>Formulário de projeto</h3>
    <div class="card">
        <div class="card-body">
            <div class="col-md-10">
                <%--@elvariable id="projeto" type=""--%>
                <form:form method="post" modelAttribute="projeto" action="/projeto/form">
                    <form:hidden path="id"/>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="nome" class="col-form-label">Nome: </label>
                            <form:input type="text" class="form-control" id="nome" path="nome"
                                        placeholder="Nome: " required="required"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="dataInicio" class="col-form-label">Data início: </label>
                            <form:input type="date" class="form-control" id="dataInicio" path="dataInicio"
                                        placeholder="Data início: " required="required"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="dataPrevisaoFim" class="col-form-label">Data da previsão do fim: </label>
                            <form:input type="date" class="form-control" id="dataPrevisaoFim" path="dataPrevisaoFim"
                                        placeholder="Data da previsão do fim: " required="required"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="dataFim" class="col-form-label">Data do fim: </label>
                            <form:input type="date" class="form-control" id="dataFim" path="dataFim"
                                        placeholder="Data do fim: " required="required"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="descricao" class="col-form-label">Descrição: </label>
                            <form:input type="text" class="form-control" id="descricao" path="descricao"
                                        placeholder="Descrição: " required="required"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="status" class="col-form-label">Status: </label>
                            <form:select type="text" class="form-control" id="status" path="status" required="required">
                                <form:options items="${listaStatus}" itemValue="id" itemLabel="nome"></form:options>
                            </form:select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="orcamento" class="col-form-label">Orçamento: </label>
                            <form:input class="form-control" id="orcamento" path="orcamento"
                                        placeholder="0.00" required="required"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="risco" class="col-form-label">Classificação de risco: </label>
                            <form:select type="text" class="form-control" id="risco" path="risco" required="required">
                                <form:options items="${listaRisco}" itemValue="id" itemLabel="nome"></form:options>
                            </form:select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="gerente" class="col-form-label">Gerente responsável: </label>
                            <form:select type="text" class="form-control" id="gerente" path="gerente"
                                         required="required">
                                <form:options items="${listaGerentes}" itemValue="id" itemLabel="nome"></form:options>
                            </form:select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-8">
                            <label for="membros" class="col-form-label">Membros do projeto: </label>
                            <form:select multiple="true" type="text" class="form-control" id="membros" path="membros"
                                         required="required">
                                <form:options items="${listaMembros}" itemValue="id" itemLabel="nome"></form:options>
                            </form:select>
                        </div>
                    </div>
                    <div class="row">
                        <a type="button" class="btn btn-secondary col-2 mr-1" href="/projeto/">Cancelar</a>
                        <button type="submit" class="btn btn-success col-2 ml-1">Salvar</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
