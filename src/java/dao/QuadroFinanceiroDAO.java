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
import model.QuadroFinanceiro;

/**
 *
 * @author Raissa
 */
public class QuadroFinanceiroDAO {

    public static List<QuadroFinanceiro> obterQuadrosFinanceiros() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<QuadroFinanceiro> quadrosFinanceiros = new ArrayList<QuadroFinanceiro>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM quadrosFinanceiros");
            while (rs.next()) {
                QuadroFinanceiro quadroFinanceiro = new QuadroFinanceiro(
                        rs.getInt("id"),
                        rs.getString("escolaridade"),
                        rs.getString("situacaoDeTrabalho"),
                        rs.getString("ocupacao"),
                        rs.getFloat("rendaMensal"),
                        null,
                        null
                );
                quadroFinanceiro.setCodigoFormularioSocioeconomico(rs.getInt("formularioSocioeconomico"));
                quadroFinanceiro.setCodigoPessoa(rs.getInt("pessoa"));
                quadrosFinanceiros.add(quadroFinanceiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return quadrosFinanceiros;
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
