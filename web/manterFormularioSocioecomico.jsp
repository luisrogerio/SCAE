<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
    <head>
        <title>Sistema de Apoio a Assistência Estudantil</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <h2>Formulário Socioeconômico</h2>
        <table border="1">
            <form type='POST'>
                <tr>
                    <td><label for='textId'>Código</label></td>
                    <td><input type='text' name='textId'></td>
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
                    <th colspan="2">Identificação do Estudante</th>
                </tr>
                <tr>
                    <td>Candidato</td>
                    <td>
                        <select name="selectCandidato">
                            <option></option>
                        </select>
                    </td>
                </tr>	
                <tr>
                    <td><label for='textNumeroResidentes'>Número total de pessoas da família (que residem na mesma casa e vivem da mesma renda familiar, incluindo o estudante): </label></td>
                    <td><input type='text' name='textNumeroResidentes'></td>
                </tr>
                <tr>
                    <th colspan="2">Endereço do Estudante ou dos pais</th>
                </tr>
                <tr>
                    <td><label for='textEndereco'>Código do Endereço</label></td>
                    <td><input type='text' name='textEndereco'></td>
                </tr>
                <tr>
                    <td><label for='textRua'>Rua</label></td>
                    <td><input type='text' name='textRua'></td>
                </tr>
                <tr>
                    <td><label for='textLogradouro'>Logradouro</label></td>
                    <td><input type='text' name='textLogradouro'></td>
                </tr>
                <tr>
                    <td><label for='textBairro'>Bairro</label></td>
                    <td><input type='text' name='textBairro'></td>
                </tr>
                <tr>
                    <td><label for='textCidade'>Cidade</label></td>
                    <td><input type='text' name='textCidade'></td>
                </tr>
                <tr>
                    <td><label for='textUF'>UF</label></td>
                    <td><input type='text' name='textUF'></td>
                </tr>
                <tr>
                    <th colspan="2">Endereço do Estudante - Caso Morador de República</th>
                </tr>
                <tr>
                    <td><label for='textLogradouroRepublica'>Logradouro</label></td>
                    <td><input type='text' name='textLogradouroRepublica'></td>
                </tr>
                <tr>
                    <td><label for='textRuaRepublica'>Rua</label></td>
                    <td><input type='text' name='textRuaRepublica'></td>
                </tr>
                <tr>
                    <td><label for='textBairroRepublica'>Bairro</label></td>
                    <td><input type='text' name='textBairroRepublica'></td>
                </tr>
                <tr>
                    <td><label for='textCidadeRepublica'>Cidade</label></td>
                    <td><input type='text' name='textCidadeRepublica'></td>
                </tr>
                <tr>
                    <td><label for='textUFRepublica'>UF republica</label></td>
                    <td><input type='text' name='textUFRepublica'></td>
                </tr>
                <tr>
                    <th colspan="2">Relativo ao Curso Corrente do Estudante</th>
                </tr>
                <tr>
                    <td><label for='textSerieModuloPeriodo'>Série/módulo/período</label></td>
                    <td><input type='text' name='textSerieModuloPeriodo'></td>
                </tr>
                <tr>
                    <th colspan="2">Questões do Formulário</th>
                </tr>
                <tr>
                    <td rowspan="4">1. Você ou alguém da sua família já foi atendido em algum programa de Assistência Estudantil do IF Sudeste MG ou do antigo CTU?</td>
                    <td><input type='radio' name='textAtendimentoAssistencia'><label for='textAtendimentoAssistencia'>Não</label>
                        <input type='radio' name='textAtendimentoAssistencia'><label for='textAtendimentoAssistencia'>Sim</label>
                    </td>
                </tr>
                <tr>
                    <td><label for='textAtendido'>Se sim, quem? <input type='text' name='textAtendido'></label></td>
                </tr>
                <tr>
                    <td><label for='textProgramaAtendimento'>Qual programa?<input type='text' name='textProgramaAtendimento'></label> </td>
                </tr>
                <tr>
                    <td><label for='textAnoAtendimento'>Em que ano?<input type='text' name='textAno_atendimento'></label></td>
                </tr>
                <tr>
                    <td rowspan="2">2. Qual(is) o(s) programa(s) solicitado(s)?</td>
                    <td>
                        <select checkbox multiple name="selectModalidade">
                            <option value="1">Alimentação</option>
                            <option value="2">Manutenção</option>
                            <option value="3">Moradia</option>
                            <option value="4">Transporte</option>
                            <option value="5">Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for='selectModalidade'>Outro - especificar: <input type='text' name='selectModalidade'></label></td>
                </tr>
                <tr>
                    <td rowspan="3">3. Qual o principal meio de transporte utilizado para chegar ao IF SUDESTE MG?</td>
                    <td>
                        <select name="selectMeioTransporte">
                            <option value="bicicleta">A pé/ de Bicicleta</option>
                            <option value="carona">De carona</option>
                            <option value="onibusInterno">Transporte Coletivo Gasto com recursos próprios</option>
                            <option value="onibusExterno">Transporte locado</option>
                            <option value="onibusPrefeitura">Oferecido gratuitamente por Prefeituras e/ou Escola</option>
                            <option value="carro">Transporte próprio</option>
                            <option value="outro">Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Gasto Mensal, caso transporte locado ou coletivo: <input type="text" name="textGastoMensal"></td>
                </tr>
                <tr>
                    <td>Caso outro meio de transporte, especificar: <input type='text' name='textOutroMeio'></td>
                </tr>
                <tr>
                    <td rowspan="3">4. Você está inserido em alguma atividade acadêmica remunerada? </td>
                    <td>
                        <select name="selectTipoAtividadeAcademica">
                            <option value="nao">Não</option>
                            <option value="estagio">Estágio</option>
                            <option value="iniciacao">Projeto de Iniciação Científica</option>
                            <option value="treinamento">Projeto de Treinamento Profissional</option>
                            <option value="outra">Outra</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se sim, qual? <input type='text' name='textNomeAtividadeAcademica'></td>
                </tr>
                <tr>
                    <td>R$ <input type='text' name='textGanhoAtividadeAcademica'></td>
                </tr>
                <tr>
                    <td rowspan="3">5. Você trabalha atualmente em algum outra atividade remunerada? </td>
                    <td>
                        <select name="selectAtividadeRemunerada">
                            <option value="nao">Não</option>
                            <option value="sim">Sim</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se sim, Qual a carga horária semanal? <input type='text' name='textCargaHorariaRemunerada'></td>
                </tr>
                <tr>
                    <td>Qual o salário mensal? R$<input type='text' name='textSalarioRemunerada'></td>
                </tr>
                <tr>
                    <td rowspan="2">6. Qual a sua condição de manuntenção? </td>
                    <td>
                        <select name="selectCondicaoManutencao">
                            <option value="proprio">Sou responsável pelo meu próprio sustento</option>
                            <option value="pais">Sou sustentado por(s) um(s) responsável(s)</option>
                            <option value="parentes">Recebo ajuda de parentes</option>
                            <option value="bolsa">Tenho bolsa de estudo</option>
                            <option value="outro">Outra</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outra, especificar: <input type='text' name='textOutraCondicaoManutencao'></td>
                </tr>
                <tr>
                    <td rowspan="2">7. Você mora?</td>
                    <td>
                        <select name="selectCondicaoManutencao">
                            <option value="sozinho">Sozinho</option>
                            <option value="pais">Com os pais</option>
                            <option value="conjuge">Com cônjuge/companheiro(a)</option>
                            <option value="parentes">Em casa de familiares ou amigos da família</option>
                            <option value="republica">Em república / quarto / pensão / pensionato</option>
                            <option value="outro">Outra</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outra, especificar: <input type='text' name='textOutraCondicaoMoradia'></td>
                </tr>
                <tr>
                    <td rowspan="2">8.Quem é(são) o(os) responsável(is) pela manutenção financeira da família do grupo familiar: </td>
                    <td>
                        <select name="selectResponsavelManutencao">
                            <option value="pais">Pai / mãe</option>
                            <option value="responsavel">Somente um dos pais</option>
                            <option value="parentes">Outros membros do grupo familiar</option>
                            <option value="proprio">Próprio Estudante</option>
                            <option value="outro">Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outro, especificar: <input type='text' name='textOutroResponsavelManutencao'></td>
                </tr>
                <tr>
                    <td>9. O bairro e a casa onde mora a família tem: </td>
                    <td>
                        <input type='checkbox' name='checkEsgoto'>
                        <label for='checkEsgoto'>Esgoto</label><br>

                        <input type='checkbox' name='checkAguaTratada'>
                        <label for='checkAguaTratada'>Água tratada</label><br>

                        <input type='checkbox' name='checkIluminacao'>
                        <label for='checkIluminacao'>Iluminação</label><br>

                        <input type='checkbox' name='checkColetaLixo'>
                        <label for='checkColetaLixo'>Coleta lixo</label><br>

                        <input type='checkbox' name='checkPavimentacao'>
                        <label for='checkPavimentacao'>Pavimentação</label>
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">10. Sua família reside em: </td>
                    <td>
                        <select name="selectLocalResidenciaFamiliar">
                            <option value="vila">Vila ou aglomerado</option>
                            <option value="bairroPopular">Bairro Padrão Popular</option>
                            <option value="bairroMedio">Bairro Padrão Médio</option>
                            <option value="bairroLuxo">Bairro Padrão Alto e Luxo</option>
                            <option value="periferia">Fora do Perímetro Urbano</option>
                            <option value="outro">Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se outro, especificar: <input type='text' name='textOutroLocalResidenciaFamiliar'></td>
                </tr>
                <tr>
                    <td rowspan="4">11. Sua família reside em imóvel: </td>
                    <td>
                        <select name="selectTipoResidenciaFamiliar">
                            <option value="alugado">Alugado</option>
                            <option value="proprioQuitado">Próprio - Já quitado</option>
                            <option value="proprioHeranca">Próprio - Por herança</option>
                            <option value="proprioPagamento">Próprio - Em pagamento</option>
                            <option value="emprestado">Emprestado ou cedido</option>
                            <option value="cedidoParente">Construído em lote de parente</option>
                            <option value="outro">Outro</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se alugado ou próprio em pagamento, valor da prestação ou aluguel: <input type='text' name='textPrecoResidenciaFamiliar'></td>
                </tr>
                <tr>
                    <td>Se emprestado ou cedido, por quem (nome e parentesco): <input type='text' name='textCedenteResidenciaFamiliar'></td>
                </tr>
                <tr>
                    <td>Se outro, especificar: <input type='text' name='textOutroTipoResidenciaFamiliar'></td>
                </tr>
                <tr>
                    <td>12. Marque a característica que melhor descreve a sua casa: </td>
                    <td>
                        <select name="selectAcabamentoResidenciaFamiliar">
                            <option value="alugado">Residência com Acabamento</option>
                            <option value="proprioQuitado">Residência sem acabamento (sem telhado ou reboco, ou pintura, ou piso)</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td rowspan="2">13. A família possui outros imóveis além do que habita? (lotes, sítios, fazendas, casa na praia, apartamentos, salas, barracões ou outros)</td>
                    <td>
                        <select name="selectImoveisExtras">
                            <option value="nao">Não</option>
                            <option value="sim">Sim</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Se sim, especificar: <textarea name='textImoveisExtras'></textarea></td>
                </tr>
                <tr>
                    <td>14. Em relação à casa de sua família especifique a quantidade de: </td>
                    <td>
                        Automóvel <input type='text' name='textQuantidadeAutomoveis' size="2">. Ano: <input type='text' name='textAno' size="4">. Modelo: <input type='text' name='textModelo' size="6"> <br>
                        Televisão em Cores <input type='text' name='textQuantidadeTelevisoes' size="2"> <br>
                        Máquina de Lavar Roupa <input type='text' name='textQuantidadeMaquinasDeLavar' size="2"> <br>
                        Geladeira <input type='text' name='textQuantidadeGeladeiras' size="2"> <br>
                        TV a Cabo <input type='text' name='textQuantidadeTVACabo' size="2"> <br>
                        Computador <input type='text' name='textQuantidadeComputadores' size="2"> <br>
                        Internet paga <input type='text' name='textQuantidadeInternet' size="2"> <br>
                        Empregada Mensalista <input type='text' name='textQuantidadeEmpregadasMensalistas' size="2"> <br>
                        Empregada Diarista <input type='text' name='textQuantidadeEmpregadasDiaristas' size="2"> <br>
                        Banheiro <input type='text' name='textQuantidadeBanheiros' size="2"> <br>
                        Quartos <input type='text' name='textQuantidadeQuartos' size="2">
                    </td>
                </tr>
                <tr>
                    <td>15. Especifique os valores das Fontes de Rendas a seguir: </td>
                    <td>
                        Aluguel de Imóveis: <input type='text' name='textAluguelImoveis'> <br>
                        Pensão por Morte: <input type='text' name='textPensaoMorte'> <br>
                        Pensão Alimentícia: <input type='text' name='textPensaoAlimenticia'> <br>
                        Ajuda de Terceiros: <input type='text' name='textAjudaTerceiros'> <br>
                        Benefícios Sociais (Bolsa Família, BPC das LOAS): <input type='text' name='textBeneficiosSociais'> <br>
                        Outro: <input type='text' name='textOutraRenda'>
                    </td>
                </tr>
                <tr>
                    <td>16. Despesa familiar mensal (Excluir despesas do estudante do IF Sudeste MG que reside fora)</td>
                    <td>
                        Água: R$ <input type='text' name='textDespesaFamiliarAgua' size="2">.<br>
                        Luz: R$ <input type='text' name='textDespesaFamiliarLuz' size="2"> <br>
                        Telefone: R$ <input type='text' name='textDespesaFamiliarTelefone' size="2"> <br>
                        Condomínio: R$ <input type='text' name='textDespesaFamiliarCondominio' size="2"> <br>
                        Mensalidade Escolar: R$ <input type='text' name='textDespesaFamiliarMensalidadeEscolar' size="2"> <br>
                        Alimentação: R$ <input type='text' name='textDespesaFamiliarAlimentacao' size="2"> <br>
                        Saúde: R$ <input type='text' name='textDespesaFamiliarSaude' size="2"> <br>
                        Transporte: R$ <input type='text' name='textDespesaFamiliarTransporte' size="2"> <br>
                        IPTU Anual: R$ <input type='text' name='textDespesaFamiliarIPTU' size="2"> <br>
                        Aluguel/Prestação da Casa: R$ <input type='text' name='textDespesaFamiliarAluguel' size="2"> <br>
                        Pensão Alimentícia: R$ <input type='text' name='textDespesaFamiliarPensaoAlimenticia' size="2"> <br>
                        Outros: R$ <input type='text' name='textDespesaFamiliarOutros' size="2"> <br>
                    </td>
                </tr>
                <tr>
                    <td>17. Despesa do estudante do IF Sudeste MG com moradia (registrar apenas a parcela que cabe ao estudante no caso de república ou similar)</td>
                    <td>
                        Água: R$ <input type='text' name='textDespesaRepublicaAgua' size="2">.<br>
                        Luz: R$ <input type='text' name='textDespesaRepublicaLuz' size="2"> <br>
                        Telefone: R$ <input type='text' name='textDespesaRepublicaTelefone' size="2"> <br>
                        Condomínio: R$ <input type='text' name='textDespesaRepublicaCondominio' size="2"> <br>
                        Aluguel/Prestação da Casa: R$ <input type='text' name='textDespesaRepublicaAluguel' size="2"> <br>
                        IPTU Anual: R$ <input type='text' name='textDespesaRepublicaIPTU' size="2"> <br>
                    </td>
                </tr>
                <tr>
                    <td>18. Informe ou esclareça sobre dados não contemplados nesse formulário ou situações especiais que julgue conveniente: </td>
                    <td>
                        <textarea rows="30" cols="75" name="textDadosExtras"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type='submit' name='Enviar'></td>
                </tr>
            </form>
        </table>
    </body>
</html>