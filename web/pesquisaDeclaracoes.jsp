<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Declarações</title>
    </head>
    <body>
        <h1>Pesquisa de Declarações</h1>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Residência em República</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${declaracoes}" var="declaracao">
                <tr>
                    <td><c:out value="${declaracao.id}"/></td>
                    <td><c:if test="${declaracao.residenciaRepublica}">Verdadeiro</c:if>
                        <c:if test="${!declaracao.residenciaRepublica}">Falso</c:if>
                    </td>
                    <td><a href="ManterDeclaracaoController?acao=prepararEditar&codigoDeclaracao=<c:out value="${declaracao.id}"/>">Editar</a></td>
                    <td><a href="ManterDeclaracaoController?acao=prepararExcluir&codigoDeclaracao=<c:out value="${declaracao.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDeclaracaoController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
