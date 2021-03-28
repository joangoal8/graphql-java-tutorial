package com.pets.model;

public class Dog {

  private final String id;
  private final String name;
  private final int age;
  private final DogBreed dogBreed;

  private Dog(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.age = builder.age;
    this.dogBreed = builder.dogBreed;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public DogBreed getDogBreed() {
    return dogBreed;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String id;
    private String name;
    private int age;
    private DogBreed dogBreed;

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setDogBreed(DogBreed dogBreed) {
      this.dogBreed = dogBreed;
      return this;
    }

    public Dog build() {
      return new Dog(this);
    }
  }

}
