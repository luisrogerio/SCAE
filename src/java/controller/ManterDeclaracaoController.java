/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Declaracoes;
import model.Edital;
import model.Pessoa;

/**
 *
 * @author Raissa
 */
public class ManterDeclaracaoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        }
        else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            request.setAttribute("editais", Edital.obterEditais());
            RequestDispatcher view = request.getRequestDispatcher("/manterDeclaracoes.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex){
            
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        int edital = Integer.parseInt(request.getParameter("selectEdital"));
        String pessoa = request.getParameter("selectPessoa");
        boolean residenciaRepublica = Boolean.parseBoolean(request.getParameter("checkResidenciaRepublica"));
        boolean naoAtividade = Boolean.parseBoolean(request.getParameter("checkNaoAtividade"));
        boolean atividadeInformal = Boolean.parseBoolean(request.getParameter("checkAtividadeInformal"));
        boolean inexistenciaContaBancaria = Boolean.parseBoolean(request.getParameter("checkInexistenciaContaBancaria"));
        boolean inexistenciaContaBancariaJuridica = Boolean.parseBoolean(request.getParameter("checkInexistenciaContaBancariaJuridica"));

        try {
            Declaracoes declaracao = new Declaracoes(id, residenciaRepublica, 
                    naoAtividade, atividadeInformal, inexistenciaContaBancaria, inexistenciaContaBancariaJuridica, null, null);
            declaracao.setCodigoEdital(edital);
            declaracao.setCodigoPessoa(pessoa);
            Declaracoes.gravar(declaracao);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDeclaracoesController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (Exception ex) {

        }
    }
    
    public void prepararEditar(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            int id = Integer.parseInt(request.getParameter("codigoDeclaracao"));
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            request.setAttribute("editais", Edital.obterEditais());
            request.setAttribute("declaracao", Declaracoes.obterDeclaracao(id));
            RequestDispatcher view = request.getRequestDispatcher("/manterDeclaracoes.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex){
            
        }
    }
    
    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        int edital = Integer.parseInt(request.getParameter("selectEdital"));
        String pessoa = request.getParameter("selectPessoa");
        boolean residenciaRepublica = Boolean.parseBoolean(request.getParameter("checkResidenciaRepublica"));
        boolean naoAtividade = Boolean.parseBoolean(request.getParameter("checkNaoAtividade"));
        boolean atividadeInformal = Boolean.parseBoolean(request.getParameter("checkAtividadeInformal"));
        boolean inexistenciaContaBancaria = Boolean.parseBoolean(request.getParameter("checkInexistenciaContaBancaria"));
        boolean inexistenciaContaBancariaJuridica = Boolean.parseBoolean(request.getParameter("checkInexistenciaContaBancariaJuridica"));

        try {
            Declaracoes declaracao = new Declaracoes(id, residenciaRepublica, 
                    naoAtividade, atividadeInformal, inexistenciaContaBancaria, inexistenciaContaBancariaJuridica, null, null);
            declaracao.setCodigoEdital(edital);
            declaracao.setCodigoPessoa(pessoa);
            Declaracoes.alterar(declaracao);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDeclaracoesController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (Exception ex) {

        }
    }
    
    public void prepararExcluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            int id = Integer.parseInt(request.getParameter("codigoDeclaracao"));
            request.setAttribute("pessoas", Pessoa.obterPessoas());
            request.setAttribute("editais", Edital.obterEditais());
            request.setAttribute("declaracao", Declaracoes.obterDeclaracao(id));
            RequestDispatcher view = request.getRequestDispatcher("/manterDeclaracoes.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex){
            
        }
    }
    
    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        int edital = Integer.parseInt(request.getParameter("selectEdital"));
        String pessoa = request.getParameter("selectPessoa");
        boolean residenciaRepublica = Boolean.parseBoolean(request.getParameter("checkResidenciaRepublica"));
        boolean naoAtividade = Boolean.parseBoolean(request.getParameter("checkNaoAtividade"));
        boolean atividadeInformal = Boolean.parseBoolean(request.getParameter("checkAtividadeInformal"));
        boolean inexistenciaContaBancaria = Boolean.parseBoolean(request.getParameter("checkInexistenciaContaBancaria"));
        boolean inexistenciaContaBancariaJuridica = Boolean.parseBoolean(request.getParameter("checkInexistenciaContaBancariaJuridica"));

        try {
            Declaracoes declaracao = new Declaracoes(id, residenciaRepublica, 
                    naoAtividade, atividadeInformal, inexistenciaContaBancaria, inexistenciaContaBancariaJuridica, null, null);
            declaracao.setCodigoEdital(edital);
            declaracao.setCodigoPessoa(pessoa);
            Declaracoes.excluir(declaracao);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDeclaracoesController");
            view.forward(request, response);
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        } catch (Exception ex) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
