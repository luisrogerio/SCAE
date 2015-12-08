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
import model.Endereco;
import model.FormularioSocioeconomico;

/**
 *
 * @author Raissa
 */
public class ManterFormularioSocioeconomicoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        }/*  else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }*/
    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            RequestDispatcher view = request.getRequestDispatcher("/manterFormularioSocioeconomico.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("textId"));
        String logradouro = request.getParameter("textLogradouro");
        String rua = request.getParameter("textRua");
        String bairro = request.getParameter("textBairro");
        String cidade = request.getParameter("textCidade");
        String UF = request.getParameter("textUF");
        String logradouroRepublica = request.getParameter("textLogradouroRepublica");
        String ruaRepublica = request.getParameter("textRuaRepublica");
        String bairroRepublica = request.getParameter("textBairroRepublica");
        String cidadeRepublica = request.getParameter("textCidadeRepublica");
        String UFRepublica = request.getParameter("textUFRepublica");
        String candidato = request.getParameter("selectCandidato");
        int edital = Integer.parseInt(request.getParameter("selectEdital"));
        int enredeco = Integer.parseInt(request.getParameter("textEnredeco"));
        String serieModuloPeriodo = request.getParameter("textSerieModuloPeriodo");
        boolean atendimentoAssistencia = Boolean.parseBoolean(request.getParameter("textAtendimentoAssistencia"));
        String atendido = request.getParameter("textAtendido");
        String programaAtendimento = request.getParameter("textProgramaAtendimento");
        String anoAtendimento = request.getParameter("textAnoAtendimento");
        String meioTransporte = request.getParameter("textMeioTransporte");
        String outroMeio = request.getParameter("textOutroMeio");
        float gastoMensal = Float.parseFloat(request.getParameter("textGastoMensal"));
        String tipoAtividadeAcademica = request.getParameter("textTipoAtividadeAcademica");
        String nomeAtividadeAcademica = request.getParameter("textNomeAtividadeAcademica");
        float ganhoAtividadeAcademica = Float.parseFloat(request.getParameter("textGanhoAtividadeAcademica"));
        boolean atividadeRemunerada = Boolean.parseBoolean(request.getParameter("textAtividadeRemunerada"));
        int cargaHorariaRemunerada = Integer.parseInt(request.getParameter("textCargaHorariaRemunerada"));
        float salarioRemunerada = Float.parseFloat(request.getParameter("textSalarioRemunerada"));
        String condicaoManutencao = request.getParameter("textCondicaoManutencao");
        String outraCondicaoManutencao = request.getParameter("textOutraCondicaoManutencao");
        String condicaoMoradia = request.getParameter("textCondicaoMoradia");
        String outraCondicaoMoradia = request.getParameter("textOutraCondicaoMoradia");
        String responsavelManutencao = request.getParameter("textResponsavelManutencao");
        String outroResponsavelManutencao = request.getParameter("textOutroResponsavelManutencao");
        boolean esgoto = Boolean.parseBoolean(request.getParameter("textEsgoto"));
        boolean aguaTratada = Boolean.parseBoolean(request.getParameter("textAguaTratada"));
        boolean iluminacao = Boolean.parseBoolean(request.getParameter("textIluminacao"));
        boolean coletaLixo = Boolean.parseBoolean(request.getParameter("textColetaLixo"));
        boolean pavimentacao = Boolean.parseBoolean(request.getParameter("textPavimentacao"));
        String localResidenciaFamiliar = request.getParameter("textLocalResidenciaFamiliar");
        String outroLocalResidenciaFamiliar = request.getParameter("textOutroLocalResidenciaFamiliar");
        String tipoResidenciaFamiliar = request.getParameter("textTipoResidenciaFamiliar");
        String outroTipoResidenciaFamiliar = request.getParameter("textOutroTipoResidenciaFamiliar");
        float precoResidenciaFamiliar = Float.parseFloat(request.getParameter("textPrecoResidenciaFamiliar"));
        String cedente = request.getParameter("textCedente");
        boolean acabamentoResidenciaFamiliar = Boolean.parseBoolean(request.getParameter("textAcabamentoResidenciaFamiliar"));
        String imoveisExtras = request.getParameter("textImoveisExtras");
        int quantidadeAutomoveis = Integer.parseInt(request.getParameter("textQuantidadeAutomoveis"));
        String anos = request.getParameter("textAnos");
        String modelos = request.getParameter("textModelos");
        int quantidadeTelevisoes = Integer.parseInt(request.getParameter("textQuantidadeTelevisoes"));
        int quantidadeMaquinasDeLavar = Integer.parseInt(request.getParameter("textQuantidadeMaquinasDeLavar"));
        int quantidadeGeladeiras = Integer.parseInt(request.getParameter("textQuantidadeGeladeiras"));
        int quantidadeTvsACabo = Integer.parseInt(request.getParameter("textQuantidadeTvsACabo"));
        int quantidadeComputadores = Integer.parseInt(request.getParameter("textQuantidadeComputadores"));
        boolean internet = Boolean.parseBoolean(request.getParameter("textInternet"));
        int quantidadeEmpregadasMensalistas = Integer.parseInt(request.getParameter("textQuantidadeEmpregadasMensalistas"));
        int quantidadeEmpregadasDiaristas = Integer.parseInt(request.getParameter("textQuantidadeEmpregadasDiaristas"));
        int quantidadeBanheiros = Integer.parseInt(request.getParameter("textQuantidadeBanheiros"));
        int quantidadeQuartos = Integer.parseInt(request.getParameter("textQuantidadeQuartos"));
        float aluguelImoveis = Float.parseFloat(request.getParameter("textAluguelImoveis"));
        float pensaoMorte = Float.parseFloat(request.getParameter("textPensaoMorte"));
        float pensaoAlimenticia = Float.parseFloat(request.getParameter("textPensaoAlimenticia"));
        float ajudaTerceiros = Float.parseFloat(request.getParameter("textAjudaTerceiros"));
        float beneficiosSociais = Float.parseFloat(request.getParameter("textBeneficiosSociais"));
        float outraRenda = Float.parseFloat(request.getParameter("textOutraRenda"));
        int numeroResidentes = Integer.parseInt(request.getParameter("textNumeroResidentes"));
        float despesaFamiliarAgua = Float.parseFloat(request.getParameter("textDespesaFamiliarAgua"));
        float despesaFamiliarLuz = Float.parseFloat(request.getParameter("textDespesaFamiliarLuz"));
        float despesaFamiliarTelefone = Float.parseFloat(request.getParameter("textDespesaFamiliarTelefone"));
        float despesaFamiliarCondominio = Float.parseFloat(request.getParameter("textDespesaFamiliarCondominio"));
        float despesaFamiliarMensalidadeEscolar = Float.parseFloat(request.getParameter("textDespesaFamiliarMensalidadeEscolar"));
        float despesaFamiliarAlimentacao = Float.parseFloat(request.getParameter("textDespesaFamiliarAlimentacao"));
        float despesaFamiliarSaude = Float.parseFloat(request.getParameter("textDespesaFamiliarSaude"));
        float despesaFamiliarTransporte = Float.parseFloat(request.getParameter("textDespesaFamiliarTransporte"));
        float despesaFamiliarIPTU = Float.parseFloat(request.getParameter("textDespesaFamiliarIPTU"));
        float despesaFamiliarAluguel = Float.parseFloat(request.getParameter("textDespesaFamiliarAluguel"));
        float despesaFamiliarPensaoAlimenticia = Float.parseFloat(request.getParameter("textDespesaFamiliarPensaoAlimenticia"));
        float despesaFamiliarOutros = Float.parseFloat(request.getParameter("textDespesaFamiliarOutros"));
        float despesaRepublicaAgua = Float.parseFloat(request.getParameter("textDespesaRepublicaAgua"));
        float despesaRepublicaLuz = Float.parseFloat(request.getParameter("textDespesaRepublicaLuz"));
        float despesaRepublicaTelefone = Float.parseFloat(request.getParameter("textDespesaRepublicaTelefone"));
        float despesaRepublicaCondominio = Float.parseFloat(request.getParameter("textDespesaRepublicaCondominio"));
        float despesaRepublicaAluguel = Float.parseFloat(request.getParameter("textDespesaRepublicaAluguel"));
        float despesaRepublicaIPTU = Float.parseFloat(request.getParameter("textDespesaRepublicaIPTU"));
        String dadosExtras = request.getParameter("textDadosExtras");
        String data = request.getParameter("textData");

        try {
            FormularioSocioeconomico formularioSocioeconomico = new FormularioSocioeconomico(id, serieModuloPeriodo, atendimentoAssistencia,
                    atendido, programaAtendimento, anoAtendimento, meioTransporte, outroMeio, gastoMensal, tipoAtividadeAcademica,
                    nomeAtividadeAcademica, ganhoAtividadeAcademica, atividadeRemunerada, cargaHorariaRemunerada,
                    salarioRemunerada, condicaoManutencao, outraCondicaoManutencao, condicaoMoradia,
                    outraCondicaoMoradia, responsavelManutencao, outroResponsavelManutencao, esgoto,
                    aguaTratada, iluminacao, coletaLixo, pavimentacao, localResidenciaFamiliar,
                    outroLocalResidenciaFamiliar, tipoResidenciaFamiliar, outroTipoResidenciaFamiliar,
                    precoResidenciaFamiliar, cedente, acabamentoResidenciaFamiliar, imoveisExtras,
                    quantidadeAutomoveis, anos, modelos, quantidadeTelevisoes, quantidadeMaquinasDeLavar,
                    quantidadeGeladeiras, quantidadeTvsACabo, quantidadeComputadores, internet, quantidadeEmpregadasMensalistas,
                    quantidadeEmpregadasDiaristas, quantidadeBanheiros, quantidadeQuartos, aluguelImoveis,
                    pensaoMorte, pensaoAlimenticia, ajudaTerceiros, beneficiosSociais, outraRenda, numeroResidentes,
                    despesaFamiliarAgua, despesaFamiliarLuz, despesaFamiliarTelefone, despesaFamiliarCondominio,
                    despesaFamiliarMensalidadeEscolar, despesaFamiliarAlimentacao, despesaFamiliarSaude,
                    despesaFamiliarTransporte, despesaFamiliarIPTU, despesaFamiliarAluguel, despesaFamiliarPensaoAlimenticia,
                    despesaFamiliarOutros, despesaRepublicaAgua, despesaRepublicaLuz, despesaRepublicaTelefone,
                    despesaRepublicaCondominio, despesaRepublicaAluguel, despesaRepublicaIPTU, dadosExtras,
                    data, null, null, null);
            Endereco endereco = new Endereco(id, logradouro, rua, bairro, cidade, UF, 
                    logradouroRepublica, ruaRepublica, bairroRepublica, cidadeRepublica, UFRepublica);
            formularioSocioeconomico.setCodigoCandidato(candidato);
            formularioSocioeconomico.setCodigoEdital(edital);
            formularioSocioeconomico.setCodigoEndereco(id);
            FormularioSocioeconomico.gravar(formularioSocioeconomico, endereco);
            RequestDispatcher view = request.getRequestDispatcher("PesquisaFormularioSocioeconomicoController");
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
