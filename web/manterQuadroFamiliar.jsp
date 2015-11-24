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
        <form action="ManterQuadroFamiliarController?confirmar${operacao}" method='POST'>
            <table>
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
                    <td>Formulário Socioecômico</td>
                    <td>
                        <select name="selectFormularioSocioeconomico">
                            <option></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='textDoenca'>Nome da Doença</label></td>
                    <td><input type='text' name='textDoenca'></td>			
                </tr>
                <tr>
                    <td><input type='checkbox' name='checkCapacidadeTrabalho'></td>
                    <td><label for='checkCapacidadeTrabalho'>Tem Capacidade de Trabalho</label></td>			
                </tr>
                <tr>
                    <td><input type='checkbox' name='checkDependenciaAtividades'></td>
                    <td><label for='checkDependenciaAtividades'>Dependência para Atividades diárias</label></td>			
                </tr>
                <tr>
                    <td><label for='textGastosMensais'>Gastos mensais com tratamento</label></td>
                    <td><input type='text' name='textGastosMensais'></td>			
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>			
                </tr>
            </table>
        </form>
    </body>
</html>