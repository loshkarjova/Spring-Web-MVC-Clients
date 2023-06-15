package org.example.app.repositories;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.app.entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClientRepositoryImpl implements ClientRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public List<Client> getClients() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> root = cq.from(Client.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();

    }

    public void saveClient(Client client) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(client);
    }

    public Client getClient(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Client.class, id);
    }

    public void deleteClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.byId(Client.class).load(id);
        session.remove(client);
    }
}
