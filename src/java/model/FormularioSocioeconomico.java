package model;

import dao.FormularioSocioeconomicoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuísRogério
 */
public class FormularioSocioeconomico {

    private int id;
    private String serieModuloPeriodo;
    private boolean atendimentoAssistencia;
    private String atendido;
    private String programaAtendimento;
    private String anoAtendimento;
    private String meioTransporte;
    private String outroMeio;
    private float gastoMensal;
    private String tipoAtividadeAcademica;
    private String nomeAtividadeAcademica;
    private float ganhoAtividadeAcademica;
    private boolean atividadeRemunerada;
    private int cargaHorariaRemunerada;
    private float salarioRemunerada;
    private String condicaoManutencao;
    private String outraCondicaoManutencao;
    private String condicaoMoradia;
    private String outraCondicaoMoradia;
    private String responsavelManutencao;
    private String outroResponsavelManutencao;
    private boolean esgoto;
    private boolean aguaTratada;
    private boolean iluminacao;
    private boolean coletaLixo;
    private boolean pavimentacao;
    private String localResidenciaFamiliar;
    private String outroLocalResidenciaFamiliar;
    private String tipoResidenciaFamiliar;
    private String outroTipoResidenciaFamiliar;
    private float precoResidenciaFamiliar;
    private String cedente;
    private boolean acabamentoResidenciaFamiliar;
    private String imoveisExtras;
    private int quantidadeAutomoveis;
    private String anos;
    private String modelos;
    private int quantidadeTelevisoes;
    private int quantidadeMaquinasDeLavar;
    private int quantidadeGeladeiras;
    private int quantidadeTvsACabo;
    private int quantidadeComputadores;
    private boolean internet;
    private int quantidadeEmpregadasMensalistas;
    private int quantidadeEmpregadasDiaristas;
    private int quantidadeBanheiros;
    private int quantidadeQuartos;
    private float aluguelImoveis;
    private float pensaoMorte;
    private float pensaoAlimenticia;
    private float ajudaTerceiros;
    private float beneficiosSociais;
    private float outraRenda;
    private int numeroResidentes;
    private float despesaFamiliarAgua;
    private float despesaFamiliarLuz;
    private float despesaFamiliarTelefone;
    private float despesaFamiliarCondominio;
    private float despesaFamiliarMensalidadeEscolar;
    private float despesaFamiliarAlimentacao;
    private float despesaFamiliarSaude;
    private float despesaFamiliarTransporte;
    private float despesaFamiliarIPTU;
    private float despesaFamiliarAluguel;
    private float despesaFamiliarPensaoAlimenticia;
    private float despesaFamiliarOutros;
    private float despesaRepublicaAgua;
    private float despesaRepublicaLuz;
    private float despesaRepublicaTelefone;
    private float despesaRepublicaCondominio;
    private float despesaRepublicaAluguel;
    private float despesaRepublicaIPTU;
    private String dadosExtras;
    private String data;
    private Candidato candidato;
    private Edital edital;
    private Endereco endereco;
    private List<Modalidade> modalidades;

    private String codigoCandidato;
    private int codigoEdital;
    private int codigoEndereco;
    private List<Integer> codigosModalidades;

    public FormularioSocioeconomico(int id, String serieModuloPeriodo, boolean atendimentoAssistencia, String atendido,
            String programaAtendimento, String anoAtendimento, String meioTransporte, String outroMeio, float gastoMensal,
            String tipoAtividadeAcademica, String nomeAtividadeAcademica, float ganhoAtividadeAcademica,
            boolean atividadeRemunerada, int cargaHorariaRemunerada, float salarioRemunerada, String condicaoManutencao, String outraCondicaoManutencao,
            String condicaoMoradia, String outraCondicaoMoradia, String responsavelManutencao,
            String outroResponsavelManutencao, boolean esgoto, boolean aguaTratada, boolean iluminacao,
            boolean coletaLixo, boolean pavimentacao, String localResidenciaFamiliar,
            String outroLocalResidenciaFamiliar, String tipoResidenciaFamiliar, String outroTipoResidenciaFamiliar,
            float precoResidenciaFamiliar, String cedente, boolean acabamentoResidenciaFamiliar, String imoveisExtras,
            int quantidadeAutomoveis, String anos, String modelos, int quantidadeTelevisoes,
            int quantidadeMaquinasDeLavar, int quantidadeGeladeiras, int quantidadeTvsACabo,
            int quantidadeComputadores, boolean internet, int quantidadeEmpregadasMensalistas,
            int quantidadeEmpregadasDiaristas, int quantidadeBanheiros, int quantidadeQuartos, float aluguelImoveis,
            float pensaoMorte, float pensaoAlimenticia, float ajudaTerceiros, float beneficiosSociais,
            float outraRenda, int numeroResidentes, float despesaFamiliarAgua, float despesaFamiliarLuz,
            float despesaFamiliarTelefone, float despesaFamiliarCondominio, float despesaFamiliarMensalidadeEscolar,
            float despesaFamiliarAlimentacao, float despesaFamiliarSaude, float despesaFamiliarTransporte,
            float despesaFamiliarIPTU, float despesaFamiliarAluguel, float despesaFamiliarPensaoAlimenticia,
            float despesaFamiliarOutros, float despesaRepublicaAgua, float despesaRepublicaLuz,
            float despesaRepublicaTelefone, float despesaRepublicaCondominio, float despesaRepublicaAluguel,
            float despesaRepublicaIPTU, String dadosExtras, String data, Candidato candidato, Edital edital,
            Endereco enredeco, List<Modalidade> modalidades) {
        this.id = id;
        this.serieModuloPeriodo = serieModuloPeriodo;
        this.atendimentoAssistencia = atendimentoAssistencia;
        this.atendido = atendido;
        this.programaAtendimento = programaAtendimento;
        this.anoAtendimento = anoAtendimento;
        this.meioTransporte = meioTransporte;
        this.outroMeio = outroMeio;
        this.gastoMensal = gastoMensal;
        this.tipoAtividadeAcademica = tipoAtividadeAcademica;
        this.nomeAtividadeAcademica = nomeAtividadeAcademica;
        this.ganhoAtividadeAcademica = ganhoAtividadeAcademica;
        this.atividadeRemunerada = atividadeRemunerada;
        this.cargaHorariaRemunerada = cargaHorariaRemunerada;
        this.salarioRemunerada = salarioRemunerada;
        this.condicaoManutencao = condicaoManutencao;
        this.outraCondicaoManutencao = outraCondicaoManutencao;
        this.condicaoMoradia = condicaoMoradia;
        this.outraCondicaoMoradia = outraCondicaoMoradia;
        this.responsavelManutencao = responsavelManutencao;
        this.outroResponsavelManutencao = outroResponsavelManutencao;
        this.esgoto = esgoto;
        this.aguaTratada = aguaTratada;
        this.iluminacao = iluminacao;
        this.coletaLixo = coletaLixo;
        this.pavimentacao = pavimentacao;
        this.localResidenciaFamiliar = localResidenciaFamiliar;
        this.outroLocalResidenciaFamiliar = outroLocalResidenciaFamiliar;
        this.tipoResidenciaFamiliar = tipoResidenciaFamiliar;
        this.outroTipoResidenciaFamiliar = outroTipoResidenciaFamiliar;
        this.precoResidenciaFamiliar = precoResidenciaFamiliar;
        this.cedente = cedente;
        this.acabamentoResidenciaFamiliar = acabamentoResidenciaFamiliar;
        this.imoveisExtras = imoveisExtras;
        this.quantidadeAutomoveis = quantidadeAutomoveis;
        this.anos = anos;
        this.modelos = modelos;
        this.quantidadeTelevisoes = quantidadeTelevisoes;
        this.quantidadeMaquinasDeLavar = quantidadeMaquinasDeLavar;
        this.quantidadeGeladeiras = quantidadeGeladeiras;
        this.quantidadeTvsACabo = quantidadeTvsACabo;
        this.quantidadeComputadores = quantidadeComputadores;
        this.internet = internet;
        this.quantidadeEmpregadasMensalistas = quantidadeEmpregadasMensalistas;
        this.quantidadeEmpregadasDiaristas = quantidadeEmpregadasDiaristas;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeQuartos = quantidadeQuartos;
        this.aluguelImoveis = aluguelImoveis;
        this.pensaoMorte = pensaoMorte;
        this.pensaoAlimenticia = pensaoAlimenticia;
        this.ajudaTerceiros = ajudaTerceiros;
        this.beneficiosSociais = beneficiosSociais;
        this.outraRenda = outraRenda;
        this.numeroResidentes = numeroResidentes;
        this.despesaFamiliarAgua = despesaFamiliarAgua;
        this.despesaFamiliarLuz = despesaFamiliarLuz;
        this.despesaFamiliarTelefone = despesaFamiliarTelefone;
        this.despesaFamiliarCondominio = despesaFamiliarCondominio;
        this.despesaFamiliarMensalidadeEscolar = despesaFamiliarMensalidadeEscolar;
        this.despesaFamiliarAlimentacao = despesaFamiliarAlimentacao;
        this.despesaFamiliarSaude = despesaFamiliarSaude;
        this.despesaFamiliarTransporte = despesaFamiliarTransporte;
        this.despesaFamiliarIPTU = despesaFamiliarIPTU;
        this.despesaFamiliarAluguel = despesaFamiliarAluguel;
        this.despesaFamiliarPensaoAlimenticia = despesaFamiliarPensaoAlimenticia;
        this.despesaFamiliarOutros = despesaFamiliarOutros;
        this.despesaRepublicaAgua = despesaRepublicaAgua;
        this.despesaRepublicaLuz = despesaRepublicaLuz;
        this.despesaRepublicaTelefone = despesaRepublicaTelefone;
        this.despesaRepublicaCondominio = despesaRepublicaCondominio;
        this.despesaRepublicaAluguel = despesaRepublicaAluguel;
        this.despesaRepublicaIPTU = despesaRepublicaIPTU;
        this.dadosExtras = dadosExtras;
        this.data = data;
        this.candidato = candidato;
        this.edital = edital;
        this.endereco = enredeco;
        this.modalidades = modalidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerieModuloPeriodo() {
        return serieModuloPeriodo;
    }

    public void setSerieModuloPeriodo(String serieModuloPeriodo) {
        this.serieModuloPeriodo = serieModuloPeriodo;
    }

    public boolean isAtendimentoAssistencia() {
        return atendimentoAssistencia;
    }

    public void setAtendimentoAssistencia(boolean atendimentoAssistencia) {
        this.atendimentoAssistencia = atendimentoAssistencia;
    }

    public String getAtendido() {
        return atendido;
    }

    public void setAtendido(String atendido) {
        this.atendido = atendido;
    }

    public String getProgramaAtendimento() {
        return programaAtendimento;
    }

    public void setProgramaAtendimento(String programaAtendimento) {
        this.programaAtendimento = programaAtendimento;
    }

    public String getAnoAtendimento() {
        return anoAtendimento;
    }

    public void setAnoAtendimento(String anoAtendimento) {
        this.anoAtendimento = anoAtendimento;
    }

    public String getMeioTransporte() {
        return meioTransporte;
    }

    public void setMeioTransporte(String meioTransporte) {
        this.meioTransporte = meioTransporte;
    }

    public String getOutroMeio() {
        return outroMeio;
    }

    public void setOutroMeio(String outroMeio) {
        this.outroMeio = outroMeio;
    }

    public float getGastoMensal() {
        return gastoMensal;
    }

    public void setGastoMensal(float gastoMensal) {
        this.gastoMensal = gastoMensal;
    }

    public String getTipoAtividadeAcademica() {
        return tipoAtividadeAcademica;
    }

    public void setTipoAtividadeAcademica(String tipoAtividadeAcademica) {
        this.tipoAtividadeAcademica = tipoAtividadeAcademica;
    }

    public String getNomeAtividadeAcademica() {
        return nomeAtividadeAcademica;
    }

    public void setNomeAtividadeAcademica(String nomeAtividadeAcademica) {
        this.nomeAtividadeAcademica = nomeAtividadeAcademica;
    }

    public float getGanhoAtividadeAcademica() {
        return ganhoAtividadeAcademica;
    }

    public void setGanhoAtividadeAcademica(float ganhoAtividadeAcademica) {
        this.ganhoAtividadeAcademica = ganhoAtividadeAcademica;
    }

    public boolean isAtividadeRemunerada() {
        return atividadeRemunerada;
    }

    public void setAtividadeRemunerada(boolean atividadeRemunerada) {
        this.atividadeRemunerada = atividadeRemunerada;
    }

    public int getCargaHorariaRemunerada() {
        return cargaHorariaRemunerada;
    }

    public void setCargaHorariaRemunerada(int cargaHorariaRemunerada) {
        this.cargaHorariaRemunerada = cargaHorariaRemunerada;
    }

    public float getSalarioRemunerada() {
        return salarioRemunerada;
    }

    public void setSalarioRemunerada(float salarioRemunerada) {
        this.salarioRemunerada = salarioRemunerada;
    }

    public String getCondicaoManutencao() {
        return condicaoManutencao;
    }

    public void setCondicaoManutencao(String condicaoManutencao) {
        this.condicaoManutencao = condicaoManutencao;
    }

    public String getOutraCondicaoManutencao() {
        return outraCondicaoManutencao;
    }

    public void setOutraCondicaoManutencao(String outraCondicaoManutencao) {
        this.outraCondicaoManutencao = outraCondicaoManutencao;
    }

    public String getCondicaoMoradia() {
        return condicaoMoradia;
    }

    public void setCondicaoMoradia(String condicaoMoradia) {
        this.condicaoMoradia = condicaoMoradia;
    }

    public String getOutraCondicaoMoradia() {
        return outraCondicaoMoradia;
    }

    public void setOutraCondicaoMoradia(String outraCondicaoMoradia) {
        this.outraCondicaoMoradia = outraCondicaoMoradia;
    }

    public String getResponsavelManutencao() {
        return responsavelManutencao;
    }

    public void setResponsavelManutencao(String responsavelManutencao) {
        this.responsavelManutencao = responsavelManutencao;
    }

    public String getOutroResponsavelManutencao() {
        return outroResponsavelManutencao;
    }

    public void setOutroResponsavelManutencao(String outroResponsavelManutencao) {
        this.outroResponsavelManutencao = outroResponsavelManutencao;
    }

    public boolean isEsgoto() {
        return esgoto;
    }

    public void setEsgoto(boolean esgoto) {
        this.esgoto = esgoto;
    }

    public boolean isAguaTratada() {
        return aguaTratada;
    }

    public void setAguaTratada(boolean aguaTratada) {
        this.aguaTratada = aguaTratada;
    }

    public boolean isIluminacao() {
        return iluminacao;
    }

    public void setIluminacao(boolean iluminacao) {
        this.iluminacao = iluminacao;
    }

    public boolean isColetaLixo() {
        return coletaLixo;
    }

    public void setColetaLixo(boolean coletaLixo) {
        this.coletaLixo = coletaLixo;
    }

    public boolean isPavimentacao() {
        return pavimentacao;
    }

    public void setPavimentacao(boolean pavimentacao) {
        this.pavimentacao = pavimentacao;
    }

    public String getLocalResidenciaFamiliar() {
        return localResidenciaFamiliar;
    }

    public void setLocalResidenciaFamiliar(String localResidenciaFamiliar) {
        this.localResidenciaFamiliar = localResidenciaFamiliar;
    }

    public String getOutroLocalResidenciaFamiliar() {
        return outroLocalResidenciaFamiliar;
    }

    public void setOutroLocalResidenciaFamiliar(String outroLocalResidenciaFamiliar) {
        this.outroLocalResidenciaFamiliar = outroLocalResidenciaFamiliar;
    }

    public String getTipoResidenciaFamiliar() {
        return tipoResidenciaFamiliar;
    }

    public void setTipoResidenciaFamiliar(String tipoResidenciaFamiliar) {
        this.tipoResidenciaFamiliar = tipoResidenciaFamiliar;
    }

    public String getOutroTipoResidenciaFamiliar() {
        return outroTipoResidenciaFamiliar;
    }

    public void setOutroTipoResidenciaFamiliar(String outroTipoResidenciaFamiliar) {
        this.outroTipoResidenciaFamiliar = outroTipoResidenciaFamiliar;
    }

    public float getPrecoResidenciaFamiliar() {
        return precoResidenciaFamiliar;
    }

    public void setPrecoResidenciaFamiliar(float precoResidenciaFamiliar) {
        this.precoResidenciaFamiliar = precoResidenciaFamiliar;
    }

    public String getCedente() {
        return cedente;
    }

    public void setCedente(String cedente) {
        this.cedente = cedente;
    }

    public boolean isAcabamentoResidenciaFamiliar() {
        return acabamentoResidenciaFamiliar;
    }

    public void setAcabamentoResidenciaFamiliar(boolean acabamentoResidenciaFamiliar) {
        this.acabamentoResidenciaFamiliar = acabamentoResidenciaFamiliar;
    }

    public String getImoveisExtras() {
        return imoveisExtras;
    }

    public void setImoveisExtras(String imoveisExtras) {
        this.imoveisExtras = imoveisExtras;
    }

    public int getQuantidadeAutomoveis() {
        return quantidadeAutomoveis;
    }

    public void setQuantidadeAutomoveis(int quantidadeAutomoveis) {
        this.quantidadeAutomoveis = quantidadeAutomoveis;
    }

    public String getAnos() {
        return anos;
    }

    public void setAnos(String anos) {
        this.anos = anos;
    }

    public String getModelos() {
        return modelos;
    }

    public void setModelos(String modelos) {
        this.modelos = modelos;
    }

    public int getQuantidadeTelevisoes() {
        return quantidadeTelevisoes;
    }

    public void setQuantidadeTelevisoes(int quantidadeTelevisoes) {
        this.quantidadeTelevisoes = quantidadeTelevisoes;
    }

    public int getQuantidadeMaquinasDeLavar() {
        return quantidadeMaquinasDeLavar;
    }

    public void setQuantidadeMaquinasDeLavar(int quantidadeMaquinasDeLavar) {
        this.quantidadeMaquinasDeLavar = quantidadeMaquinasDeLavar;
    }

    public int getQuantidadeGeladeiras() {
        return quantidadeGeladeiras;
    }

    public void setQuantidadeGeladeiras(int quantidadeGeladeiras) {
        this.quantidadeGeladeiras = quantidadeGeladeiras;
    }

    public int getQuantidadeTvsACabo() {
        return quantidadeTvsACabo;
    }

    public void setQuantidadeTvsACabo(int quantidadeTvsACabo) {
        this.quantidadeTvsACabo = quantidadeTvsACabo;
    }

    public int getQuantidadeComputadores() {
        return quantidadeComputadores;
    }

    public void setQuantidadeComputadores(int quantidadeComputadores) {
        this.quantidadeComputadores = quantidadeComputadores;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public int getQuantidadeEmpregadasMensalistas() {
        return quantidadeEmpregadasMensalistas;
    }

    public void setQuantidadeEmpregadasMensalistas(int quantidadeEmpregadasMensalistas) {
        this.quantidadeEmpregadasMensalistas = quantidadeEmpregadasMensalistas;
    }

    public int getQuantidadeEmpregadasDiaristas() {
        return quantidadeEmpregadasDiaristas;
    }

    public void setQuantidadeEmpregadasDiaristas(int quantidadeEmpregadasDiaristas) {
        this.quantidadeEmpregadasDiaristas = quantidadeEmpregadasDiaristas;
    }

    public int getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(int quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public float getAluguelImoveis() {
        return aluguelImoveis;
    }

    public void setAluguelImoveis(float aluguelImoveis) {
        this.aluguelImoveis = aluguelImoveis;
    }

    public float getPensaoMorte() {
        return pensaoMorte;
    }

    public void setPensaoMorte(float pensaoMorte) {
        this.pensaoMorte = pensaoMorte;
    }

    public float getPensaoAlimenticia() {
        return pensaoAlimenticia;
    }

    public void setPensaoAlimenticia(float pensaoAlimenticia) {
        this.pensaoAlimenticia = pensaoAlimenticia;
    }

    public float getAjudaTerceiros() {
        return ajudaTerceiros;
    }

    public void setAjudaTerceiros(float ajudaTerceiros) {
        this.ajudaTerceiros = ajudaTerceiros;
    }

    public float getBeneficiosSociais() {
        return beneficiosSociais;
    }

    public void setBeneficiosSociais(float beneficiosSociais) {
        this.beneficiosSociais = beneficiosSociais;
    }

    public float getOutraRenda() {
        return outraRenda;
    }

    public void setOutraRenda(float outraRenda) {
        this.outraRenda = outraRenda;
    }

    public int getNumeroResidentes() {
        return numeroResidentes;
    }

    public void setNumeroResidentes(int numeroResidentes) {
        this.numeroResidentes = numeroResidentes;
    }

    public float getDespesaFamiliarAgua() {
        return despesaFamiliarAgua;
    }

    public void setDespesaFamiliarAgua(float despesaFamiliarAgua) {
        this.despesaFamiliarAgua = despesaFamiliarAgua;
    }

    public float getDespesaFamiliarLuz() {
        return despesaFamiliarLuz;
    }

    public void setDespesaFamiliarLuz(float despesaFamiliarLuz) {
        this.despesaFamiliarLuz = despesaFamiliarLuz;
    }

    public float getDespesaFamiliarTelefone() {
        return despesaFamiliarTelefone;
    }

    public void setDespesaFamiliarTelefone(float despesaFamiliarTelefone) {
        this.despesaFamiliarTelefone = despesaFamiliarTelefone;
    }

    public float getDespesaFamiliarCondominio() {
        return despesaFamiliarCondominio;
    }

    public void setDespesaFamiliarCondominio(float despesaFamiliarCondominio) {
        this.despesaFamiliarCondominio = despesaFamiliarCondominio;
    }

    public float getDespesaFamiliarMensalidadeEscolar() {
        return despesaFamiliarMensalidadeEscolar;
    }

    public void setDespesaFamiliarMensalidadeEscolar(float despesaFamiliarMensalidadeEscolar) {
        this.despesaFamiliarMensalidadeEscolar = despesaFamiliarMensalidadeEscolar;
    }

    public float getDespesaFamiliarAlimentacao() {
        return despesaFamiliarAlimentacao;
    }

    public void setDespesaFamiliarAlimentacao(float despesaFamiliarAlimentacao) {
        this.despesaFamiliarAlimentacao = despesaFamiliarAlimentacao;
    }

    public float getDespesaFamiliarSaude() {
        return despesaFamiliarSaude;
    }

    public void setDespesaFamiliarSaude(float despesaFamiliarSaude) {
        this.despesaFamiliarSaude = despesaFamiliarSaude;
    }

    public float getDespesaFamiliarTransporte() {
        return despesaFamiliarTransporte;
    }

    public void setDespesaFamiliarTransporte(float despesaFamiliarTransporte) {
        this.despesaFamiliarTransporte = despesaFamiliarTransporte;
    }

    public float getDespesaFamiliarIPTU() {
        return despesaFamiliarIPTU;
    }

    public void setDespesaFamiliarIPTU(float despesaFamiliarIPTU) {
        this.despesaFamiliarIPTU = despesaFamiliarIPTU;
    }

    public float getDespesaFamiliarAluguel() {
        return despesaFamiliarAluguel;
    }

    public void setDespesaFamiliarAluguel(float despesaFamiliarAluguel) {
        this.despesaFamiliarAluguel = despesaFamiliarAluguel;
    }

    public float getDespesaFamiliarPensaoAlimenticia() {
        return despesaFamiliarPensaoAlimenticia;
    }

    public void setDespesaFamiliarPensaoAlimenticia(float despesaFamiliarPensaoAlimenticia) {
        this.despesaFamiliarPensaoAlimenticia = despesaFamiliarPensaoAlimenticia;
    }

    public float getDespesaFamiliarOutros() {
        return despesaFamiliarOutros;
    }

    public void setDespesaFamiliarOutros(float despesaFamiliarOutros) {
        this.despesaFamiliarOutros = despesaFamiliarOutros;
    }

    public float getDespesaRepublicaAgua() {
        return despesaRepublicaAgua;
    }

    public void setDespesaRepublicaAgua(float despesaRepublicaAgua) {
        this.despesaRepublicaAgua = despesaRepublicaAgua;
    }

    public float getDespesaRepublicaLuz() {
        return despesaRepublicaLuz;
    }

    public void setDespesaRepublicaLuz(float despesaRepublicaLuz) {
        this.despesaRepublicaLuz = despesaRepublicaLuz;
    }

    public float getDespesaRepublicaTelefone() {
        return despesaRepublicaTelefone;
    }

    public void setDespesaRepublicaTelefone(float despesaRepublicaTelefone) {
        this.despesaRepublicaTelefone = despesaRepublicaTelefone;
    }

    public float getDespesaRepublicaCondominio() {
        return despesaRepublicaCondominio;
    }

    public void setDespesaRepublicaCondominio(float despesaRepublicaCondominio) {
        this.despesaRepublicaCondominio = despesaRepublicaCondominio;
    }

    public float getDespesaRepublicaAluguel() {
        return despesaRepublicaAluguel;
    }

    public void setDespesaRepublicaAluguel(float despesaRepublicaAluguel) {
        this.despesaRepublicaAluguel = despesaRepublicaAluguel;
    }

    public float getDespesaRepublicaIPTU() {
        return despesaRepublicaIPTU;
    }

    public void setDespesaRepublicaIPTU(float despesaRepublicaIPTU) {
        this.despesaRepublicaIPTU = despesaRepublicaIPTU;
    }

    public String getDadosExtras() {
        return dadosExtras;
    }

    public void setDadosExtras(String dadosExtras) {
        this.dadosExtras = dadosExtras;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Candidato getCandidato() {
        if (!this.codigoCandidato.equals("0") && this.candidato == null) {
            try {
                this.candidato = Candidato.obterCandidato(this.codigoCandidato);
            } catch (ClassNotFoundException ex) {

            }
        }
        return this.candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Edital getEdital() {
        if (this.codigoEdital != 0 && this.edital == null) {
            try {
                this.edital = Edital.obterEdital(this.codigoEdital);
            } catch (ClassNotFoundException ex) {

            }
        }
        return this.edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    public Endereco getEndereco() {
        if (this.codigoEndereco != 0 && this.endereco == null) {
            try {
                this.endereco = Endereco.obterEndereco(this.codigoEndereco);
            } catch (ClassNotFoundException ex) {

            }
        }
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCodigoCandidato() {
        return codigoCandidato;
    }

    public void setCodigoCandidato(String codigoCandidato) {
        this.codigoCandidato = codigoCandidato;
    }

    public int getCodigoEdital() {
        return codigoEdital;
    }

    public void setCodigoEdital(int codigoEdital) {
        this.codigoEdital = codigoEdital;
    }

    public int getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public List<Modalidade> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<Modalidade> modalidades) {
        this.modalidades = modalidades;
    }
    
    public List<Integer> getCodigosModalidades() {
        return codigosModalidades;
    }

    public void setCodigosModalidades(List<Integer> codigosModalidades) {
        this.codigosModalidades = codigosModalidades;
    }

    public static List<FormularioSocioeconomico> obterFormulariosSocioeconomicos() throws ClassNotFoundException {
        return FormularioSocioeconomicoDAO.obterFormulariosSocioeconomicos();
    }
    
    public static FormularioSocioeconomico obterFormularioSocioeconomico(int id) throws ClassNotFoundException {
        return FormularioSocioeconomicoDAO.obterFormularioSocioeconomico(id);
    }
        
    public static void gravar(FormularioSocioeconomico formularioSocioeconomico, Endereco endereco) throws ClassNotFoundException, SQLException{
        FormularioSocioeconomicoDAO.gravar(formularioSocioeconomico, endereco);
    }
        
    public static void alterar(FormularioSocioeconomico formularioSocioeconomico, Endereco endereco) throws ClassNotFoundException, SQLException{
        FormularioSocioeconomicoDAO.alterar(formularioSocioeconomico, endereco);
    }
    public static void excluir(FormularioSocioeconomico formulario, Endereco endereco) throws SQLException,ClassNotFoundException{
        FormularioSocioeconomicoDAO.excluir(formulario, endereco);
    }

}
