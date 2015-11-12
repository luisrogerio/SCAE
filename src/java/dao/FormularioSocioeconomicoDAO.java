/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.FormularioSocioeconomico;

/**
 *
 * @author Raissa
 */
public class FormularioSocioeconomicoDAO {

    public static List<FormularioSocioeconomico> obterFormulariosSocioeconmicos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<FormularioSocioeconomico> formulariosSocioeconmicos = new ArrayList<FormularioSocioeconomico>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM formulariosSocioeconmicos");
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
                formularioSocioeconomico.setCodigoCandidato(rs.getInt("candidato"));
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
