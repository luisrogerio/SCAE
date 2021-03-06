<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Quadro Familiar</h2>
        <form action="ManterQuadroFamiliarController?acao=confirmar${operacao}" method='POST' onsubmit="return validarFormulario(this);">
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' value='${quadroFamiliar.id}' <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>			
                    </tr>
                    <tr>
                        <td>Candidato ou Familiar</td>
                        <td>
                            <select name="selectPessoa" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <option value="0" <c:if test="${quadroFamiliar.pessoa.id == 0}">selected</c:if>></option>
                                <c:forEach items="${pessoas}" var="pessoa">
                                    <option value="${pessoa.id}"
                                            <c:if test="${quadroFamiliar.pessoa.id == pessoa.id}">
                                                selected</c:if>>${pessoa.nome}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>	
                    <tr>
                        <td>Formulário Socioecômico</td>
                        <td>
                            <select name="selectFormularioSocioeconomico" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <option value="0" <c:if test="${quadroFamiliar.formularioSocioeconomico.id == 0}">selected</c:if>></option>
                                <c:forEach items="${formulariosSocioeconomicos}" var="formularioSocioeconomico">
                                    
                                    <option value="${formularioSocioeconomico.id}" 
                                            <c:if test="${quadroFamiliar.formularioSocioeconomico.id == formularioSocioeconomico.id}">
                                                selected</c:if>>${formularioSocioeconomico.id}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for='textDoenca'>Nome da Doença</label></td>
                        <td><input type='text' name='textDoenca' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${quadroFamiliar.doenca}"></td>			
                    </tr>
                    <tr>
                        <td><input type='checkbox' name='checkCapacidadeTrabalho' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> <c:if test="${quadroFamiliar.capacidadeTrabalho}"> checked</c:if>></td>
                        <td><label for='checkCapacidadeTrabalho'>Tem Capacidade de Trabalho</label></td>			
                    </tr>
                    <tr>
                            <td><input type='checkbox' name='checkDependenciaAtividades' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> <c:if test="${quadroFamiliar.dependenciaAtividade}"> checked</c:if>></td>
                        <td><label for='checkDependenciaAtividades'>Dependência para Atividades diárias</label></td>			
                    </tr>
                    <tr>
                        <td><label for='textGastosMensais'>Gastos mensais com tratamento</label></td>
                            <td><input type='text' name='textGastosMensais' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${quadroFamiliar.gastoMensal}"></td>			
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
                if (!campoNumerico(form.textId.value)) {
                    mensagem = mensagem + "O Código não deve ser nulo ou não-numérico!";
                }
                if (form.textDoenca.value == "") {
                    mensagem = mensagem + "A doença não deve ficar vazia!";
                }
                if (form.textGastosMensais.value == "") {
                    mensagem = mensagem + "Os gastos com o tratamento não devem ficar vazios!";
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