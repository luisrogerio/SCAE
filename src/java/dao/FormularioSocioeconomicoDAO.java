/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.FormularioSocioeconomico;

/**
 *
 * @author Raissa
 */
public class FormularioSocioeconomicoDAO {

    public static void gravar(FormularioSocioeconomico formularioSocioeconomico, Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            Endereco.gravar(endereco);
        } catch (SQLException e) {
            throw e;
        }
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO formulario_socioeconomico (id, candidato, edital, enredeco, serieModuloPeriodo, atendimentoAssistencia, atendido, programaAtendimento, anoAtendimento, meioTransporte, outroMeio, gastoMensal, tipoAtividadeAcademica, nomeAtividadeAcademica, ganhoAtividadeAcademica, atividadeRemunerada, cargaHorariaRemunerada, salarioRemunerada, condicaoManutencao, outraCondicaoManutencao, condicaoMoradia, outraCondicaoMoradia, responsavelManutencao, outroResponsavelManutencao, esgoto, aguaTratada, iluminacao, coletaLixo, pavimentacao, localResidenciaFamiliar, outroLocalResidenciaFamiliar, tipoResidenciaFamiliar, outroTipoResidenciaFamiliar, precoResidenciaFamiliar, cedente, acabamentoResidenciaFamiliar, imoveisExtras, quantidadeAutomoveis, anos, modelos, quantidadeTelevisoes, quantidadeMaquinasDeLavar, quantidadeGeladeiras, quantidadeTvsACabo, quantidadeComputadores, internet, quantidadeEmpregadasMensalistas, quantidadeEmpregadasDiaristas, quantidadeBanheiros, quantidadeQuartos, aluguelImoveis, pensaoMorte, pensaoAlimenticia, ajudaTerceiros, beneficiosSociais, outraRenda, numeroResidentes, despesaFamiliarAgua, despesaFamiliarLuz, despesaFamiliarTelefone, despesaFamiliarCondominio, despesaFamiliarMensalidadeEscolar, despesaFamiliarAlimentacao, despesaFamiliarSaude, despesaFamiliarTransporte, despesaFamiliarIPTU, despesaFamiliarAluguel, despesaFamiliarPensaoAlimenticia, despesaFamiliarOutros, despesaRepublicaAgua, despesaRepublicaLuz, despesaRepublicaTelefone, despesaRepublicaCondominio, despesaRepublicaAluguel, despesaRepublicaIPTU, dadosExtras, data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, formularioSocioeconomico.getId());
            comando.setString(2, formularioSocioeconomico.getCodigoCandidato());
            comando.setInt(3, formularioSocioeconomico.getCodigoEdital());
            comando.setInt(4, formularioSocioeconomico.getCodigoEndereco());
            comando.setString(5, formularioSocioeconomico.getSerieModuloPeriodo());
            comando.setBoolean(6, formularioSocioeconomico.isAtendimentoAssistencia());
            comando.setString(7, formularioSocioeconomico.getAtendido());
            comando.setString(8, formularioSocioeconomico.getProgramaAtendimento());
            comando.setString(9, formularioSocioeconomico.getAnoAtendimento());
            comando.setString(10, formularioSocioeconomico.getMeioTransporte());
            comando.setString(11, formularioSocioeconomico.getOutroMeio());
            comando.setFloat(12, formularioSocioeconomico.getGastoMensal());
            comando.setString(13, formularioSocioeconomico.getTipoAtividadeAcademica());
            comando.setString(14, formularioSocioeconomico.getNomeAtividadeAcademica());
            comando.setFloat(15, formularioSocioeconomico.getGanhoAtividadeAcademica());
            comando.setBoolean(16, formularioSocioeconomico.isAtividadeRemunerada());
            comando.setInt(17, formularioSocioeconomico.getCargaHorariaRemunerada());
            comando.setFloat(18, formularioSocioeconomico.getSalarioRemunerada());
            comando.setString(19, formularioSocioeconomico.getCondicaoManutencao());
            comando.setString(20, formularioSocioeconomico.getOutraCondicaoManutencao());
            comando.setString(21, formularioSocioeconomico.getCondicaoMoradia());
            comando.setString(22, formularioSocioeconomico.getOutraCondicaoMoradia());
            comando.setString(23, formularioSocioeconomico.getResponsavelManutencao());
            comando.setString(24, formularioSocioeconomico.getOutroResponsavelManutencao());
            comando.setBoolean(25, formularioSocioeconomico.isEsgoto());
            comando.setBoolean(26, formularioSocioeconomico.isAguaTratada());
            comando.setBoolean(27, formularioSocioeconomico.isIluminacao());
            comando.setBoolean(28, formularioSocioeconomico.isColetaLixo());
            comando.setBoolean(29, formularioSocioeconomico.isPavimentacao());
            comando.setString(30, formularioSocioeconomico.getLocalResidenciaFamiliar());
            comando.setString(31, formularioSocioeconomico.getOutroLocalResidenciaFamiliar());
            comando.setString(32, formularioSocioeconomico.getTipoResidenciaFamiliar());
            comando.setString(33, formularioSocioeconomico.getOutroTipoResidenciaFamiliar());
            comando.setFloat(34, formularioSocioeconomico.getPrecoResidenciaFamiliar());
            comando.setString(35, formularioSocioeconomico.getCedente());
            comando.setBoolean(36, formularioSocioeconomico.isAcabamentoResidenciaFamiliar());
            comando.setString(37, formularioSocioeconomico.getImoveisExtras());
            comando.setInt(38, formularioSocioeconomico.getQuantidadeAutomoveis());
            comando.setString(39, formularioSocioeconomico.getAnos());
            comando.setString(40, formularioSocioeconomico.getModelos());
            comando.setInt(41, formularioSocioeconomico.getQuantidadeTelevisoes());
            comando.setInt(42, formularioSocioeconomico.getQuantidadeMaquinasDeLavar());
            comando.setInt(43, formularioSocioeconomico.getQuantidadeGeladeiras());
            comando.setInt(44, formularioSocioeconomico.getQuantidadeTvsACabo());
            comando.setInt(45, formularioSocioeconomico.getQuantidadeComputadores());
            comando.setBoolean(46, formularioSocioeconomico.isInternet());
            comando.setInt(47, formularioSocioeconomico.getQuantidadeEmpregadasMensalistas());
            comando.setInt(48, formularioSocioeconomico.getQuantidadeEmpregadasDiaristas());
            comando.setInt(49, formularioSocioeconomico.getQuantidadeBanheiros());
            comando.setInt(50, formularioSocioeconomico.getQuantidadeQuartos());
            comando.setFloat(51, formularioSocioeconomico.getAluguelImoveis());
            comando.setFloat(52, formularioSocioeconomico.getPensaoMorte());
            comando.setFloat(53, formularioSocioeconomico.getPensaoAlimenticia());
            comando.setFloat(54, formularioSocioeconomico.getAjudaTerceiros());
            comando.setFloat(55, formularioSocioeconomico.getBeneficiosSociais());
            comando.setFloat(56, formularioSocioeconomico.getOutraRenda());
            comando.setInt(57, formularioSocioeconomico.getNumeroResidentes());
            comando.setFloat(58, formularioSocioeconomico.getDespesaFamiliarAgua());
            comando.setFloat(59, formularioSocioeconomico.getDespesaFamiliarLuz());
            comando.setFloat(60, formularioSocioeconomico.getDespesaFamiliarTelefone());
            comando.setFloat(61, formularioSocioeconomico.getDespesaFamiliarCondominio());
            comando.setFloat(62, formularioSocioeconomico.getDespesaFamiliarMensalidadeEscolar());
            comando.setFloat(63, formularioSocioeconomico.getDespesaFamiliarAlimentacao());
            comando.setFloat(64, formularioSocioeconomico.getDespesaFamiliarSaude());
            comando.setFloat(65, formularioSocioeconomico.getDespesaFamiliarTransporte());
            comando.setFloat(66, formularioSocioeconomico.getDespesaFamiliarIPTU());
            comando.setFloat(67, formularioSocioeconomico.getDespesaFamiliarAluguel());
            comando.setFloat(68, formularioSocioeconomico.getDespesaFamiliarPensaoAlimenticia());
            comando.setFloat(69, formularioSocioeconomico.getDespesaFamiliarOutros());
            comando.setFloat(70, formularioSocioeconomico.getDespesaRepublicaAgua());
            comando.setFloat(71, formularioSocioeconomico.getDespesaRepublicaLuz());
            comando.setFloat(72, formularioSocioeconomico.getDespesaRepublicaTelefone());
            comando.setFloat(73, formularioSocioeconomico.getDespesaRepublicaCondominio());
            comando.setFloat(74, formularioSocioeconomico.getDespesaRepublicaAluguel());
            comando.setFloat(75, formularioSocioeconomico.getDespesaRepublicaIPTU());
            comando.setString(76, formularioSocioeconomico.getDadosExtras());
            comando.setString(77, formularioSocioeconomico.getData());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(FormularioSocioeconomico formularioSocioeconomico, Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            Endereco.alterar(endereco);
        } catch (SQLException e) {
            throw e;
        }
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE formulario_socioeconomico SET candidato = ?, edital = ?, enredeco = ?, "
                    + "serieModuloPeriodo = ?, atendimentoAssistencia = ?, atendido = ?, "
                    + "programaAtendimento = ?, anoAtendimento = ?, meioTransporte = ?, "
                    + "outroMeio = ?, gastoMensal = ?, tipoAtividadeAcademica = ?, "
                    + "nomeAtividadeAcademica = ?, ganhoAtividadeAcademica = ?, atividadeRemunerada = ?, "
                    + "cargaHorariaRemunerada = ?, salarioRemunerada = ?, condicaoManutencao = ?, "
                    + "outraCondicaoManutencao = ?, condicaoMoradia = ?, outraCondicaoMoradia = ?, "
                    + "responsavelManutencao = ?, outroResponsavelManutencao = ?, esgoto = ?, aguaTratada = ?, "
                    + "iluminacao = ?, coletaLixo = ?, pavimentacao = ?, localResidenciaFamiliar = ?, "
                    + "outroLocalResidenciaFamiliar = ?, tipoResidenciaFamiliar = ?, outroTipoResidenciaFamiliar = ?, "
                    + "precoResidenciaFamiliar = ?, cedente = ?, acabamentoResidenciaFamiliar = ?, imoveisExtras = ?, "
                    + "quantidadeAutomoveis = ?, anos = ?, modelos = ?, quantidadeTelevisoes = ?, quantidadeMaquinasDeLavar = ?, "
                    + "quantidadeGeladeiras = ?, quantidadeTvsACabo = ?, quantidadeComputadores = ?, "
                    + "internet = ?, quantidadeEmpregadasMensalistas = ?, quantidadeEmpregadasDiaristas = ?, "
                    + "quantidadeBanheiros = ?, quantidadeQuartos = ?, aluguelImoveis = ?, pensaoMorte = ?, "
                    + "pensaoAlimenticia = ?, ajudaTerceiros = ?, beneficiosSociais = ?, outraRenda = ?, "
                    + "numeroResidentes = ?, despesaFamiliarAgua = ?, despesaFamiliarLuz = ?, "
                    + "despesaFamiliarTelefone = ?, despesaFamiliarCondominio = ?, "
                    + "despesaFamiliarMensalidadeEscolar = ?, despesaFamiliarAlimentacao = ?, "
                    + "despesaFamiliarSaude = ?, despesaFamiliarTransporte = ?, despesaFamiliarIPTU = ?, "
                    + "despesaFamiliarAluguel = ?, despesaFamiliarPensaoAlimenticia = ?, "
                    + "despesaFamiliarOutros = ?, despesaRepublicaAgua = ?, despesaRepublicaLuz = ?, "
                    + "despesaRepublicaTelefone = ?, despesaRepublicaCondominio = ?, despesaRepublicaAluguel = ?, "
                    + "despesaRepublicaIPTU = ?, dadosExtras = ?, data = ? WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(77, formularioSocioeconomico.getId());
            if(formularioSocioeconomico.getCandidato() == null) {
                comando.setNull(1, Types.NULL);
            } else {
                comando.setString(1, formularioSocioeconomico.getCodigoCandidato());
            }
            if(formularioSocioeconomico.getEdital()== null) {
                comando.setNull(2, Types.NULL);
            } else {
                comando.setInt(2, formularioSocioeconomico.getCodigoEdital());
            }
            comando.setInt(3, formularioSocioeconomico.getId());
            comando.setString(4, formularioSocioeconomico.getSerieModuloPeriodo());
            comando.setBoolean(5, formularioSocioeconomico.isAtendimentoAssistencia());
            comando.setString(6, formularioSocioeconomico.getAtendido());
            comando.setString(7, formularioSocioeconomico.getProgramaAtendimento());
            comando.setString(8, formularioSocioeconomico.getAnoAtendimento());
            comando.setString(9, formularioSocioeconomico.getMeioTransporte());
            comando.setString(10, formularioSocioeconomico.getOutroMeio());
            comando.setFloat(11, formularioSocioeconomico.getGastoMensal());
            comando.setString(12, formularioSocioeconomico.getTipoAtividadeAcademica());
            comando.setString(13, formularioSocioeconomico.getNomeAtividadeAcademica());
            comando.setFloat(14, formularioSocioeconomico.getGanhoAtividadeAcademica());
            comando.setBoolean(15, formularioSocioeconomico.isAtividadeRemunerada());
            comando.setInt(16, formularioSocioeconomico.getCargaHorariaRemunerada());
            comando.setFloat(17, formularioSocioeconomico.getSalarioRemunerada());
            comando.setString(18, formularioSocioeconomico.getCondicaoManutencao());
            comando.setString(19, formularioSocioeconomico.getOutraCondicaoManutencao());
            comando.setString(20, formularioSocioeconomico.getCondicaoMoradia());
            comando.setString(21, formularioSocioeconomico.getOutraCondicaoMoradia());
            comando.setString(22, formularioSocioeconomico.getResponsavelManutencao());
            comando.setString(23, formularioSocioeconomico.getOutroResponsavelManutencao());
            comando.setBoolean(24, formularioSocioeconomico.isEsgoto());
            comando.setBoolean(25, formularioSocioeconomico.isAguaTratada());
            comando.setBoolean(26, formularioSocioeconomico.isIluminacao());
            comando.setBoolean(27, formularioSocioeconomico.isColetaLixo());
            comando.setBoolean(28, formularioSocioeconomico.isPavimentacao());
            comando.setString(29, formularioSocioeconomico.getLocalResidenciaFamiliar());
            comando.setString(30, formularioSocioeconomico.getOutroLocalResidenciaFamiliar());
            comando.setString(31, formularioSocioeconomico.getTipoResidenciaFamiliar());
            comando.setString(32, formularioSocioeconomico.getOutroTipoResidenciaFamiliar());
            comando.setFloat(33, formularioSocioeconomico.getPrecoResidenciaFamiliar());
            comando.setString(34, formularioSocioeconomico.getCedente());
            comando.setBoolean(35, formularioSocioeconomico.isAcabamentoResidenciaFamiliar());
            comando.setString(36, formularioSocioeconomico.getImoveisExtras());
            comando.setInt(37, formularioSocioeconomico.getQuantidadeAutomoveis());
            comando.setString(38, formularioSocioeconomico.getAnos());
            comando.setString(39, formularioSocioeconomico.getModelos());
            comando.setInt(40, formularioSocioeconomico.getQuantidadeTelevisoes());
            comando.setInt(41, formularioSocioeconomico.getQuantidadeMaquinasDeLavar());
            comando.setInt(42, formularioSocioeconomico.getQuantidadeGeladeiras());
            comando.setInt(43, formularioSocioeconomico.getQuantidadeTvsACabo());
            comando.setInt(44, formularioSocioeconomico.getQuantidadeComputadores());
            comando.setBoolean(45, formularioSocioeconomico.isInternet());
            comando.setInt(46, formularioSocioeconomico.getQuantidadeEmpregadasMensalistas());
            comando.setInt(47, formularioSocioeconomico.getQuantidadeEmpregadasDiaristas());
            comando.setInt(48, formularioSocioeconomico.getQuantidadeBanheiros());
            comando.setInt(49, formularioSocioeconomico.getQuantidadeQuartos());
            comando.setFloat(50, formularioSocioeconomico.getAluguelImoveis());
            comando.setFloat(51, formularioSocioeconomico.getPensaoMorte());
            comando.setFloat(52, formularioSocioeconomico.getPensaoAlimenticia());
            comando.setFloat(53, formularioSocioeconomico.getAjudaTerceiros());
            comando.setFloat(54, formularioSocioeconomico.getBeneficiosSociais());
            comando.setFloat(55, formularioSocioeconomico.getOutraRenda());
            comando.setInt(56, formularioSocioeconomico.getNumeroResidentes());
            comando.setFloat(57, formularioSocioeconomico.getDespesaFamiliarAgua());
            comando.setFloat(58, formularioSocioeconomico.getDespesaFamiliarLuz());
            comando.setFloat(59, formularioSocioeconomico.getDespesaFamiliarTelefone());
            comando.setFloat(60, formularioSocioeconomico.getDespesaFamiliarCondominio());
            comando.setFloat(61, formularioSocioeconomico.getDespesaFamiliarMensalidadeEscolar());
            comando.setFloat(62, formularioSocioeconomico.getDespesaFamiliarAlimentacao());
            comando.setFloat(63, formularioSocioeconomico.getDespesaFamiliarSaude());
            comando.setFloat(64, formularioSocioeconomico.getDespesaFamiliarTransporte());
            comando.setFloat(65, formularioSocioeconomico.getDespesaFamiliarIPTU());
            comando.setFloat(66, formularioSocioeconomico.getDespesaFamiliarAluguel());
            comando.setFloat(67, formularioSocioeconomico.getDespesaFamiliarPensaoAlimenticia());
            comando.setFloat(68, formularioSocioeconomico.getDespesaFamiliarOutros());
            comando.setFloat(69, formularioSocioeconomico.getDespesaRepublicaAgua());
            comando.setFloat(70, formularioSocioeconomico.getDespesaRepublicaLuz());
            comando.setFloat(71, formularioSocioeconomico.getDespesaRepublicaTelefone());
            comando.setFloat(72, formularioSocioeconomico.getDespesaRepublicaCondominio());
            comando.setFloat(73, formularioSocioeconomico.getDespesaRepublicaAluguel());
            comando.setFloat(74, formularioSocioeconomico.getDespesaRepublicaIPTU());
            comando.setString(75, formularioSocioeconomico.getDadosExtras());
            comando.setString(76, formularioSocioeconomico.getData());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<FormularioSocioeconomico> obterFormulariosSocioeconomicos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<FormularioSocioeconomico> formulariosSocioeconmicos = new ArrayList<FormularioSocioeconomico>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM formulario_socioeconomico");
            while (rs.next()) {
                FormularioSocioeconomico formularioSocioeconomico = new FormularioSocioeconomico(
                        rs.getInt("id"),
                        rs.getString("serieModuloPeriodo"),
                        rs.getBoolean("atendimentoAssistencia"),
                        rs.getString("atendido"),
                        rs.getString("programaAtendimento"),
                        rs.getString("anoAtendimento"),
                        rs.getString("meioTransporte"),
                        rs.getString("outroMeio"),
                        rs.getFloat("gastoMensal"),
                        rs.getString("tipoAtividadeAcademica"),
                        rs.getString("nomeAtividadeAcademica"),
                        rs.getFloat("ganhoAtividadeAcademica"),
                        rs.getBoolean("atividadeRemunerada"),
                        rs.getInt("cargaHorariaRemunerada"),
                        rs.getFloat("salarioRemunerada"),
                        rs.getString("condicaoManutencao"),
                        rs.getString("outraCondicaoManutencao"),
                        rs.getString("condicaoMoradia"),
                        rs.getString("outraCondicaoMoradia"),
                        rs.getString("responsavelManutencao"),
                        rs.getString("outroResponsavelManutencao"),
                        rs.getBoolean("esgoto"),
                        rs.getBoolean("aguaTratada"),
                        rs.getBoolean("iluminacao"),
                        rs.getBoolean("coletaLixo"),
                        rs.getBoolean("pavimentacao"),
                        rs.getString("localResidenciaFamiliar"),
                        rs.getString("outroLocalResidenciaFamiliar"),
                        rs.getString("tipoResidenciaFamiliar"),
                        rs.getString("outroTipoResidenciaFamiliar"),
                        rs.getFloat("precoResidenciaFamiliar"),
                        rs.getString("cedente"),
                        rs.getBoolean("acabamentoResidenciaFamiliar"),
                        rs.getString("imoveisExtras"),
                        rs.getInt("quantidadeAutomoveis"),
                        rs.getString("anos"),
                        rs.getString("modelos"),
                        rs.getInt("quantidadeTelevisoes"),
                        rs.getInt("quantidadeMaquinasDeLavar"),
                        rs.getInt("quantidadeGeladeiras"),
                        rs.getInt("quantidadeTvsACabo"),
                        rs.getInt("quantidadeComputadores"),
                        rs.getBoolean("internet"),
                        rs.getInt("quantidadeEmpregadasMensalistas"),
                        rs.getInt("quantidadeEmpregadasDiaristas"),
                        rs.getInt("quantidadeBanheiros"),
                        rs.getInt("quantidadeQuartos"),
                        rs.getFloat("aluguelImoveis"),
                        rs.getFloat("pensaoMorte"),
                        rs.getFloat("pensaoAlimenticia"),
                        rs.getFloat("ajudaTerceiros"),
                        rs.getFloat("beneficiosSociais"),
                        rs.getFloat("outraRenda"),
                        rs.getInt("numeroResidentes"),
                        rs.getFloat("despesaFamiliarAgua"),
                        rs.getFloat("despesaFamiliarLuz"),
                        rs.getFloat("despesaFamiliarTelefone"),
                        rs.getFloat("despesaFamiliarCondominio"),
                        rs.getFloat("despesaFamiliarMensalidadeEscolar"),
                        rs.getFloat("despesaFamiliarAlimentacao"),
                        rs.getFloat("despesaFamiliarSaude"),
                        rs.getFloat("despesaFamiliarTransporte"),
                        rs.getFloat("despesaFamiliarIPTU"),
                        rs.getFloat("despesaFamiliarAluguel"),
                        rs.getFloat("despesaFamiliarPensaoAlimenticia"),
                        rs.getFloat("despesaFamiliarOutros"),
                        rs.getFloat("despesaRepublicaAgua"),
                        rs.getFloat("despesaRepublicaLuz"),
                        rs.getFloat("despesaRepublicaTelefone"),
                        rs.getFloat("despesaRepublicaCondominio"),
                        rs.getFloat("despesaRepublicaAluguel"),
                        rs.getFloat("despesaRepublicaIPTU"),
                        rs.getString("dadosExtras"),
                        rs.getString("data"),
                        null,
                        null,
                        null
                );
                formularioSocioeconomico.setCodigoCandidato(rs.getString("candidato"));
                formularioSocioeconomico.setCodigoEndereco(rs.getInt("endereco"));
                formularioSocioeconomico.setCodigoEdital(rs.getInt("edital"));
                formulariosSocioeconmicos.add(formularioSocioeconomico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return formulariosSocioeconmicos;
    }

    public static FormularioSocioeconomico obterFormularioSocioeconomico(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        FormularioSocioeconomico formularioSocioeconomico = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM formulario_socioeconomico WHERE id = " + id);
            while (rs.next()) {
                formularioSocioeconomico = new FormularioSocioeconomico(
                        rs.getInt("id"),
                        rs.getString("serieModuloPeriodo"),
                        rs.getBoolean("atendimentoAssistencia"),
                        rs.getString("atendido"),
                        rs.getString("programaAtendimento"),
                        rs.getString("anoAtendimento"),
                        rs.getString("meioTransporte"),
                        rs.getString("outroMeio"),
                        rs.getFloat("gastoMensal"),
                        rs.getString("tipoAtividadeAcademica"),
                        rs.getString("nomeAtividadeAcademica"),
                        rs.getFloat("ganhoAtividadeAcademica"),
                        rs.getBoolean("atividadeRemunerada"),
                        rs.getInt("cargaHorariaRemunerada"),
                        rs.getFloat("salarioRemunerada"),
                        rs.getString("condicaoManutencao"),
                        rs.getString("outraCondicaoManutencao"),
                        rs.getString("condicaoMoradia"),
                        rs.getString("outraCondicaoMoradia"),
                        rs.getString("responsavelManutencao"),
                        rs.getString("outroResponsavelManutencao"),
                        rs.getBoolean("esgoto"),
                        rs.getBoolean("aguaTratada"),
                        rs.getBoolean("iluminacao"),
                        rs.getBoolean("coletaLixo"),
                        rs.getBoolean("pavimentacao"),
                        rs.getString("localResidenciaFamiliar"),
                        rs.getString("outroLocalResidenciaFamiliar"),
                        rs.getString("tipoResidenciaFamiliar"),
                        rs.getString("outroTipoResidenciaFamiliar"),
                        rs.getFloat("precoResidenciaFamiliar"),
                        rs.getString("cedente"),
                        rs.getBoolean("acabamentoResidenciaFamiliar"),
                        rs.getString("imoveisExtras"),
                        rs.getInt("quantidadeAutomoveis"),
                        rs.getString("anos"),
                        rs.getString("modelos"),
                        rs.getInt("quantidadeTelevisoes"),
                        rs.getInt("quantidadeMaquinasDeLavar"),
                        rs.getInt("quantidadeGeladeiras"),
                        rs.getInt("quantidadeTvsACabo"),
                        rs.getInt("quantidadeComputadores"),
                        rs.getBoolean("internet"),
                        rs.getInt("quantidadeEmpregadasMensalistas"),
                        rs.getInt("quantidadeEmpregadasDiaristas"),
                        rs.getInt("quantidadeBanheiros"),
                        rs.getInt("quantidadeQuartos"),
                        rs.getFloat("aluguelImoveis"),
                        rs.getFloat("pensaoMorte"),
                        rs.getFloat("pensaoAlimenticia"),
                        rs.getFloat("ajudaTerceiros"),
                        rs.getFloat("beneficiosSociais"),
                        rs.getFloat("outraRenda"),
                        rs.getInt("numeroResidentes"),
                        rs.getFloat("despesaFamiliarAgua"),
                        rs.getFloat("despesaFamiliarLuz"),
                        rs.getFloat("despesaFamiliarTelefone"),
                        rs.getFloat("despesaFamiliarCondominio"),
                        rs.getFloat("despesaFamiliarMensalidadeEscolar"),
                        rs.getFloat("despesaFamiliarAlimentacao"),
                        rs.getFloat("despesaFamiliarSaude"),
                        rs.getFloat("despesaFamiliarTransporte"),
                        rs.getFloat("despesaFamiliarIPTU"),
                        rs.getFloat("despesaFamiliarAluguel"),
                        rs.getFloat("despesaFamiliarPensaoAlimenticia"),
                        rs.getFloat("despesaFamiliarOutros"),
                        rs.getFloat("despesaRepublicaAgua"),
                        rs.getFloat("despesaRepublicaLuz"),
                        rs.getFloat("despesaRepublicaTelefone"),
                        rs.getFloat("despesaRepublicaCondominio"),
                        rs.getFloat("despesaRepublicaAluguel"),
                        rs.getFloat("despesaRepublicaIPTU"),
                        rs.getString("dadosExtras"),
                        rs.getString("data"),
                        null,
                        null,
                        null
                );
                formularioSocioeconomico.setCodigoCandidato(rs.getString("candidato"));
                formularioSocioeconomico.setCodigoEndereco(rs.getInt("endereco"));
                formularioSocioeconomico.setCodigoEdital(rs.getInt("edital"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return formularioSocioeconomico;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
        }
    }
}
