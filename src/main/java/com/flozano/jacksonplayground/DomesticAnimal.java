package com.flozano.jacksonplayground;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "behaves", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = Dog.class, name = "NICE"),
		@JsonSubTypes.Type(value = Cat.class, name = "NASTY") })
public class DomesticAnimal extends Animal {

}
