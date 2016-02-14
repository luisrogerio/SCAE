<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Formulário Socioeconômico</h2>
        <form action="ManterFormularioSocioeconomicoController?acao=confirmar${operacao}" method='POST' onsubmit="return validarFormulario(this);">
            <table border="1">
                <tr>
                    <td><label for="textId">Código</label></td>
                    <td><input type="text" name="textId" <c:if test="${operacao != 'Incluir'}"> readonly</c:if> value="${formularioSocioeconomico.id}"></td>
                    </tr>
                    <tr>
                        <td>Edital</td>
                        <td>
                            <select name="selectEdital" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${formularioSocioeconomico.edital == null}"> selected</c:if>> </option>
                            <c:forEach items="${editais}" var="edital">
                                <option value="${edital.id}" <c:if test="${formularioSocioeconomico.edital.id == edital.id}">selected</c:if>>${edital.descricao}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>		
                <tr>
                    <th colspan="2">Identificação do Estudante</th>
                </tr>
                <tr>
                    <td>Candidato</td>
                    <td>
                        <select name="selectCandidato" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${formularioSocioeconomico.candidato == null}"> selected</c:if>> </option>
                            <c:forEach items="${candidatos}" var="candidato">
                                <option value="${candidato.matricula}" <c:if test="${formularioSocioeconomico.candidato.matricula == candidato.matricula}">selected</c:if>>${candidato.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>	
                <tr>
                    <td><label for='textNumeroResidentes'>Número total de pessoas da família (que residem na mesma casa e vivem da mesma renda familiar, incluindo o estudante): </label></td>
                    <td><input type='text' name='textNumeroResidentes' value="${formularioSocioeconomico.numeroResidentes}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <th colspan="2">Endereço do Estudante ou dos pais</th>
                </tr>
                <tr>
                    <td><label for='textRua'>Rua</label></td>
                    <td><input type='text' name='textRua' value="${formularioSocioeconomico.endereco.rua}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textLogradouro'>Logradouro</label></td>
                    <td><input type='text' name='textLogradouro' value="${formularioSocioeconomico.endereco.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textBairro'>Bairro</label></td>
                    <td><input type='text' name='textBairro' value="${formularioSocioeconomico.endereco.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textCidade'>Cidade</label></td>
                    <td><input type='text' name='textCidade' value="${formularioSocioeconomico.endereco.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textUF'>UF</label></td>
                    <td><input type='text' name='textUF' value="${formularioSocioeconomico.endereco.UF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <th colspan="2">Endereço do Estudante - Caso Morador de República</th>
                </tr>
                <tr>
                    <td><label for='textLogradouroRepublica'>Logradouro</label></td>
                    <td><input type='text' name='textLogradouroRepublica' value="${formularioSocioeconomico.endereco.logradouroRepublica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textRuaRepublica'>Rua</label></td>
                    <td><input type='text' name='textRuaRepublica' value="${formularioSocioeconomico.endereco.ruaRepublica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textBairroRepublica'>Bairro</label></td>
                    <td><input type='text' name='textBairroRepublica' value="${formularioSocioeconomico.endereco.bairroRepublica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textCidadeRepublica'>Cidade</label></td>
                    <td><input type='text' name='textCidadeRepublica' value="${formularioSocioeconomico.endereco.cidadeRepublica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><label for='textUFRepublica'>UF republica</label></td>
                    <td><input type='text' name='textUFRepublica' value="${formularioSocioeconomico.endereco.UFRepublica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <th colspan="2">Relativo ao Curso Corrente do Estudante</th>
                </tr>
                <tr>
                    <td><label for='textSerieModuloPeriodo'>Série/módulo/período</label></td>
                    <td><input type='text' name='textSerieModuloPeriodo'  value="${formularioSocioeconomico.serieModuloPeriodo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <th colspan="2">Questões do Formulário</th>
                </tr>
                <tr>
                    <td rowspan="4">1. Você ou alguém da sua família já foi atendido em algum programa de Assistência Estudantil do IF Sudeste MG ou do antigo CTU?</td>
                    <td><input type='radio' name='textAtendimentoAssistencia' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> <c:if test="${!formularioSocioeconomico.atendimentoAssistencia}">checked</c:if>><label for='textAtendimentoAssistencia'>Não</label>
                        <input type='radio' name='textAtendimentoAssistencia' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> <c:if test="${formularioSocioeconomico.atendimentoAssistencia}">checked</c:if>><label for='textAtendimentoAssistencia'>Sim</label>
                    </td>
                </tr>
                <tr>
                    <td><label for='textAtendido'>Se sim, quem? <input type='text' name='textAtendido' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.atendido}"></label></td>
                </tr>
                <tr>
                    <td><label for='textProgramaAtendimento'>Qual programa?<input type='text' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> name='textProgramaAtendimento' value="${formularioSocioeconomico.programaAtendimento}"></label> </td>
                </tr>
                <tr>
                    <td><label for='textAnoAtendimento'>Em que ano?<input type='text' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> name='textAno_atendimento' value="${formularioSocioeconomico.anoAtendimento}"></label></td>
                </tr>
                <tr>
                    <td rowspan="2">2. Qual(is) o(s) programa(s) solicitado(s)?</td>
                    <td>
                        <select checkbox multiple name="selectModalidade" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>> 
                            <c:forEach items="${modalidades}" var="modalidade">
                                <option value="${modalidade.id}" <c:if test="${fn:contains(formularioSocioeconomico.codigosModalidades, modalidade.id)}">selected</c:if>>${modalidade.nome}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='selectModalidade'>Outro - especificar: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='selectModalidade'></label></td>
                </tr>
                <tr>
                    <td rowspan="3">3. Qual o principal meio de transporte utilizado para chegar ao IF SUDESTE MG?</td>
                    <td>
                        <select name="selectMeioTransporte" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="bicicleta" <c:if test="${formularioSocioeconomico.meioTransporte == 'bicicleta'} ">selected</c:if>>A pé/ de Bicicleta</option>
                            <option value="carona" <c:if test="${formularioSocioeconomico.meioTransporte == 'carona'} ">selected</c:if>>De carona</option>
                            <option value="onibusInterno" <c:if test="${formularioSocioeconomico.meioTransporte == 'onibusInterno'} ">selected</c:if>>Transporte Coletivo Gasto com recursos próprios</option>
                            <option value="onibusExterno" <c:if test="${formularioSocioeconomico.meioTransporte == 'onibusExterno'} ">selected</c:if>>Transporte locado</option>
                            <option value="onibusPrefeitura" <c:if test="${formularioSocioeconomico.meioTransporte == 'onibusPrefeitura'} ">selected</c:if>>Oferecido gratuitamente por Prefeituras e/ou Escola</option>
                            <option value="carro" <c:if test="${formularioSocioeconomico.meioTransporte == 'carro'} ">selected</c:if>>Transporte próprio</option>
                            <option value="outro" <c:if test="${formularioSocioeconomico.meioTransporte == 'outro'} ">selected</c:if>>Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Gasto Mensal, caso transporte locado ou coletivo: <input type="text" <c:if test="${operacao == 'Excluir'}"> readonly</c:if> name="textGastoMensal"  value="${formularioSocioeconomico.gastoMensal}"></td>
                </tr>
                <tr>
                    <td>Caso outro meio de transporte, especificar: <input type='text' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> name='textOutroMeio' value="${formularioSocioeconomico.outroMeio}"></td>
                </tr>
                <tr>
                    <td rowspan="3">4. Você está inserido em alguma atividade acadêmica remunerada? </td>
                    <td>
                        <select name="selectTipoAtividadeAcademica" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="nao" <c:if test="${formularioSocioeconomico.tipoAtividadeAcademica == 'nao'} ">selected</c:if>>Não</option>
                            <option value="estagio" <c:if test="${formularioSocioeconomico.tipoAtividadeAcademica == 'estagio'} ">selected</c:if>>Estágio</option>
                            <option value="iniciacao" <c:if test="${formularioSocioeconomico.tipoAtividadeAcademica == 'iniciacao'} ">selected</c:if>>Projeto de Iniciação Científica</option>
                            <option value="treinamento" <c:if test="${formularioSocioeconomico.tipoAtividadeAcademica == 'treinamento'} ">selected</c:if>>Projeto de Treinamento Profissional</option>
                            <option value="outra" <c:if test="${formularioSocioeconomico.tipoAtividadeAcademica == 'outra'} ">selected</c:if>>Outra</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se sim, qual? <input type='text' name='textNomeAtividadeAcademica' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.outroMeio}"></td>
                </tr>
                <tr>
                    <td>R$ <input type='text' name='textGanhoAtividadeAcademica' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.ganhoAtividadeAcademica}"></td>
                </tr>
                <tr>
                    <td rowspan="3">5. Você trabalha atualmente em algum outra atividade remunerada? </td>
                    <td>
                        <select name="selectAtividadeRemunerada" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="nao" <c:if test="${formularioSocioeconomico.atividadeRemunerada == 'nao'} ">selected</c:if>>Não</option>
                            <option value="sim" <c:if test="${formularioSocioeconomico.atividadeRemunerada == 'sim'} ">selected</c:if>>Sim</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se sim, Qual a carga horária semanal? <input type='text' name='textCargaHorariaRemunerada' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.cargaHorariaRemunerada}"></td>
                </tr>
                <tr>
                    <td>Qual o salário mensal? R$<input type='text' name='textSalarioRemunerada' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.salarioRemunerada}"></td>
                </tr>
                <tr>
                    <td rowspan="2">6. Qual a sua condição de manuntenção? </td>
                    <td>
                        <select name="selectCondicaoManutencao" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="proprio" <c:if test="${formularioSocioeconomico.condicaoManutencao == 'proprio'}">selected</c:if>>Sou responsável pelo meu próprio sustento</option>
                            <option value="pais" <c:if test="${formularioSocioeconomico.condicaoManutencao == 'pais'}">selected</c:if>>Sou sustentado por(s) um(s) responsável(s)</option>
                            <option value="parentes" <c:if test="${formularioSocioeconomico.condicaoManutencao == 'parentes'}">selected</c:if>>Recebo ajuda de parentes</option>
                            <option value="bolsa" <c:if test="${formularioSocioeconomico.condicaoManutencao == 'bolsa'}">selected</c:if>>Tenho bolsa de estudo</option>
                            <option value="outro" <c:if test="${formularioSocioeconomico.condicaoManutencao == 'outra'}">selected</c:if>>Outra</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outra, especificar: <input type='text' name='textOutraCondicaoManutencao' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.outraCondicaoManutencao}"></td>
                </tr>
                <tr>
                    <td rowspan="2">7. Você mora?</td>
                    <td>
                        <select name="selectCondicaoManutencao" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="sozinho" >Sozinho</option>
                            <option value="pais">Com os pais</option>
                            <option value="conjuge">Com cônjuge/companheiro(a)</option>
                            <option value="parentes">Em casa de familiares ou amigos da família</option>
                            <option value="republica">Em república / quarto / pensão / pensionato</option>
                            <option value="outro">Outra</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outra, especificar: <input type='text' name='textOutraCondicaoMoradia' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.outraCondicaoMoradia}"></td>
                </tr>
                <tr>
                    <td rowspan="2">8.Quem é(são) o(os) responsável(is) pela manutenção financeira da família do grupo familiar: </td>
                    <td>
                        <select name="selectResponsavelManutencao" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="pais" <c:if test="${formularioSocioeconomico.responsavelManutencao == 'pais'}">selected</c:if>>Pai / mãe</option>
                            <option value="responsavel" <c:if test="${formularioSocioeconomico.responsavelManutencao == 'responsavel'}">selected</c:if>>Somente um dos pais</option>
                            <option value="parentes" <c:if test="${formularioSocioeconomico.responsavelManutencao == 'parentes'}">selected</c:if>>Outros membros do grupo familiar</option>
                            <option value="proprio" <c:if test="${formularioSocioeconomico.responsavelManutencao == 'proprio'}">selected</c:if>>Próprio Estudante</option>
                            <option value="outro" <c:if test="${formularioSocioeconomico.responsavelManutencao == 'outro'}">selected</c:if>>Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outro, especificar: <input type='text' name='textOutroResponsavelManutencao' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.outroResponsavelManutencao}"></td>
                </tr>
                <tr>
                    <td>9. O bairro e a casa onde mora a família tem: </td>
                    <td>
                        <input type='checkbox' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> name='checkEsgoto' <c:if test="${formularioSocioeconomico.esgoto}">checked</c:if>>
                        <label for='checkEsgoto'>Esgoto</label><br>

                        <input type='checkbox' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> name='checkAguaTratada' <c:if test="${formularioSocioeconomico.aguaTratada}">checked</c:if>>
                        <label for='checkAguaTratada'>Água tratada</label><br>

                        <input type='checkbox' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> name='checkIluminacao' <c:if test="${formularioSocioeconomico.iluminacao}">checked</c:if>>
                        <label for='checkIluminacao'>Iluminação</label><br>

                        <input type='checkbox' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> name='checkColetaLixo' <c:if test="${formularioSocioeconomico.coletaLixo}">checked</c:if>>
                        <label for='checkColetaLixo'>Coleta lixo</label><br>

                        <input type='checkbox' <c:if test="${operacao == 'Excluir'}"> disabled</c:if> name='checkPavimentacao' <c:if test="${formularioSocioeconomico.pavimentacao}">checked</c:if>>
                        <label for='checkPavimentacao'>Pavimentação</label>
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">10. Sua família reside em: </td>
                    <td>
                        <select name="selectLocalResidenciaFamiliar" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="vila" <c:if test="${formularioSocioeconomico.localResidenciaFamiliar == 'vila'}">selected</c:if>>Vila ou aglomerado</option>
                            <option value="bairroPopular" <c:if test="${formularioSocioeconomico.localResidenciaFamiliar == 'bairroPopular'}">selected</c:if>>Bairro Padrão Popular</option>
                            <option value="bairroMedio" <c:if test="${formularioSocioeconomico.localResidenciaFamiliar == 'bairroMedio'}">selected</c:if>>Bairro Padrão Médio</option>
                            <option value="bairroLuxo" <c:if test="${formularioSocioeconomico.localResidenciaFamiliar == 'bairroLuxo'}">selected</c:if>>Bairro Padrão Alto e Luxo</option>
                            <option value="periferia">Fora do Perímetro Urbano</option>
                            <option value="outro">Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outro, especificar: <input type='text' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> name='textOutroLocalResidenciaFamiliar' value="${formularioSocioeconomico.outroLocalResidenciaFamiliar}"></td>
                </tr>
                <tr>
                    <td rowspan="4">11. Sua família reside em imóvel: </td>
                    <td>
                        <select name="selectTipoResidenciaFamiliar" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="alugado" <c:if test="${formularioSocioeconomico.tipoResidenciaFamiliar == 'alugado'}">selected</c:if>>Alugado</option>
                            <option value="proprioQuitado" <c:if test="${formularioSocioeconomico.tipoResidenciaFamiliar == 'proprioQuitado'}">selected</c:if>>Próprio - Já quitado</option>
                            <option value="proprioHeranca" <c:if test="${formularioSocioeconomico.tipoResidenciaFamiliar == 'proprioHeranca'}">selected</c:if>>Próprio - Por herança</option>
                            <option value="proprioPagamento" <c:if test="${formularioSocioeconomico.tipoResidenciaFamiliar == 'proprioPagamento'}">selected</c:if>>Próprio - Em pagamento</option>
                            <option value="emprestado" <c:if test="${formularioSocioeconomico.tipoResidenciaFamiliar == 'emprestado'}">selected</c:if>>Emprestado ou cedido</option>
                            <option value="cedidoParente" <c:if test="${formularioSocioeconomico.tipoResidenciaFamiliar == 'cedidoParente'}">selected</c:if>>Construído em lote de parente</option>
                            <option value="outro" <c:if test="${formularioSocioeconomico.tipoResidenciaFamiliar == 'outro'}">selected</c:if>>Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se alugado ou próprio em pagamento, valor da prestação ou aluguel: <input type='text' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> name='textPrecoResidenciaFamiliar' value="${formularioSocioeconomico.precoResidenciaFamiliar}"></td>
                </tr>
                <tr>
                    <td>Se emprestado ou cedido, por quem (nome e parentesco): <input type='text' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> name='textCedenteResidenciaFamiliar' value="${formularioSocioeconomico.cedente}"></td>
                </tr>
                <tr>
                    <td>Se outro, especificar: <input type='text' name='textOutroTipoResidenciaFamiliar' <c:if test="${operacao == 'Excluir'}"> readonly</c:if> value="${formularioSocioeconomico.outroTipoResidenciaFamiliar}"></td>
                </tr>
                <tr>
                    <td>12. Marque a característica que melhor descreve a sua casa: </td>
                    <td>
                        <select name="selectAcabamentoResidenciaFamiliar" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="acabamento" <c:if test="${formularioSocioeconomico.acabamentoResidenciaFamiliar == 'acabamento'}">selected</c:if>>Residência com Acabamento</option>
                            <option value="semAcabamento" <c:if test="${formularioSocioeconomico.acabamentoResidenciaFamiliar == 'semAcabamento'}">selected</c:if>>Residência sem acabamento (sem telhado ou reboco, ou pintura, ou piso)</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">13. A família possui outros imóveis além do que habita? (lotes, sítios, fazendas, casa na praia, apartamentos, salas, barracões ou outros)</td>
                    <td>
                        <select name="selectImoveisExtras" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="nao" <c:if test="${formularioSocioeconomico.imoveisExtras == 'nao'}">selected</c:if>>Não</option>
                            <option value="sim" <c:if test="${formularioSocioeconomico.imoveisExtras == 'sim'}">selected</c:if>>Sim</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se sim, especificar: <textarea name='textImoveisExtras' <c:if test="${operacao == 'Excluir'}"> disabled</c:if>></textarea></td>
                </tr>
                <tr>
                    <td>14. Em relação à casa de sua família especifique a quantidade de: </td>
                    <td>
                        Automóvel <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeAutomoveis' size="2" value="${formularioSocioeconomico.quantidadeAutomoveis}">. Ano: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textAno' size="4">. Modelo: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textModelo' size="6"> <br>
                        Televisão em Cores <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeTelevisoes' size="2" value="${formularioSocioeconomico.quantidadeTelevisoes}"> <br>
                        Máquina de Lavar Roupa <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeMaquinasDeLavar' size="2" value="${formularioSocioeconomico.quantidadeMaquinasDeLavar}"> <br>
                        Geladeira <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeGeladeiras' size="2" value="${formularioSocioeconomico.quantidadeGeladeiras}"> <br>
                        TV a Cabo <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeTVACabo' size="2" value="${formularioSocioeconomico.quantidadeTvsACabo}"> <br>
                        Computador <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeComputadores' size="2" value="${formularioSocioeconomico.quantidadeComputadores}"> <br>
                        Internet paga <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeInternet' size="2" value="${formularioSocioeconomico.internet}"> <br>
                        Empregada Mensalista <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeEmpregadasMensalistas' size="2"value="${formularioSocioeconomico.quantidadeEmpregadasMensalistas}"> <br>
                        Empregada Diarista <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeEmpregadasDiaristas' size="2" value="${formularioSocioeconomico.quantidadeEmpregadasDiaristas}"> <br>
                        Banheiro <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeBanheiros' size="2" value="${formularioSocioeconomico.quantidadeBanheiros}"> <br>
                        Quartos <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textQuantidadeQuartos' size="2" value="${formularioSocioeconomico.quantidadeQuartos}">
                    </td>
                </tr>
                <tr>
                    <td>15. Especifique os valores das Fontes de Rendas a seguir: </td>
                    <td>
                        Aluguel de Imóveis: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textAluguelImoveis' value="${formularioSocioeconomico.aluguelImoveis}"> <br>
                        Pensão por Morte: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textPensaoMorte' value="${formularioSocioeconomico.pensaoMorte}"> <br>
                        Pensão Alimentícia: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textPensaoAlimenticia' value="${formularioSocioeconomico.pensaoAlimenticia}"> <br>
                        Ajuda de Terceiros: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textAjudaTerceiros' value="${formularioSocioeconomico.ajudaTerceiros}"> <br>
                        Benefícios Sociais (Bolsa Família, BPC das LOAS): <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textBeneficiosSociais' value="${formularioSocioeconomico.beneficiosSociais}"> <br>
                        Outro: <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textOutraRenda' value="${formularioSocioeconomico.outraRenda}">
                    </td>
                </tr>
                <tr>
                    <td>16. Despesa familiar mensal (Excluir despesas do estudante do IF Sudeste MG que reside fora)</td>
                    <td>
                        Água: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarAgua' size="2" value="${formularioSocioeconomico.despesaFamiliarAgua}">.<br>
                        Luz: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarLuz' size="2" value="${formularioSocioeconomico.despesaFamiliarLuz}"> <br>
                        Telefone: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarTelefone' size="2" value="${formularioSocioeconomico.despesaFamiliarTelefone}"> <br>
                        Condomínio: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarCondominio' size="2" value="${formularioSocioeconomico.despesaFamiliarCondominio}"> <br>
                        Mensalidade Escolar: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarMensalidadeEscolar' size="2" value="${formularioSocioeconomico.despesaFamiliarMensalidadeEscolar}"> <br>
                        Alimentação: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarAlimentacao' size="2" value="${formularioSocioeconomico.despesaFamiliarAlimentacao}"> <br>
                        Saúde: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarSaude' size="2" value="${formularioSocioeconomico.despesaFamiliarSaude}"> <br>
                        Transporte: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarTransporte' size="2" value="${formularioSocioeconomico.despesaFamiliarTransporte}"> <br>
                        IPTU Anual: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarIPTU' size="2" value="${formularioSocioeconomico.despesaFamiliarIPTU}"> <br>
                        Aluguel/Prestação da Casa: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarAluguel' size="2" value="${formularioSocioeconomico.despesaFamiliarAluguel}"> <br>
                        Pensão Alimentícia: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarPensaoAlimenticia' size="2" value="${formularioSocioeconomico.despesaFamiliarPensaoAlimenticia}"> <br>
                        Outros: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaFamiliarOutros' size="2" value="${formularioSocioeconomico.despesaFamiliarOutros}"> <br>
                    </td>
                </tr>
                <tr>
                    <td>17. Despesa do estudante do IF Sudeste MG com moradia (registrar apenas a parcela que cabe ao estudante no caso de república ou similar)</td>
                    <td>
                        Água: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaRepublicaAgua' size="2" value="${formularioSocioeconomico.despesaRepublicaAgua}">.<br>
                        Luz: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaRepublicaLuz' size="2" value="${formularioSocioeconomico.despesaRepublicaLuz}"> <br>
                        Telefone: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaRepublicaTelefone' size="2" value="${formularioSocioeconomico.despesaRepublicaTelefone}"> <br>
                        Condomínio: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaRepublicaCondominio' size="2" value="${formularioSocioeconomico.despesaRepublicaCondominio}"> <br>
                        Aluguel/Prestação da Casa: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaRepublicaAluguel' size="2" value="${formularioSocioeconomico.despesaRepublicaAluguel}"> <br>
                        IPTU Anual: R$ <input <c:if test="${operacao == 'Excluir'}"> readonly</c:if> type='text' name='textDespesaRepublicaIPTU' size="2" value="${formularioSocioeconomico.despesaRepublicaIPTU}"> <br>
                    </td>
                </tr>
                <tr>
                    <td>18. Informe ou esclareça sobre dados não contemplados nesse formulário ou situações especiais que julgue conveniente: </td>
                    <td>
                        <textarea rows="30" cols="75" <c:if test="${operacao == 'Excluir'}"> disabled</c:if> name="textDadosExtras">${formularioSocioeconomico.dadosExtras}</textarea>
                    </td>
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
                if (form.textId.value == "") {
                    mensagem = mensagem + "O código não deve ser nulo!";
                }
                if (form.textEndereco.value == "") {
                    mensagem = mensagem + "O código do endereço não deve ficar vazio!";
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