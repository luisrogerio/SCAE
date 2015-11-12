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
import model.Pessoa;

/**
 *
 * @author Raissa
 */
public class PessoaDAO {

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
                        rs.getInt("id"),
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
