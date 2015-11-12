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
        <table>
            <form type='POST'>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId'></td>
                </tr>
                <tr>
                    <td><label for='textAno'>Ano</label></td>
                    <td><input type='text' name='textAno'></td>
                </tr>
                <tr>
                    <td><label for='selectSemestre'>Semestre</label></td>
                    <td>
                        <select name='selectSemestre'>
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='textAno'>Descrição</label></td>
                    <td><textarea name='textAno'></textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </form>
        </table>
    </body>
</html>