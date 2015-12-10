/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Familiar;
import model.FormularioSocioeconomico;

/**
 *
 * @author Raissa
 */
public class ManterFamiliarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        }/* else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }*/
    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("formulariosSocioeconomicos", FormularioSocioeconomico.obterFormulariosSocioeconomicos());
            RequestDispatcher view = request.getRequestDispatcher("/manterFamiliar.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        String codigo = request.getParameter("textCodigo");
        String nome = request.getParameter("textNome");
        String dataNascimento = request.getParameter("textDataNascimento");
        String estadoCivil = request.getParameter("textEstadoCivil");
        String CPF = request.getParameter("textCPF");
        String identidade = request.getParameter("textIdentidade");
        int formularioSocioeconomico = Integer.parseInt(request.getParameter("selectFormularioSocioeconomico"));
        String nacionalidade = request.getParameter("textNacionalidade");
        String parentesco = request.getParameter("textParentesco");

        try {
            Familiar familiar = new Familiar(codigo, nome, dataNascimento, estadoCivil, CPF, identidade, codigo,
                    nacionalidade, parentesco, null);
            familiar.setCodigoFormularioSocioeconomico(formularioSocioeconomico);
            familiar.setCodigoPessoa(codigo);
            Familiar.gravar(familiar);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFamiliarController");
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
            String codigo = request.getParameter("codigoFamiliar");
            request.setAttribute("familiar", Familiar.obterFamiliar(codigo));
            request.setAttribute("formulariosSocioeconomicos", FormularioSocioeconomico.obterFormulariosSocioeconomicos());
            RequestDispatcher view = request.getRequestDispatcher("/manterFamiliar.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        String codigo = request.getParameter("textCodigo");
        String nome = request.getParameter("textNome");
        String dataNascimento = request.getParameter("textDataNascimento");
        String estadoCivil = request.getParameter("textEstadoCivil");
        String CPF = request.getParameter("textCPF");
        String identidade = request.getParameter("textIdentidade");
        int formularioSocioeconomico = Integer.parseInt(request.getParameter("selectFormularioSocioeconomico"));
        String nacionalidade = request.getParameter("textNacionalidade");
        String parentesco = request.getParameter("textParentesco");

        try {
            Familiar familiar = new Familiar(codigo, nome, dataNascimento, estadoCivil, CPF, identidade, codigo,
                    nacionalidade, parentesco, null);
            familiar.setCodigoFormularioSocioeconomico(formularioSocioeconomico);
            familiar.setCodigoPessoa(codigo);
            Familiar.gravar(familiar);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFamiliarController");
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
