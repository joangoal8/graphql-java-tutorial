package com.pets.model;

import java.util.List;

public class PetOwner {

  private String id;
  private String name;
  private List<Dog> dogs;

  private PetOwner(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.dogs = builder.dogs;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Dog> getDogs() {
    return dogs;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String id;
    private String name;
    private List<Dog> dogs;

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setDogs(List<Dog> dogs) {
      this.dogs = dogs;
      return this;
    }

    public PetOwner build() {
      return new PetOwner(this);
    }
  }

}
