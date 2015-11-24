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
import model.QuadroFamiliar;

/**
 *
 * @author Raissa
 */
public class QuadroFamiliarDAO {

    public static void gravar(QuadroFamiliar quadroFamiliar) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO quadro_familiar (id, formulario_socioeconomico, pessoa, doenca, capacidadeTrabalho, dependenciaAtividade, gastoMensal) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, quadroFamiliar.getId());
            comando.setInt(2, quadroFamiliar.getCodigoFormularioSocioeconomico());
            comando.setString(3, quadroFamiliar.getCodigoPessoa());
            comando.setString(4, quadroFamiliar.getDoenca());
            comando.setBoolean(5, quadroFamiliar.isCapacidadeTrabalho());
            comando.setBoolean(6, quadroFamiliar.isDependenciaAtividade());
            comando.setFloat(7, quadroFamiliar.getGastoMensal());
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<QuadroFamiliar> obterQuadrosFamiliares() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<QuadroFamiliar> quadrosFamiliares = new ArrayList<QuadroFamiliar>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM quadrosFamiliares");
            while (rs.next()) {
                QuadroFamiliar quadroFamiliar = new QuadroFamiliar(
                        rs.getInt("id"),
                        rs.getString("doenca"),
                        rs.getBoolean("capacidadeTrabalho"),
                        rs.getBoolean("dependenciaAtividade"),
                        rs.getFloat("gastoMensal"),
                        null,
                        null
                );
                quadroFamiliar.setCodigoFormularioSocioeconomico(rs.getInt("formularioSocioeconomico"));
                quadroFamiliar.setCodigoPessoa(rs.getString("pessoa"));
                quadrosFamiliares.add(quadroFamiliar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return quadrosFamiliares;
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
