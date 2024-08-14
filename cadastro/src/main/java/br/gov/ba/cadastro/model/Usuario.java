package br.gov.ba.cadastro.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class Usuario {

    // Atributos da classe Usuario
    private Long id; // Identificador único do usuário
    private String nome; // Nome do usuário
    private String email; // Email do usuário
    private String cpf; // CPF do usuário
    private Perfil perfil; // Associação 1 para 1 com Perfil
    private List<Endereco> enderecos; // Associação N para N com Endereco
    private LocalDate dataCadastro; // Data do cadastro

    /** Construtor padrão */
    public Usuario() {
    }

    /**
     * Construtor com parâmetros
     * @param id Identificador do usuário
     * @param nome Nome do usuário
     * @param email Email do usuário
     * @param cpf CPF do usuário
     * @param perfil Perfil associado ao usuário
     * @param enderecos Lista de endereços associados ao usuário
     * @param dataCadastro Data do cadastro do usuário
     */
    public Usuario(Long id, String nome, String email, String cpf, Perfil perfil, List<Endereco> enderecos, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.perfil = perfil;
        this.enderecos = enderecos;
        this.dataCadastro = dataCadastro;
    }

    /** @return o ID do usuário */
    public Long getId() {
        return id;
    }

    /** Define o ID do usuário
     * @param id Novo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return o nome do usuário */
    public String getNome() {
        return nome;
    }

    /** Define o nome do usuário
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return o email do usuário */
    public String getEmail() {
        return email;
    }

    /** Define o email do usuário
     * @param email Novo email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return o CPF do usuário */
    public String getCpf() {
        return cpf;
    }

    /** Define o CPF do usuário
     * @param cpf Novo CPF
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /** @return o perfil associado ao usuário */
    public Perfil getPerfil() {
        return perfil;
    }

    /** Define o perfil associado ao usuário
     * @param perfil Novo perfil
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /** @return a lista de endereços associados ao usuário */
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    /** Define a lista de endereços associados ao usuário
     * @param enderecos Nova lista de endereços
     */
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /** @return a data de cadastro do usuário no formato DD/MM/ANOS */
    public String getDataCadastro() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataCadastro.format(formatter);
    }

    /** Define a data de cadastro do usuário
     * @param dataCadastro Nova data de cadastro
     */
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /** Adiciona um endereço à lista de endereços do usuário
     * @param endereco Endereço a ser adicionado
     */
    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
        endereco.getUsuarios().add(this);
    }

    /** Remove um endereço da lista de endereços do usuário
     * @param endereco Endereço a ser removido
     */
    public void removeEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
        endereco.getUsuarios().remove(this);
    }

    /** @return uma representação textual do objeto Usuario */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", perfil=" + perfil +
                ", dataCadastro=" + getDataCadastro() +
                '}';
    }

    /** Verifica se dois objetos Usuario são iguais
     * @param o Objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(cpf, usuario.cpf);
    }

    /** @return o código hash para o objeto Usuario */
    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}

