package br.gov.ba.cadastro.dao;

import br.gov.ba.cadastro.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Salva um usuário no banco de dados.
     * Utiliza uma transação para garantir a integridade dos dados.
     *
     * @param usuario O usuário a ser salvo.
     */
    public void salvar(Usuario usuario) {
        Session session = (Session) em.getDelegate();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(usuario);
        tx.commit();
    }

    /**
     * Exclui um usuário do banco de dados.
     * Utiliza uma transação para garantir a integridade dos dados.
     *
     * @param usuario O usuário a ser excluído.
     */
    public void excluir(Usuario usuario) {
        Session session = (Session) em.getDelegate();
        Transaction tx = session.beginTransaction();
        session.delete(usuario);
        tx.commit();
    }

    /**
     * Busca todos os usuários no banco de dados.
     * Utiliza uma consulta parametrizada para evitar SQL injection.
     *
     * @return A lista de todos os usuários.
     */
    public List<Usuario> buscarTodos() {
        String hql = "FROM Usuario";
        TypedQuery<Usuario> query = em.createQuery(hql, Usuario.class);
        return query.getResultList();
    }

    // Outros métodos e consultas parametrizadas
}

