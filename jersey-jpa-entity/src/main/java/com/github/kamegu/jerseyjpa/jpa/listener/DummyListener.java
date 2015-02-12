package com.github.kamegu.jerseyjpa.jpa.listener;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.EntityManager;
import javax.persistence.PrePersist;

import com.github.kamegu.jerseyjpa.entity.Customer;

@ApplicationScoped
public class DummyListener {

  @PrePersist
  public void prePresist(Object o) {
    Instance<EntityManager> e = CDI.current().select(EntityManager.class);
    EntityManager em = e.get();

    List<Customer> r = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    System.out.println(r.size());
  }
}
