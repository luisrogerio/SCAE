<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Modalidades</title>
    </head>
    <body>
        <h1>Pesquisa de Modalidades</h1>
        <table border="1">
            <tr>
                <th>Código Modalidades</th>
                <th>Nome Modalidades</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${modalidades}" var="modalidade">
                <tr>
                    <td><c:out value="${modalidade.id}"/></td>
                    <td><c:out value="${modalidade.nome}"/></td>
                    <td><a href="ManterModalidadeController?acao=prepararEditar&codigoModalidade=<c:out value="${modalidade.id}"/>">Editar</a></td>
                    <td><a href="ManterModalidadeController?acao=prepararExcluir&codigoModalidade=<c:out value="${modalidade.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterModalidadeController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
