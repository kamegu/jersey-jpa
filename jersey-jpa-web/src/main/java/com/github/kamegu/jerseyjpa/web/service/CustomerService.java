package com.github.kamegu.jerseyjpa.web.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.kamegu.jerseyjpa.entity.Customer;

@ApplicationScoped
public class CustomerService {
  @Inject
  private EntityManager em;

  public int size() {
    em.getTransaction().begin();
    List<Customer> customers = em.createQuery("select c from Customer c", Customer.class).getResultList();
    Customer customer = new Customer(customers.size() + 1);
    em.persist(customer);
    em.flush();
    em.getTransaction().commit();
    return customers.size();
  }
}
