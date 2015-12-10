<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Familiares</h2>
        <form action="ManterFamiliarController?acao=confirmar${operacao}" method='POST'>
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' value="${familiar.codigo}" name='textId' <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Formulário Socioecômico</td>
                        <td>
                            <select name="selectFormularioSocioeconomico" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                              <option value="0" <c:if test="${familiar.formularioSocioeconomico == null}">selected</c:if>></option>
                                <c:forEach items="${formulariosSocioeconomicos}" var="a">
                                    
                                    <option value="${a.id}">${a.id}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for='textNome'>Nome</label></td>
                        <td><input type='text' name='textNome' value="${familiar.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${familiar.nome}"></td>
                    </tr>
                    <tr>
                        <td><label for='textDataNascimento'>Data de Nascimento</label></td>
                        <td><input type='text'  name='textDataNascimento' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${familiar.dataNascimento}" ></td>
                    </tr>
                    <tr>
                        <td><label for='textCPF'>CPF</label></td>
                        <td><input type='text' name='textCPF' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${familiar.CPF}"></td>
                    </tr>
                    <tr>
                        <td><label for='textIdentidade'>Identidade</label></td>
                        <td><input type='text' name='textIdentidade' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${familiar.identidade}"></td>
                    </tr>
                    <tr>
                        <td><label for='textNacionalidade'>Nacionalidade</label></td>
                        <td><input type='text' name='textNacionalidade' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${familiar.nacionalidade}"></td>
                    </tr>
                    <tr>
                        <td><label for='textParentesco'>Parentesco</label></td>
                        <td><input type='text' name='textParentesco' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${familiar.parentesco}"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </table>
        </form>
    </body>
</html>