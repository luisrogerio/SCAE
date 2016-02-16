<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Editais</h2>
        <form action="ManterEditalController?acao=confirmar${operacao}" method='POST' onsubmit="return validarFormulario(this);">
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' <c:if test="${operacao != 'Incluir'}"> readonly</c:if>
                               value="${edital.id}"></td>
                </tr>
                <tr>
                    <td><label for='textAno'>Ano</label></td>
                    <td><input type='text' name='textAno' placeholder="aaaa-mm-dd" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${edital.ano}"></td>
                    </tr>
                    <tr>
                        <td><label for='selectSemestre'>Semestre</label></td>
                        <td>
                            <select name='selectSemestre' <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="1" <c:if test="${edital.semestre==1}">selected</c:if>>1</option>
                            <option <c:if test="${edital.semestre==2}">selected</c:if> value="2">2</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for='textDescricao'>Descrição</label></td>
                        <td><textarea name='textDescricao' <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>${edital.descricao}</textarea></td>
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
                if (form.textAno.value == "") {
                    mensagem = mensagem + "O ano não deve ficar vazio!";
                }
                if (form.textDescricao.value == "") {
                    mensagem = mensagem + "A descrição não deve ficar vazio!";
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