<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Formularios Socioeconômicos</title>
    </head>
    <body>
        <h1>Pesquisa de Formularios Socioeconômicos</h1>
        <table border="1">
            <tr>
                <th>Código Formulario Socioeconômico</th>
                <th>Nome Formulario Socioeconômico</th>
                <th colspan="2">Ação</th>
            </tr>

            <c:forEach items="${formulariosSocioeconomicos}" var="formularioSocioeconomico">
                <tr>
                    <td><c:out value="${formularioSocioeconomico.id}"/></td>
                    <td><c:out value="${formularioSocioeconomico.serieModuloPeriodo}"/></td>
                    <td><a href="ManterFormularioSocioeconomicoController?acao=prepararEditar&codigoFormularioSocioeconomico=<c:out value="${formularioSocioeconomico.id}"/>">Editar</a></td>
                    <td><a href="ManterFormularioSocioeconomicoController?acao=prepararExcluir&codigoFormularioSocioeconomico=<c:out value="${formularioSocioeconomico.id}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterFormularioSocioeconomicoController?acao=prepararIncluir" method="post">               
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
