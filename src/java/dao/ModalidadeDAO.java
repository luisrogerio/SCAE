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
import model.Modalidade;

/**
 *
 * @author Raissa
 */
public class ModalidadeDAO {

    public static List<Modalidade> obterModalidades() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Modalidade> modalidades = new ArrayList<Modalidade>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM modalidades");
            while (rs.next()) {
                Modalidade modalidade = new Modalidade(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                modalidades.add(modalidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return modalidades;
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
