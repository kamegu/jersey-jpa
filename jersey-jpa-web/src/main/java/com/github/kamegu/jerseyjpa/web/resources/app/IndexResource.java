package com.github.kamegu.jerseyjpa.web.resources.app;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.kamegu.jerseyjpa.web.service.CustomerService;

@RequestScoped
@Path("")
public class IndexResource {

  @Inject
  private CustomerService service;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getText() {
    return "size = " + service.size();
  }
}
