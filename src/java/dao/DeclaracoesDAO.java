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
import java.util.ArrayList;
import java.util.List;
import model.Declaracoes;

/**
 *
 * @author Raissa
 */
public class DeclaracoesDAO {

    public static void gravar(Declaracoes declaracao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO declaracoes (id, edital, pessoa, residenciaRepublica, naoAtividade, atividadeInformal, inexistenciaContaBancaria, inexistenciaContaBancariaJuridica) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, declaracao.getId());
            comando.setInt(2, declaracao.getCodigoEdital());
            comando.setString(3, declaracao.getCodigoPessoa());
            comando.setBoolean(4, declaracao.isResidenciaRepublica());
            comando.setBoolean(5, declaracao.isNaoAtividade());
            comando.setBoolean(6, declaracao.isAtividadeInformal());
            comando.setBoolean(7, declaracao.isInexistenciaContaBancaria());
            comando.setBoolean(8, declaracao.isInexistenciaContaBancariaJuridica());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Declaracoes> obterDeclaracoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Declaracoes> declaracoes = new ArrayList<Declaracoes>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM declaracoes");
            while (rs.next()) {
                Declaracoes declaracao = new Declaracoes(
                        rs.getInt("id"),
                        rs.getBoolean("residenciaRepublica"),
                        rs.getBoolean("naoAtividade"),
                        rs.getBoolean("atividadeInformal"),
                        rs.getBoolean("inexistenciaContaBancaria"),
                        rs.getBoolean("inexistenciaContaBancariaJuridica"),
                        null,
                        null
                );
                declaracao.setCodigoEdital(rs.getInt("edital"));
                declaracao.setCodigoPessoa(rs.getString("pessoa"));
                declaracoes.add(declaracao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracoes;
    }

    public static Declaracoes obterDeclaracao(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Declaracoes declaracao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM declaracoes WHERE id = " + id);
            rs.first();
            declaracao = new Declaracoes(
                    rs.getInt("id"),
                    rs.getBoolean("residenciaRepublica"),
                    rs.getBoolean("naoAtividade"),
                    rs.getBoolean("atividadeInformal"),
                    rs.getBoolean("inexistenciaContaBancaria"),
                    rs.getBoolean("inexistenciaContaBancariaJuridica"),
                    null,
                    null
            );
            declaracao.setCodigoEdital(rs.getInt("edital"));
            declaracao.setCodigoPessoa(rs.getString("pessoa"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracao;
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
