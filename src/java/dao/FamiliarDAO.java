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
import model.Familiar;

/**
 *
 * @author Raissa
 */
public class FamiliarDAO {

    public static List<Familiar> obterFamiliares() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Familiar> familiares = new ArrayList<Familiar>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM familiares, pessoas WHERE familiares.pessoa = pessoas.id");
            while (rs.next()) {
                Familiar familiar = new Familiar(
                        rs.getInt("pessoas.id"),
                        rs.getString("nome"),
                        rs.getString("dataNascimento"),
                        rs.getString("estadoCivil"),
                        rs.getString("CPF"),
                        rs.getString("identidade"),
                        rs.getInt("familiares.id"),
                        rs.getString("nacionalidade"),
                        rs.getString("parentesco"),
                        null
                );
                familiar.setCodigoFormularioSocioeconomico(rs.getInt("formularioSocioeconomico"));
                familiares.add(familiar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return familiares;
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
