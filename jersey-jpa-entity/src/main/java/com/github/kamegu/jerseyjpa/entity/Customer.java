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
}
