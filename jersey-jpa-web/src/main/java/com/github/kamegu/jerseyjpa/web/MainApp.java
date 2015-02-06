package com.github.kamegu.jerseyjpa.web;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import com.github.kamegu.jerseyjpa.web.resources.AppConfig;

public class MainApp {
  private static final URI BASE_URI = URI.create("http://localhost:8080/jerseyjpa/");

  public static void main(String[] args) {
    try {

      final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, new AppConfig(), true);

      System.out.println(String.format("Application started.\nTry out %s%s\nHit enter to stop it...", BASE_URI, "application.wadl"));
      System.in.read();
      server.shutdownNow();
    } catch (IOException ex) {
      Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
