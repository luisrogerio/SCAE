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
import model.Endereco;

/**
 *
 * @author Raissa
 */
public class EnderecoDAO {

    public static List<Endereco> obterEnderecos() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Endereco> enderecos = new ArrayList<Endereco>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM enderecos");
            while (rs.next()) {
                Endereco endereco = new Endereco(
                        rs.getInt("id"),
                        rs.getString("logradouro"),
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("UF"),
                        rs.getString("logradouroRepublica"),
                        rs.getString("ruaRepublica"),
                        rs.getString("bairroRepublica"),
                        rs.getString("cidadeRepublica"),
                        rs.getString("UFRepublica")
                );
                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return enderecos;
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
