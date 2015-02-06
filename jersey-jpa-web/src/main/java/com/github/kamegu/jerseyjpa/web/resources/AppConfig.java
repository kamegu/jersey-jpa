package com.github.kamegu.jerseyjpa.web.resources;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("")
public class AppConfig extends ResourceConfig {
  public AppConfig() {
    packages(false, this.getClass().getPackage().getName() + ".app");
  }
}
