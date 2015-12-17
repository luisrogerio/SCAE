<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Quadro Financeiro</h2>
        <form action="ManterQuadroFinanceiroController?acao=confirmar${operacao}" method='POST'>
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' value="${quadroFinanceiro.id}" 
                               <c:if test="${operacao == 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Candidato ou Familiar</td>
                        <td>
                            <select name="selectPessoa" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0"<c:if test="${quadroFinanceiro.pessoa == null}"> selected</c:if>></option>
                            <c:forEach items="pessoas" var="pessoa">
                                <option value="${pessoa.id}"
                                        <c:if test="${quadroFinanceiro.pessoa.id == pessoa.id}"> selected</c:if>
                                        >${pessoa.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>	
                <tr>
                    <td>Formulário Socioeconômico</td>
                    <td>
                        <select name="selectFormularioSocioeconomico" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0"<c:if test="${quadroFinanceiro.formularioSocioeconomico.id == null}"> selected</c:if>></option>
                            <c:forEach items="formulariosSocioeconomicos" var="formularioSocioeconomico">
                                <option value="${formularioSocioeconomico.id}"
                                        <c:if test="${quadroFinanceiro.formularioSocioeconomico.id == formularioSocioeconomico.id}"> selected</c:if>
                                        >${formularioSocioeconomico.id}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='textEscolaridade'>Escolaridade</label></td>
                    <td><input type='text' name='textEscolaridade' value="${quadroFinanceiro.escolaridade}"
                               <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label for='selectSituacaoDeTrabalho'>Situação de trabalho</label></td>
                        <td>
                            <select name="selectSituacaoDeTrabalho" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                   <option value='1' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==1}'>selected </c:if>>>1 - Não trabalho</option>
                                   <option value='2' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==2}'>selected </c:if>>>2 - Desempregado</option>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for='textOcupacao'>Ocupação</label></td>
                        <td><input type='text' name='textOcupacao' value="${quadroFinanceiro.ocupacao}"
                               <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td> 
                    </tr>
                    <tr>
                        <td><label for='textRendaMensal'>Renda mensal bruta</label></td>
                        <td><input type='text' name='textRendaMensal' value="${quadroFinanceiro.rendaMensal}"
                               <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type='submit' name='Enviar'></td>
                </tr>
            </table>
        </form>
    </body>
</html>