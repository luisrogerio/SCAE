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
import model.Edital;

/**
 *
 * @author Raissa
 */
public class EditalDAO {

    public static List<Edital> obterEditais() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Edital> editais = new ArrayList<Edital>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM editais");
            while (rs.next()) {
                Edital edital = new Edital(
                        rs.getInt("id"),
                        rs.getString("ano"),
                        rs.getInt("semestre"),
                        rs.getString("descricao")
                );
                editais.add(edital);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return editais;
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
