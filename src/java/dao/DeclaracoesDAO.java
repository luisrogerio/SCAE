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
import model.Declaracoes;

/**
 *
 * @author Raissa
 */
public class DeclaracoesDAO {

    public static List<Declaracoes> obterDeclaracoes() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Declaracoes> declaracoes = new ArrayList<Declaracoes>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM declaracoes");
            while (rs.next()) {
                Declaracoes declaracao = new Declaracoes(
                        rs.getInt("id"), 
                        rs.getBoolean("residenciaRepublica"), 
                        rs.getBoolean("naoAtividade"), 
                        rs.getBoolean("atividadeInformal"), 
                        rs.getBoolean("inexistenciaContaBancaria"), 
                        rs.getBoolean("inexistenciaContaBancariaJuridica"), 
                        null, 
                        null
                );
                declaracao.setCodigoEdital(rs.getInt("edital"));
                declaracao.setCodigoPessoa(rs.getInt("pessoa"));
                declaracoes.add(declaracao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracoes;
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
