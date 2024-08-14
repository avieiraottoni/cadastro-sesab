package br.gov.ba.cadastro.controller;

import br.gov.ba.cadastro.dao.EnderecoDAO;
import br.gov.ba.cadastro.model.Endereco;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Managed Bean para gerenciar operações de Endereco.
 */
@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Endereco endereco = new Endereco();
    private List<Endereco> enderecos;
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    /**
     * Salva o endereço atual no banco de dados.
     */
    public void salvar() {
        enderecoDAO.salvar(endereco);
        endereco = new Endereco(); // Limpa o formulário após salvar
        buscarTodos();
    }

    /**
     * Busca todos os endereços no banco de dados.
     */
    public void buscarTodos() {
        enderecos = enderecoDAO.buscarTodos();
    }

    /**
     * Busca um endereço pelo seu identificador.
     * 
     * @param id O identificador do endereço a ser buscado.
     */
    public void buscarPorId(Long id) {
        endereco = enderecoDAO.buscarPorId(id);
    }

    // Getters e Setters

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
