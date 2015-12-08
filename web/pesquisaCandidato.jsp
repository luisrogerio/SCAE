<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Candidatos</title>
    </head>
    <body>
        <h1>Pesquisa de Candidatos</h1>
        <table border="1">
            <tr>
                <th>Matrícula</th>
                <th>Nome</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${candidatos}" var="candidato">
                <tr>
                    <td><c:out value="${candidato.matricula}"/></td>
                    <td><c:out value="${candidato.nome}"/></td>
                    <td><a href="ManterCandidatoController?acao=prepararEditar&codigoCandidato=<c:out value="${candidato.matricula}"/>">Editar</a></td>
                    <td><a href="ManterCandidatoController?acao=prepararExcluir&codigoCandidato=<c:out value="${candidato.matricula}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCandidatoController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
