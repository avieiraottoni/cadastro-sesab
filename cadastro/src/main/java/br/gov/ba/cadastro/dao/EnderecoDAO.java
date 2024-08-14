package br.gov.ba.cadastro.dao;

import br.gov.ba.cadastro.model.Endereco;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Classe responsável por realizar operações de persistência para a entidade Endereco.
 */
public class EnderecoDAO {

    /**
     * Salva um novo endereço ou atualiza um endereço existente no banco de dados.
     * 
     * @param endereco O endereço a ser salvo ou atualizado.
     */
    public void salvar(Endereco endereco) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(endereco);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Busca todos os endereços no banco de dados.
     * 
     * @return Uma lista de todos os endereços.
     */
    public List<Endereco> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Endereco> cq = cb.createQuery(Endereco.class);
            Root<Endereco> root = cq.from(Endereco.class);
            cq.select(root);
            Query<Endereco> query = session.createQuery(cq);
            return query.getResultList();
        }
    }

    /**
     * Busca um endereço pelo seu identificador.
     * 
     * @param id O identificador do endereço a ser buscado.
     * @return O endereço correspondente ao identificador fornecido, ou null se não encontrado.
     */
    public Endereco buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Endereco.class, id);
        }
    }
}
