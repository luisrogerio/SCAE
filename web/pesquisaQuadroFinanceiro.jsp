<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Quadro Financeiro</title>
    </head>
    <body>
        <h1>Pesquisa de Quadro Financeiro</h1>
        <table border="1">
            <tr>
                <th>Código Quadro Financeiro</th>
                <th>Escolaridade do Familiar ou Candidato</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${quadrosFinanceiros}" var="quadroFinanceiro">
                <tr>
                    <td><c:out value="${quadroFinanceiro.id}"/></td>
                    <td><c:out value="${quadroFinanceiro.escolaridade}"/></td>
                    <td><a href="ManterQuadroFinanceiroController?acao=prepararEditar&codigoQuadroFinanceiro=<c:out value="${quadroFinanceiro.id}"/>">Editar</a></td>
                    <td><a href="ManterQuadroFinanceiroController?acao=prepararExcluir&codigoQuadroFinanceiro=<c:out value="${quadroFinanceiro.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterQuadroFinanceiroController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
