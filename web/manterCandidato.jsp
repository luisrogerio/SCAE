<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Manter Candidato - ${operacao}</h2>
        <form action="ManterCandidatoController?acao=confirmar${operacao}" method="POST">
            <table>
                <tr>
                    <td><label for='textMatricula'>Matrícula</label></td>
                    <td><input type='text' name='textMatricula' <c:if test="${operacao != 'Incluir'}"> readonly</c:if> value="${candidato.matricula}"></td>				
                    </tr>
                    <tr>
                        <td><label for='textNome'>Nome</label></td>
                        <td><input type='text' name='textNome' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${candidato.nome}"></td>
                    </tr>
                    <tr>
                        <td><label for='textDataNascimento'>Data de Nascimento</label></td>
                        <td><input type='text' name='textDataNascimento' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${candidato.dataNascimento}"></td>
                    </tr>
                    <tr>
                        <td><label for='textCPF'>CPF</label></td>
                        <td><input type='text' name='textCPF' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${candidato.CPF}"></td>				
                    </tr>
                    <tr>
                        <td><label for='textIdentidade'>Identidade</label></td>
                        <td><input type='text' name='textIdentidade' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${candidato.identidade}"></td>
                    </tr>
                    <tr>
                        <td><label for='selectCurso'>Curso</label></td>
                        <td>
                            <select name="selectCurso" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0"></option>
                            <c:forEach items="${cursos}" var="curso">
                                <option value="${curso.id}" <c:if test="${candidato.curso.id == curso.id}">selected</c:if>>${curso.nome}</option>
                            </c:forEach>
                        </select>
                    </td>				
                </tr>
                <tr>
                    <td><label for='textGenero'>Gênero</label></td>
                    <td>		
                        <input type='radio' name='textGenero' value="Masculino" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> <c:if test="${candidato.genero == 'Masculino'}"> checked</c:if>>Masculino
                        <input type='radio' name='textGenero' value="Feminino" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> <c:if test="${candidato.genero == 'Feminino'}"> checked</c:if>>Feminino
                        </td>				
                    </tr>
                    <tr>
                        <td><label for='textTelefoneResidencial'>Telefone Residencial</label></td>
                            <td><input type='text' name='textTelefoneResidencial' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${candidato.telefoneResidencial}"></td>				
                    </tr>
                    <tr>
                        <td><label for='textTelefoneCelular'>Telefone Celular</label></td>
                        <td><input type='text' name='textTelefoneCelular' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${candidato.telefoneCelular}"></td>				
                    </tr>
                    <tr>
                        <td><label for='textInstituicaoFundamental'>Instituição Fundamental</label></td>
                        <td>
                            <select name="textInstituicaoFundamental" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="publica" <c:if test="${candidato.instituicaoFundamental == 'publica'}">selected</c:if>>Pública</option>
                            <option value="particular" <c:if test="${candidato.instituicaoFundamental == 'particular'}">selected</c:if>>Particular</option>
                            <option value="publicaEParticular" <c:if test="${candidato.instituicaoFundamental == 'publicaEParticular'}">selected</c:if>>Parte em pública e depois em particular</option>
                            <option value="particularEPublica" <c:if test="${candidato.instituicaoFundamental == 'particularEPublica'}">selected</c:if>>Parte em particular e depois em pública</option>
                            <option value="particularBolsa" <c:if test="${candidato.instituicaoFundamental == 'particularBolsa'}">selected</c:if>>Particular com bolsa</option>
                            </select>
                        </td>				
                    </tr>
                    <tr>
                        <td><label for='textInstituicaoMedio'>Instituição Médio</label></td>
                        <td>
                            <select name="textInstituicaoMedio" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="publica" <c:if test="${candidato.instituicaoMedio == 'publica'}">selected</c:if>>Pública</option>
                            <option value="particular" <c:if test="${candidato.instituicaoMedio == 'particular'}">selected</c:if>>Particular</option>
                            <option value="publicaEParticular" <c:if test="${candidato.instituicaoMedio == 'publicaEParticular'}">selected</c:if>>Parte em pública e depois em particular</option>
                            <option value="particularEPublica" <c:if test="${candidato.instituicaoMedio == 'particularEPublica'}">selected</c:if>>Parte em particular e depois em pública</option>
                            <option value="particularBolsa" <c:if test="${candidato.instituicaoMedio == 'particularBolsa'}">selected</c:if>>Particular com bolsa</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </table>
        </form>
    </body>
</html>