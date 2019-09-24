package org.acme.service;

public interface Service<T> {
  public void validate(T entity);
}