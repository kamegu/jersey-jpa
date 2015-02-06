package com.github.kamegu.jerseyjpa.web.resources.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.kamegu.jerseyjpa.entity.Customer;
import com.github.kamegu.jerseyjpa.entity2.Customer2;

@Path("")
public class IndexResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getText() {
    StringBuilder builder = new StringBuilder();

    builder.append(trySelect("demo", Customer.class));
    builder.append("\n");

    builder.append(trySelect("demo", Customer2.class));
    builder.append("\n");

    builder.append(trySelect("demo2", Customer.class));
    builder.append("\n");

    builder.append(trySelect("demo2", Customer2.class));
    builder.append("\n");

    return builder.toString();
  }

  private <T> String trySelect(String unitName, Class<T> entityClass) {
    String entityName = entityClass.getSimpleName();
    String prefix = "[" + unitName + "]" + entityName;
    try {
      List<T> customers = getEm(unitName).createQuery("SELECT c FROM " + entityName + " c", entityClass).getResultList();
      return prefix + " size = " + customers.size();
    } catch (Exception e) {
      e.printStackTrace();
      return prefix + " NG";
    }
  }

  private EntityManager getEm(String unitName) {
    EntityManagerFactory fac = Persistence.createEntityManagerFactory(unitName);
    return fac.createEntityManager();
  }
}
