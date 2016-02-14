<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Declarações</h2>
        <form action="ManterDeclaracaoController?acao=confirmar${operacao}" method='POST'>
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' value="${declaracao.id}" 
                               <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Candidato ou Familiar</td>
                        <td>
                            <select name="selectPessoa" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${declaracao.pessoa == null}">selected</c:if>></option>
                            <c:forEach items="${pessoas}" var="pessoa">

                                <option value="${pessoa.id}"
                                        <c:if test="${declaracao.pessoa.id == pessoa.id}">selected</c:if>> ${pessoa.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>	
                <tr>
                    <td>Edital</td>
                    <td>
                        <select name="selectEdital" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${declaracao.edital == null}">selected</c:if>></option>
                            <c:forEach items="${editais}" var="edital">
                                <option value="${edital.id}"
                                        <c:if test="${declaracao.edital.id == edital.id}">selected</c:if>>${edital.ano}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>	
                <tr>
                    <td><input type='checkbox' name='checkResidenciaRepublica' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> 
                               <c:if test="${declaracao.residenciaRepublica}"> checked</c:if>></td>
                        <td><label for='checkResidenciaRepublica'>Declaração de Residência em República</label></td>
                    </tr>
                    <tr>
                        <td><input type='checkbox' name='checkNaoAtividade' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> 
                               <c:if test="${declaracao.naoAtividade}"> checked</c:if>></td>
                        <td><label for='checkNaoAtividade'>Declaração de Não Atividade</label></td>
                    </tr>
                    <tr>
                        <td><input type='checkbox' name='checkAtividadeInformal' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> 
                               <c:if test="${declaracao.atividadeInformal}"> checked</c:if>></td>
                        <td><label for='checkAtividadeInformal'>Declaração de Atividade Econômica Informal</label></td>
                    </tr>
                    <tr>
                        <td><input type='checkbox' name='checkInexistenciaContaBancaria' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> 
                               <c:if test="${declaracao.inexistenciaContaBancaria}"> checked</c:if>></td>
                        <td><label for='checkInexistenciaContaBancaria'>Declaração de Inexistência Conta Bancária</label></td>
                    </tr>
                    <tr>
                        <td><input type='checkbox' name='checkInexistenciaContaBancariaJuridica' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> 
                               <c:if test="${declaracao.inexistenciaContaBancariaJuridica}"> checked</c:if>></td>
                    <td><label for='checkInexistenciaContaBancariaJuridica'>Declaração de Inexistência Conta Bancária Jurídica</label></td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </table>
        </form>

        <script lang="JavaScript">
            function campoNumerico(valor) {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.lenght && ehNumero == true; i++) {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == -1) {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                if(!campoNumerico(form.textId.value)){
                    mensagem = mensagem + "O Código não deve ser nulo ou não-numérico!";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </script>
    </body>
</html>