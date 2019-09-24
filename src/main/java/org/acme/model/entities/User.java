package org.acme.model.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: criar estrutura JPA com MySQL

@Entity
public class User {
  private int id;
  private String name;
  private String email;
  private String lng;
  private String permission;
  private boolean active;

  public User() {
  }

  public User(int id, String name, String email, String lng, String permission) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.lng = lng;
    this.permission = permission;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "giftSeq")
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLng() {
    return this.lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public String getPermission() {
    return this.permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public boolean isActive() {
    return this.active;
  }

  public void activate() {
    this.active = !this.active;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return id == user.id && Objects.equals(name, user.getName()) && Objects.equals(email, user.getEmail())
        && Objects.equals(lng, user.getLng()) && Objects.equals(permission, user.getPermission())
        && Objects.equals(active, user.isActive());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, lng, permission, active);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", email='" + getEmail() + "'" + ", lng='"
        + getLng() + "'" + ", permission='" + getPermission() + "'" + "isActive" + isActive() + "}";
  }
}
