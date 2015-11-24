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
                    <td>Edital</td>
                    <td>
                        <select name="selectEdital">
                            <option></option>
                        </select>
                    </td>
                </tr>	
                <tr>
                    <td><input type='checkbox' name='checkResidenciaRepublica'></td>
                    <td><label for='checkResidenciaRepublica'>Declaração de Residência em República</label></td>
                </tr>
                <tr>
                    <td><input type='checkbox' name='checkNaoAtividade'></td>
                    <td><label for='checkNaoAtividade'>Declaração de Não Atividade</label></td>
                </tr>
                <tr>
                    <td><input type='checkbox' name='checkAtividadeInformal'></td>
                    <td><label for='checkAtividadeInformal'>Declaração de Atividade Econômica Informal</label></td>
                </tr>
                <tr>
                    <td><input type='checkbox' name='checkInexistenciaContaBancaria'></td>
                    <td><label for='checkInexistenciaContaBancaria'>Declaração de Inexistência Conta Bancária</label></td>
                </tr>
                <tr>
                    <td><input type='checkbox' name='checkInexistenciaContaBancariaJuridica'></td>
                    <td><label for='checkInexistenciaContaBancariaJuridica'>Declaração de Inexistência Conta Bancária Jurídica</label></td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </form>
        </table>
    </body>
</html>