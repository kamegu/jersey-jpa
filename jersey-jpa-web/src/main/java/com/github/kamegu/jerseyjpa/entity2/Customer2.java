package com.github.kamegu.jerseyjpa.entity2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer2 {
  @Id
  private Integer id;

  @Column
  private String kname1;

  @Column
  private String kname2;

}
