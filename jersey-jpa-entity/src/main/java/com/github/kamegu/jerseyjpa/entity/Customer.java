package com.github.kamegu.jerseyjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
  @Id
  private Integer id;

  @Column
  private String kname1;

  @Column
  private String kname2;

  public Customer() {
    
  }

  public Customer(int id) {
    this.id = id;
    this.kname1 = "test";
    this.kname2 = "test" + id;
  }
}
