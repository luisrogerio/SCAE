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
import model.Familiar;
import model.Pessoa;

/**
 *
 * @author Raissa
 */
public class FamiliarDAO {

    public static void gravar(Familiar familiar) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Pessoa pessoa = new Pessoa(familiar.getId(), familiar.getNome(), familiar.getDataNascimento(),
                familiar.getEstadoCivil(), familiar.getCPF(), familiar.getIdentidade());
        try {
            Pessoa.gravar(pessoa);
        } catch (SQLException e) {
            throw e;
        }
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO familiares (codigo, formulario_socioeconomico, pessoa, nacionalidade, parentesco) VALUES (?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, familiar.getCodigo());
            comando.setInt(2, familiar.getCodigoFormularioSocioeconomico());
            comando.setString(3, familiar.getCodigoPessoa());
            comando.setString(4, familiar.getNacionalidade());
            comando.setString(5, familiar.getParentesco());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

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
                        rs.getString("pessoas.id"),
                        rs.getString("nome"),
                        rs.getString("dataNascimento"),
                        rs.getString("estadoCivil"),
                        rs.getString("CPF"),
                        rs.getString("identidade"),
                        rs.getString("codigo"),
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

    public static Familiar obterFamiliar(String codigo) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Familiar familiar = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM familiares, pessoas "
                    + "WHERE familiares.pessoa = pessoas.id AND familiares.codigo LIKE \"" + codigo + "\"");
            rs.first();
            familiar = new Familiar(
                    rs.getString("pessoas.id"),
                    rs.getString("nome"),
                    rs.getString("dataNascimento"),
                    rs.getString("estadoCivil"),
                    rs.getString("CPF"),
                    rs.getString("identidade"),
                    rs.getString("codigo"),
                    rs.getString("nacionalidade"),
                    rs.getString("parentesco"),
                    null
            );
            familiar.setCodigoFormularioSocioeconomico(rs.getInt("formularioSocioeconomico"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return familiar;
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
