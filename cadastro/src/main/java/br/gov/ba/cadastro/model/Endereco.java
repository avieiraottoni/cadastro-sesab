package br.gov.ba.cadastro.model;

import java.util.List;
import java.util.Objects;

public class Endereco {

    // Atributos da classe Endereco
    private Long id; // Identificador único do endereço
    private String logradouro; // Logradouro do endereço
    private String numero; // Número do endereço
    private String complemento; // Complemento do endereço
    private String bairro; // Bairro do endereço
    private String cidade; // Cidade do endereço
    private String estado; // Estado do endereço
    private String cep; // CEP do endereço
    private List<Usuario> usuarios; // Associação N para N com Usuario

    /** Construtor padrão */
    public Endereco() {
    }

    /**
     * Construtor com parâmetros
     * @param id Identificador do endereço
     * @param logradouro Logradouro do endereço
     * @param numero Número do endereço
     * @param complemento Complemento do endereço
     * @param bairro Bairro do endereço
     * @param cidade Cidade do endereço
     * @param estado Estado do endereço
     * @param cep CEP do endereço
     * @param usuarios Lista de usuários associados ao endereço
     */
    public Endereco(Long id, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep, List<Usuario> usuarios) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.usuarios = usuarios;
    }

    /** @return o ID do endereço */
    public Long getId() {
        return id;
    }

    /** Define o ID do endereço
     * @param id Novo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return o logradouro do endereço */
    public String getLogradouro() {
        return logradouro;
    }

    /** Define o logradouro do endereço
     * @param logradouro Novo logradouro
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /** @return o número do endereço */
    public String getNumero() {
        return numero;
    }

    /** Define o número do endereço
     * @param numero Novo número
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /** @return o complemento do endereço */
    public String getComplemento() {
        return complemento;
    }

    /** Define o complemento do endereço
     * @param complemento Novo complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /** @return o bairro do endereço */
    public String getBairro() {
        return bairro;
    }

    /** Define o bairro do endereço
     * @param bairro Novo bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /** @return a cidade do endereço */
    public String getCidade() {
        return cidade;
    }

    /** Define a cidade do endereço
     * @param cidade Nova cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /** @return o estado do endereço */
    public String getEstado() {
        return estado;
    }

    /** Define o estado do endereço
     * @param estado Novo estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /** @return o CEP do endereço */
    public String getCep() {
        return cep;
    }

    /** Define o CEP do endereço
     * @param cep Novo CEP
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /** @return a lista de usuários associados ao endereço */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /** Define a lista de usuários associados ao endereço
     * @param usuarios Nova lista de usuários
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Adiciona um usuário à lista de usuários do endereço e garante que a associação
     * seja estabelecida nos dois lados da relação.
     * @param usuario Usuário a ser adicionado
     */
    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.getEnderecos().add(this);
    }

    /**
     * Remove um usuário da lista de usuários do endereço e garante que a associação
     * seja removida nos dois lados da relação.
     * @param usuario Usuário a ser removido
     */
    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
        usuario.getEnderecos().remove(this);
    }

    /** @return uma representação textual do objeto Endereco */
    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    /** Verifica se dois objetos Endereco são iguais
     * @param o Objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    /** @return o código hash para o objeto Endereco */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}