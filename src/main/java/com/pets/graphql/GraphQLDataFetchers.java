package com.pets.graphql;

import com.pets.model.Dog;
import com.pets.model.DogBreed;
import com.pets.model.PetOwner;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

  private List<PetOwner> owners = new ArrayList<>();

  @PostConstruct
  public void initData() {
    String uuidHusky = "uuidDog1";
    DogBreed husky = DogBreed.builder().setName("Siberian Husky")
      .setFeatures("Independent, funny and energetic"). build();
    Dog huskyDog = Dog.builder().setId(uuidHusky)
      .setAge(2).setName("Lyanna")
      .setDogBreed(husky).build();

    String uuidMalamute = "uuidDog2";
    DogBreed malamute = DogBreed.builder().setName("Alaskan malamute")
      .setFeatures("Independent, brave and tenant").build();
    Dog malamuteDog = Dog.builder().setId(uuidMalamute).setAge(3)
      .setName("Anuk").setDogBreed(malamute).build();

    DogBreed boyeroBerna = DogBreed.builder().setName("Boyero Berna")
      .setFeatures("Giant, brave and loyal").build();
    String uuidBoyero = "uuidDog3";
    Dog boyeroBernaDog = Dog.builder().setId(uuidBoyero)
      .setAge(1).setName("Brandom").setDogBreed(boyeroBerna).build();

    owners.add(PetOwner.builder().setId("ownerUuid1").setName("ownerName1")
      .setDogs(Collections.singletonList(huskyDog)).build());

    owners.add(PetOwner.builder().setId("ownerUuid2").setName("ownerName2")
      .setDogs(Collections.singletonList(malamuteDog)).build());

    owners.add(PetOwner.builder().setId("ownerUuid3").setName("ownerName3")
      .setDogs(Collections.singletonList(boyeroBernaDog)).build());
  }

  public DataFetcher<PetOwner> getOwnerByIdDataFetcher() {
    return dataFetchingEnvironment -> {
      String ownerId = dataFetchingEnvironment.getArgument("id");
      return owners
        .stream()
        .filter(owner -> owner.getId().equals(ownerId))
        .findFirst()
        .orElse(null);
    };
  }

  public DataFetcher<Dog> getDogDataFetcher() {
    return dataFetchingEnvironment -> {
      Map<String, String> dogFetched = dataFetchingEnvironment.getSource();
      String dogName = dogFetched.get("name");
      return owners
        .stream()
        .flatMap(petOwner -> petOwner.getDogs().stream())
        .filter(dog -> dog.getName().equals(dogName))
        .findFirst()
        .orElse(null);
    };
  }

}
