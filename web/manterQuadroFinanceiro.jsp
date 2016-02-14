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
        <form action="ManterQuadroFinanceiroController?acao=confirmar${operacao}" method='POST' onsubmit="return validarFormulario(this);">
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' value="${quadroFinanceiro.id}" 
                               <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Candidato ou Familiar</td>
                        <td>
                            <select name="selectPessoa" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <option value="0" <c:if test="${quadroFinanceiro.pessoa.id == 0}">selected</c:if>></option>
                                <c:forEach items="${pessoas}" var="pessoa">
                                    <option value="${pessoa.id}"
                                            <c:if test="${quadroFinanceiro.pessoa.id == pessoa.id}">
                                                selected</c:if>>${pessoa.nome}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>	
                    <tr>
                        <td>Formulário Socioecômico</td>
                        <td>
                            <select name="selectFormularioSocioeconomico" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <option value="0" <c:if test="${quadroFinanceiro.formularioSocioeconomico.id == 0}">selected</c:if>></option>
                                <c:forEach items="${formulariosSocioeconomicos}" var="formularioSocioeconomico">
                                    
                                    <option value="${formularioSocioeconomico.id}" 
                                            <c:if test="${quadroFinanceiro.formularioSocioeconomico.id == formularioSocioeconomico.id}">
                                                selected</c:if>>${formularioSocioeconomico.id}</option>
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
                            <select name="selectSituacaoDeTrabalho" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                   <option value='1' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==1}'>selected </c:if>>1 - Não trabalho</option>
                                   <option value='2' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==2}'>selected </c:if>>2 - Desempregado</option>
                                   <option value='3' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==3}'>selected </c:if>>3 - Trabalha com carteira Assinada</option>
                                   <option value='4' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==4}'>selected </c:if>>4 - Servidor Público</option>
                                   <option value='5' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==5}'>selected </c:if>>5 - Trabalha com Atividade Rural</option>
                                   <option value='6' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==6}'>selected </c:if>>6 - Aposentado</option>
                                   <option value='7' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==7}'>selected </c:if>>7 - Pensionista</option>
                                   <option value='8' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==8}'>selected </c:if>>8 - Aposentado e Pensionista</option>
                                   <option value='9' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==9}'>selected </c:if>>9 - Recebe Auxílio-Doença ou Seguro-Acidente</option>
                                   <option value='10' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==10}'>selected </c:if>>10 - Trabalha como autônomo ou Profissional Liberal</option>
                                   <option value='11' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==11}'>selected </c:if>>11 - Microempreendedor individual</option>
                                   <option value='12' <c:if test='${quadroFinanceiro.situacaoDeTrabalho==12}'>selected </c:if>>12 - Trabalha na economia informal (faz biscates)</option>
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
                if (!campoNumerico(form.textId.value)) {
                    mensagem = mensagem + "O Código não deve ser nulo ou não-numérico!";
                }
                if (form.textEscolaridade.value == "") {
                    mensagem = mensagem + "A escolaridade não deve ficar vazia!";
                }
                if (form.textOcupacao.value == "") {
                    mensagem = mensagem + "A ocupação do familiar ou candidato não deve ficar vazia!";
                }
                if (form.textRendaMensal.value == "") {
                    mensagem = mensagem + "A renda mensal do familiar ou candidato não deve ficar vazia!";
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