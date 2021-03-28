package com.pets.model;

public class DogBreed {

  private final String name;
  private final String features;

  private DogBreed(Builder builder) {
    this.name = builder.name;
    this.features = builder.features;
  }

  public String getName() {
    return name;
  }

  public String getFeatures() {
    return features;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String name;
    private String features;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setFeatures(String features) {
      this.features = features;
      return this;
    }

    public DogBreed build() {
      return new DogBreed(this);
    }
  }
}
