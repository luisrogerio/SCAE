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
        <form action="ManterCursoController?acao=confirmar${operacao}" method='POST' onsubmit="return validarFormulario(this);">
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId' value="${curso.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td><label for='textNome'>Nome</label></td>
                        <td><input type='text' name='textNome' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${curso.nome}"></td>
                    </tr>
                    <tr>
                        <td><label for='selectTurno'>Turno</label></td>
                        <td>
                            <select name="selectTurno" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="integral" <c:if test="${curso.turno == 'integral'}">selected</c:if> >Integral</option>
                            <option value="diurno" <c:if test="${curso.turno == 'diurno'}">selected</c:if> >Diurno</option>
                            <option value="vespertino" <c:if test="${curso.turno == 'vespertino'}">selected</c:if> >Vespertino</option>
                            <option value="noturno" <c:if test="${curso.turno == 'noturno'}">selected</c:if>>Noturno</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for='selectTipo'>Tipo</label></td>
                        <td>
                            <select name="selectTipo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="integrado" <c:if test="${curso.tipo == 'integrado'}">selected</c:if> >Integrado</option>
                            <option value="superior" <c:if test="${curso.tipo == 'superior'}">selected</c:if> >Superior</option>
                            <option value="posGraduacao" <c:if test="${curso.tipo == 'posGraduacao'}">selected</c:if> >Pós-Graduação</option>
                            <option value="concomitante" <c:if test="${curso.tipo == 'comcomitante'}">selected</c:if> >Concomitante Externo</option>
                            <option value="subsequente" <c:if test="${curso.tipo == 'subsequente'}">selected</c:if> >Subsequente</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </table>
        </form>
        <script lang="JavaScript">
            function campoNumerico(valor){
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for(i=0;i< valor.lenght && ehNumero == true; i++){
                    umCaracter = valor.charAt(i);
                    if(caracteresValidos.indexOf(umCaracter) == -1){
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }
            
            function validarFormulario(form) {
                if(!campoNumerico(form.textId.value)){
                    mensagem = mensagem + "O Código não deve ser nulo ou não-numérico!";
                }
                if(form.textNome.value == ""){
                    mensagem = mensagem + "O Nome não deve ficar vazio!";
                }
                if (mensagem == ""){
                    return true;
                } else{
                    alert(mensagem);
                    return false;
                }
            }
        </script>
    </body>
</html>