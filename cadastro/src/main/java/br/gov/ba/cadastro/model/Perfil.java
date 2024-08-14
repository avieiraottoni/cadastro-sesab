package br.gov.ba.cadastro.model;

import java.util.List;
import java.util.Objects;

public class Perfil {

    // Atributos da classe Perfil
    private Long id; // Identificador único do perfil
    private String nome; // Nome do perfil
    private List<Usuario> usuarios; // Associação 1 para N com Usuario

    /** Construtor padrão */
    public Perfil() {
    }

    /**
     * Construtor com parâmetros
     * @param id Identificador do perfil
     * @param nome Nome do perfil
     * @param usuarios Lista de usuários associados ao perfil
     */
    public Perfil(Long id, String nome, List<Usuario> usuarios) {
        this.id = id;
        this.nome = nome;
        this.usuarios = usuarios;
    }

    /** @return o ID do perfil */
    public Long getId() {
        return id;
    }

    /** Define o ID do perfil
     * @param id Novo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return o nome do perfil */
    public String getNome() {
        return nome;
    }

    /** Define o nome do perfil
     * @param nome Novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return a lista de usuários associados ao perfil */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /** Define a lista de usuários associados ao perfil
     * @param usuarios Nova lista de usuários
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Adiciona um usuário à lista de usuários do perfil e garante que a associação
     * seja estabelecida nos dois lados da relação.
     * @param usuario Usuário a ser adicionado
     */
    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        usuario.setPerfil(this);
    }

    /**
     * Remove um usuário da lista de usuários do perfil e garante que a associação
     * seja removida nos dois lados da relação.
     * @param usuario Usuário a ser removido
     */
    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
        usuario.setPerfil(null);
    }

    /** @return uma representação textual do objeto Perfil */
    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    /** Verifica se dois objetos Perfil são iguais
     * @param o Objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id);
    }

    /** @return o código hash para o objeto Perfil */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
