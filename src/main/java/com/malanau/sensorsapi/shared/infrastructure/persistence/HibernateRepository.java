package com.malanau.sensorsapi.shared.infrastructure.persistence;

import com.malanau.sensorsapi.shared.domain.UUIDIdentifier;

import jakarta.persistence.criteria.CriteriaQuery;

import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;

    public HibernateRepository(final SessionFactory sessionFactory, final Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist(final T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected Optional<T> byId(final UUIDIdentifier id) {
        return Optional.ofNullable(
                sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    protected List<T> all() {
        final CriteriaQuery<T> criteria =
                sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);
        criteria.from(aggregateClass);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }
}
