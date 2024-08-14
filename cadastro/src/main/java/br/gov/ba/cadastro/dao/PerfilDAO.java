package br.gov.ba.cadastro.dao;

import br.gov.ba.cadastro.model.Perfil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Classe responsável por realizar operações de persistência para a entidade Perfil.
 */
public class PerfilDAO {

    /**
     * Salva um novo perfil ou atualiza um perfil existente no banco de dados.
     * 
     * @param perfil O perfil a ser salvo ou atualizado.
     */
    public void salvar(Perfil perfil) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(perfil);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Busca todos os perfis no banco de dados.
     * 
     * @return Uma lista de todos os perfis.
     */
    public List<Perfil> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Perfil> cq = cb.createQuery(Perfil.class);
            Root<Perfil> root = cq.from(Perfil.class);
            cq.select(root);
            Query<Perfil> query = session.createQuery(cq);
            return query.getResultList();
        }
    }

    /**
     * Busca um perfil pelo seu identificador.
     * 
     * @param id O identificador do perfil a ser buscado.
     * @return O perfil correspondente ao identificador fornecido, ou null se não encontrado.
     */
    public Perfil buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Perfil.class, id);
        }
    }
}
