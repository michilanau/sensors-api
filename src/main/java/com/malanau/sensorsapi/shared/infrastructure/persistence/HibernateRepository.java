package com.malanau.sensorsapi.shared.infrastructure.persistence;

import com.malanau.sensorsapi.shared.domain.UUIDIdentifier;

import org.hibernate.SessionFactory;

import java.util.Optional;

public abstract class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;

    public HibernateRepository(final SessionFactory sessionFactory, final Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist(final T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    protected Optional<T> byId(final UUIDIdentifier id) {
        return Optional.ofNullable(
                sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }
}
