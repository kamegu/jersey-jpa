package com.github.kamegu.jerseyjpa.common;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

  @Produces
  @RequestScoped
  public EntityManager create() {
    EntityManagerFactory fac = Persistence.createEntityManagerFactory("demo");
    return fac.createEntityManager();
  }

  protected void closeEntityManager(@Disposes EntityManager entityManager) {
    if (entityManager.isOpen()) {
      entityManager.close();
    }
  }
}
