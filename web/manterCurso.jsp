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
                        <select name="selectTurno">
                            <option value="integral" <c:if test="${candidato.instituicaoMedio == 'integral'}">selected</c:if>Integral</option>
                            <option value="diurno" <c:if test="${candidato.instituicaoMedio == 'diurno'}">selected</c:if>Diurno</option>
                            <option value="vespertino" <c:if test="${candidato.instituicaoMedio == 'vespertino'}">selected</c:if>Vespertino</option>
                            <option value="noturno" <c:if test="${candidato.instituicaoMedio == 'noturno'}">selected</c:if>>Noturno</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='selectTipo'>Tipo</label></td>
                    <td>
                        <select name="selectTipo"<c:if test="${curso.tipo == 'true'}">Selected</c:if>>
                            <option value="integrado" <c:if test="${candidato.instituicaoMedio == 'integrado'}">selected</c:if>Integrado</option>
                            <option value="superior" <c:if test="${candidato.instituicaoMedio == 'superior'}">selected</c:if>Superior</option>
                            <option value="posGraduacao" <c:if test="${candidato.instituicaoMedio == 'posGraduacao'}">selected</c:if>Pós-Graduação</option>
                            <option value="concomitante" <c:if test="${candidato.instituicaoMedio == 'comcomitante'}">selected</c:if>Concomitante Externo</option>
                            <option value="subsequente" <c:if test="${candidato.instituicaoMedio == 'subsequente'}">selected</c:if>Subsequente</option>
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