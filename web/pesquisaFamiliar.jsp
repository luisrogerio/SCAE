<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Familiares</title>
    </head>
    <body>
        <h1>Pesquisa de Familiares</h1>
        <table border="1">
            <tr>
                <th>Código Familiar</th>
                <th>Nome Familiar</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${familiares}" var="familiar">
                <tr>
                    <td><c:out value="${familiar.id}"/></td>
                    <td><c:out value="${familiar.descricao}"/></td>
                    <td><a href="ManterFamiliarController?acao=prepararEditar&codigoFamiliar=<c:out value="${familiar.id}"/>">Editar</a></td>
                    <td><a href="ManterFamiliarController?acao=prepararExcluir&codigoFamiliar=<c:out value="${familiar.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFamiliarController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
