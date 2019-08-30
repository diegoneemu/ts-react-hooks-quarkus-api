package org.acme.model.entities;

import java.util.Date;
import java.util.Objects;

public class Todo {
  private int id;
  private String text;
  private boolean complete;
  private boolean delete;
  private Date createdAt;
  private Date updatedAt;

  public Todo() {

  }

  public Todo(int id, String text, boolean complete, boolean delete, Date createdAt, Date updatedAt) {
    this.id = id;
    this.text = text;
    this.complete = complete;
    this.delete = delete;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isComplete() {
    return this.complete;
  }

  public boolean getComplete() {
    return this.complete;
  }

  public void setComplete(boolean complete) {
    this.complete = complete;
  }

  public boolean isDelete() {
    return this.delete;
  }

  public boolean getDelete() {
    return this.delete;
  }

  public void setDelete(boolean delete) {
    this.delete = delete;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Todo id(int id) {
    this.id = id;
    return this;
  }

  public Todo text(String text) {
    this.text = text;
    return this;
  }

  public Todo complete(boolean complete) {
    this.complete = complete;
    return this;
  }

  public Todo delete(boolean delete) {
    this.delete = delete;
    return this;
  }

  public Todo createdAt(Date createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Todo updatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Todo)) {
      return false;
    }
    Todo todo = (Todo) o;
    return id == todo.id && Objects.equals(text, todo.text) && complete == todo.complete && delete == todo.delete
        && Objects.equals(createdAt, todo.createdAt) && Objects.equals(updatedAt, todo.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, complete, delete, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", text='" + getText() + "'" + ", complete='" + isComplete() + "'"
        + ", delete='" + isDelete() + "'" + ", createdAt='" + getCreatedAt() + "'" + ", updatedAt='" + getUpdatedAt()
        + "'" + "}";
  }

}