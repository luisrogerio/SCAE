<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Manter Curso - ${operacao}</h2>
        <form action="ManterCursoController?acao=confirmar${operacao}" method='POST'>
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textNome'>Nome</label></td>
                    <td><input type='text' name='textNome' value="${curso.nome}"></td>
                </tr>
                <tr>
                    <td><label for='selectTurno'>Turno</label></td>
                    <td>
                        <select name="selectTurno"<c:if test="${curso.turno == 'true'}">Selected</c:if>>
                            <option value="integral">Integral</option>
                            <option value="diurno">Diurno</option>
                            <option value="vespertino">Vespertino</option>
                            <option value="noturno">Noturno</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='selectTipo'>Tipo</label></td>
                    <td>
                        <select name="selectTipo"<c:if test="${curso.tipo == 'true'}">Selected</c:if>>
                            <option value="integrado">Integrado</option>
                            <option value="superior">Superior</option>
                            <option value="posGraduacao">Pós-Graduação</option>
                            <option value="concomitante">Concomitante Externo</option>
                            <option value="subsequente">Subsequente</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </table>
        </form>
    </body>
</html>