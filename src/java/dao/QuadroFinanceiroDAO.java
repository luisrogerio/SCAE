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
import model.QuadroFinanceiro;

/**
 *
 * @author Raissa
 */
public class QuadroFinanceiroDAO {

    public static void gravar(QuadroFinanceiro quadroFinanceiro) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO quadro_financeiro (id, formulario_socioeconomico, pessoa, escolaridade, situacaoDeTrabalho, ocupacao, rendaMensal) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, quadroFinanceiro.getId());
            comando.setInt(2, quadroFinanceiro.getCodigoFormularioSocioeconomico());
            comando.setString(3, quadroFinanceiro.getCodigoPessoa());
            comando.setString(4, quadroFinanceiro.getEscolaridade());
            comando.setString(5, quadroFinanceiro.getSituacaoDeTrabalho());
            comando.setString(6, quadroFinanceiro.getOcupacao());
            comando.setFloat(7, quadroFinanceiro.getRendaMensal());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void alterar(QuadroFinanceiro quadroFinanceiro) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE quadro_financeiro SET formulario_socioeconomico = ?, pessoa = ?, "
                    + "escolaridade = ?, situacaoDeTrabalho = ?, "
                    + "ocupacao = ?, rendaMensal = ? WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(7, quadroFinanceiro.getId());
            if(quadroFinanceiro.getFormularioSocioeconomico() == null) {
                comando.setNull(1, Types.NULL);
            } else {
                comando.setInt(1, quadroFinanceiro.getCodigoFormularioSocioeconomico());
            }
            if(quadroFinanceiro.getPessoa() == null) {
                comando.setNull(2, Types.NULL);
            } else {
                comando.setString(2, quadroFinanceiro.getCodigoPessoa());
            }
            comando.setString(3, quadroFinanceiro.getEscolaridade());
            comando.setString(4, quadroFinanceiro.getSituacaoDeTrabalho());
            comando.setString(5, quadroFinanceiro.getOcupacao());
            comando.setFloat(6, quadroFinanceiro.getRendaMensal());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<QuadroFinanceiro> obterQuadrosFinanceiros() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<QuadroFinanceiro> quadrosFinanceiros = new ArrayList<QuadroFinanceiro>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM quadro_financeiro");
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
                quadroFinanceiro.setCodigoPessoa(rs.getString("pessoa"));
                quadrosFinanceiros.add(quadroFinanceiro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return quadrosFinanceiros;
    }

    public static QuadroFinanceiro obterQuadroFinanceiro(int id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        QuadroFinanceiro quadroFinanceiro = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM quadro_financeiro WHERE id = " + id);
            rs.first();
            quadroFinanceiro = new QuadroFinanceiro(
                    rs.getInt("id"),
                    rs.getString("escolaridade"),
                    rs.getString("situacaoDeTrabalho"),
                    rs.getString("ocupacao"),
                    rs.getFloat("rendaMensal"),
                    null,
                    null
            );
            quadroFinanceiro.setCodigoFormularioSocioeconomico(rs.getInt("formularioSocioeconomico"));
            quadroFinanceiro.setCodigoPessoa(rs.getString("pessoa"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return quadroFinanceiro;
    }
    
    public static void excluir(QuadroFinanceiro quadroFina) throws SQLException, ClassNotFoundException{
           Connection conexao = null;
           Statement comando = null;
           String stringSQL;
           
           try {
               conexao = BD.getConexao();
               comando = conexao.createStatement();
               stringSQL = "delete from quadrosfinanceiros where id = "+quadroFina.getId();
               comando.execute(stringSQL);
               
           }catch (SQLException e){
               throw e;
           }finally{
               fecharConexao(conexao, comando);
           }
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
