<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista de projeto</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row col-12">
        <h1 class="col-10">Lista de projeto</h1>
        <div class="col-2 mt-2">
            <a type="button" class="btn btn-success col-12" href="/projeto/criar">Criar Prjeto</a>
        </div>
    </div>
    <div class="panel-body">
        <table class="table table-striped">
            <tr>
                <th class="col-1">Código</th>
                <th class="col-5">Nome</th>
                <th class="col-2">Status</th>
                <th class="col-2">Risco</th>
                <th class="col-2">Ações</th>
            </tr>
            <c:forEach items="${projetos}" var="projeto">
                <tr>
                    <td><c:out value="${projeto.getId()}"/></td>
                    <td><c:out value="${projeto.getNome()}"/></td>
                    <td><c:out value="${projeto.getStatusTaduzido()}"/></td>
                    <td><c:out value="${projeto.getRiscoTaduzido()}"/></td>
                    <td class="text-center">
                        <a type="button" class="btn btn-warning col-5"
                           href="/projeto/editar?id=${projeto.getId()}">Editar</a>
                        <a type="button" class="btn btn-danger col-6" href="/projeto/excluir?id=${projeto.getId()}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
