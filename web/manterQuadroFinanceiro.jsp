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
        <table>
            <form type='POST'>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId'></td>
                </tr>
                <tr>
                    <td>Candidato ou Familiar</td>
                    <td>
                        <select name="selectPessoa">
                            <option></option>
                        </select>
                    </td>
                </tr>	
                <tr>
                    <td>Formulário Socioeconômico</td>
                    <td>
                        <select name="selectFormularioSocioeconomico">
                            <option></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='textEscolaridade'>Escolaridade</label></td>
                    <td><input type='text' name='textEscolaridade'></td>
                </tr>
                <tr>
                    <td><label for='selectSituacaoDeTrabalho'>Situação de trabalho</label></td>
                    <td>
                        <select name="selectSituacaoDeTrabalho">
                            <option></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='textOcupacao'>Ocupação</label></td>
                    <td><input type='text' name='textOcupacao'></td>
                </tr>
                <tr>
                    <td><label for='textRendaMensal'>Renda mensal bruta</label></td>
                    <td><input type='text' name='textRendaMensal'></td>
                </tr>
                <tr>
                    <td><input type='submit' name='Enviar'></td>
                </tr>
            </form>
        </table>
    </body>
</html>