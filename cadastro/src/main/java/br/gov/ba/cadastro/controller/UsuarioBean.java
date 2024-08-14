package br.gov.ba.cadastro.controller;

import br.gov.ba.cadastro.dao.UsuarioDAO;
import br.gov.ba.cadastro.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private UsuarioDAO usuarioDAO;

    public UsuarioBean() {
        usuarioDAO = new UsuarioDAO();
        usuario = new Usuario(); // Inicializa o objeto Usuario
        carregarUsuarios(); // Carrega todos os usuários ao iniciar a página
    }

    /**
     * Salva um novo usuário no banco de dados.
     * Verifica a validade do e-mail e do CPF antes de salvar.
     */
    public void salvar() {
        if (!isValidEmail(usuario.getEmail())) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "O e-mail fornecido não é válido."));
            return;
        }
        if (!isValidCPF(usuario.getCpf())) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "O CPF fornecido não é válido."));
            return;
        }
        usuarioDAO.salvar(usuario);
        carregarUsuarios(); // Recarrega a lista de usuários
        usuario = new Usuario(); // Reseta o formulário após salvar
    }

    /**
     * Valida o formato do e-mail.
     *
     * @param email O e-mail a ser validado.
     * @return Verdadeiro se o e-mail for válido, falso caso contrário.
     */
    private boolean isValidEmail(String email) {
        // Validação simples do e-mail. Você pode usar uma expressão regular mais robusta se necessário.
        return email != null && email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    /**
     * Valida o formato do CPF.
     *
     * @param cpf O CPF a ser validado.
     * @return Verdadeiro se o CPF for válido, falso caso contrário.
     */
    private boolean isValidCPF(String cpf) {
        // Implementar validação de CPF aqui. Exemplo simplificado.
        return cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    public void carregarUsuarios() {
        usuarios = usuarioDAO.buscarTodos();
    }

    public void excluir(Usuario usuario) {
        usuarioDAO.excluir(usuario);
        carregarUsuarios(); // Atualiza a lista após exclusão
    }

    public void editar(Usuario usuario) {
        this.usuario = usuario;
    }

    public void detalhar(Usuario usuario) {
        this.usuario = usuario;
        // Navegar para a página de detalhes se necessário
    }

    // Getters e Setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

