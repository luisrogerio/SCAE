<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Modalidades</h2>
        <form action="ManterModalidadeController?acao=confirmar${operacao}" method='POST' onsubmit="return validarFormulario(this);">
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' <c:if test="${operacao != 'Incluir'}"> readonly</c:if> value="${modalidade.id}"></td>
                    </tr>
                    <tr>
                        <td><label for='textNome'>Nome</label></td>
                        <td><input type='text' name='textNome' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${modalidade.nome}"></td>
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
