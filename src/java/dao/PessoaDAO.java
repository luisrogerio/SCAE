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
import model.Pessoa;

/**
 *
 * @author Raissa
 */
public class PessoaDAO {

    public static void gravar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO pessoas (id, nome, dataNascimento, estadoCivil, CPF, identidade) VALUES (?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, pessoa.getId());
            comando.setString(2, pessoa.getNome());
            comando.setString(3, pessoa.getDataNascimento());
            comando.setString(4, pessoa.getEstadoCivil());
            comando.setString(5, pessoa.getCPF());
            comando.setString(6, pessoa.getIdentidade());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Pessoa> obterPessoas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM pessoas");
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("dataNascimento"),
                        rs.getString("estadoCivil"),
                        rs.getString("CPF"),
                        rs.getString("identidade")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return pessoas;
    }

    public static Pessoa obterPessoa(String id) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Pessoa pessoa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM pessoas WHERE id LIKE \"" + id + "\"");
            rs.first();
            pessoa = new Pessoa(
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("dataNascimento"),
                    rs.getString("estadoCivil"),
                    rs.getString("CPF"),
                    rs.getString("identidade")
            );

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return pessoa;
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
