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
                    <td><input type='text' name='textId' <c:if test="${operacao != 'Incluir'}"> readonly</c:if> value="${familiar.codigo}" ></td>
                    </tr>
                    <tr>
                        <td>Formulário Socioecômico</td>
                        <td>
                            <select name="selectFormularioSocioeconomico" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${familiar.formularioSocioeconomico.id == 0}">selected</c:if>></option>
                            <c:forEach items="${formulariosSocioeconomicos}" var="formularioSocioeconomico">
                                <option value="${formularioSocioeconomico.id}" <c:if test="${familiar.formularioSocioeconomico.id == formularioSocioeconomico.id}">selected</c:if>>
                                    ${formularioSocioeconomico.id}
                                </option>
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
                        <td><input type='text'  name='textDataNascimento' placeholder="aaaa-mm-dd" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${familiar.dataNascimento}" ></td>
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
                if (form.textNome.value == "") {
                    mensagem = mensagem + "O Nome não deve ficar vazio!";
                }
                if (form.textCPF.value == "") {
                    mensagem = mensagem + "O CPF não deve ficar vazio!";
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