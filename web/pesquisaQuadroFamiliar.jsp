<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Quadro Familiar</title>
    </head>
    <body>
        <h1>Pesquisa de Quadro Familiar</h1>
        <table border="1">
            <tr>
                <th>Código Quadro Familiar</th>
                <th>Doença do Familiar ou Candidato</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${quadrosFamiliares}" var="quadroFamiliar">
                <tr>
                    <td><c:out value="${quadroFamiliar.id}"/></td>
                    <td><c:out value="${quadroFamiliar.doenca}"/></td>
                    <td><a href="ManterQuadroFamiliarController?acao=prepararEditar&codigoQuadroFamiliar=<c:out value="${quadroFamiliar.id}"/>">Editar</a></td>
                    <td><a href="ManterQuadroFamiliarController?acao=prepararExcluir&codigoQuadroFamiliar=<c:out value="${quadroFamiliar.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterQuadroFamiliarController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
