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
        <form action="ManterFamiliarController?confirmar${operacao}" method='POST'>
            <table>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId'></td>
                </tr>
                <tr>
                    <td><label for='textPessoa'>Código da Pessoa</label></td>
                    <td><input type='text' name='textPessoa'></td>
                </tr>
                <tr>
                    <td>Formulário Socioecômico</td>
                    <td>
                        <select name="selectFormularioSocioeconomico">
                            <option></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='textNome'>Nome</label></td>
                    <td><input type='text' name='textNome'></td>
                </tr>
                <tr>
                    <td><label for='textDataNascimento'>Data de Nascimento</label></td>
                    <td><input type='text' name='textDataNascimento'></td>
                </tr>
                <tr>
                    <td><label for='textCPF'>CPF</label></td>
                    <td><input type='text' name='textCPF'></td>
                </tr>
                <tr>
                    <td><label for='textIdentidade'>Identidade</label></td>
                    <td><input type='text' name='textIdentidade'></td>
                </tr>
                <tr>
                    <td><label for='textNacionalidade'>Nacionalidade</label></td>
                    <td><input type='text' name='textNacionalidade'></td>
                </tr>
                <tr>
                    <td><label for='textParentesco'>Parentesco</label></td>
                    <td><input type='text' name='textParentesco'></td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </table>
        </form>
    </body>
</html>