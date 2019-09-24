package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import org.acme.model.entities.Todo;

import io.agroal.api.AgroalDataSource;

@ApplicationScoped
public class TodoService {

  @Inject
  EntityManager em;

  public void validate(@Valid Todo todo) {
    System.out.println("Validate Method");
  };

  @Transactional
  public void createTodo(Todo todo){
    Date now = new Date();
    todo.setCreatedAt(now);
    todo.setUpdatedAt(now);

    em.persist(todo);
  }
}