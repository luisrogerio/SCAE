<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Candidatos</h2>
        <table>
            <form type='POST'>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId'></td>
                </tr>
                <tr>
                    <td><label for='textPessoa'>Código da Pessoa</label></td>
                    <td><input type='text' name='textPessoa'></td>
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
                    <td><label for='textMatricula'>Matrícula</label></td>
                    <td><input type='text' name='textMatricula'></td>				
                </tr>
                <tr>
                    <td><label for='selectCurso'>Curso</label></td>
                    <td>
                        <select name="selectCurso">
                            <option></option>
                        </select>
                    </td>				
                </tr>
                <tr>
                    <td><label for='textGenero'>Gênero</label></td>
                    <td>		
                        <input type='radio' name='textGenero' value="Masculino">Masculino
                        <input type='radio' name='textGenero' value="Feminino">Feminino
                    </td>				
                </tr>
                <tr>
                    <td><label for='textTelefoneResidencial'>Telefone Residencial</label></td>
                    <td><input type='text' name='textTelefoneResidencial'></td>				
                </tr>
                <tr>
                    <td><label for='textTelefoneCelular'>Telefone Celular</label></td>
                    <td><input type='text' name='textTelefoneCelular'></td>				
                </tr>
                <tr>
                    <td><label for='textInstituicaoFundamental'>Instituição Fundamental</label></td>
                    <td>
                        <select name="textInstituicaoFundamental">
                            <option value="publica">Pública</option>
                            <option value="particular">Particular</option>
                            <option value="publicaEParticular">Parte em pública e depois em particular</option>
                            <option value="particularEPublica">Parte em particular e depois em pública</option>
                            <option value="particularBolsa">Particular com bolsa</option>
                        </select>
                    </td>				
                </tr>
                <tr>
                    <td><label for='textInstituicaoMedio'>Instituição Médio</label></td>
                    <td>
                        <select name="textInstituicaoMedio">
                            <option value="publica">Pública</option>
                            <option value="particular">Particular</option>
                            <option value="publicaEParticular">Parte em pública e depois em particular</option>
                            <option value="particularEPublica">Parte em particular e depois em pública</option>
                            <option value="particularBolsa">Particular com bolsa</option>
                        </select>
                    </td>				
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </form>
        </table>
    </body>
</html>