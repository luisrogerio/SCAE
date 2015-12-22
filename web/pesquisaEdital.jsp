<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Editais</title>
    </head>
    <body>
        <h1>Pesquisa de Editais</h1>
        <table border="1">
            <tr>
                <th>Código Edital</th>
                <th>Ano do Edital</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${editais}" var="edital">
                <tr>
                    <td><c:out value="${edital.id}"/></td>
                    <td><c:out value="${edital.descricao}"/></td>
                    <td><a href="ManterEditalController?acao=prepararEditar&codigoEdital=<c:out value="${edital.id}"/>">Editar</a></td>
                    <td><a href="ManterEditalController?acao=prepararExcluir&codigoEdital=<c:out value="${edital.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterEditalController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
