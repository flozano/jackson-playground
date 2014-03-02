package com.flozano.jacksonplayground;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind", visible = true)
@JsonSubTypes({
		@JsonSubTypes.Type(value = DomesticAnimal.class, name = "DOMESTIC"),
		@JsonSubTypes.Type(value = WildAnimal.class, name = "WILD") })
public class Animal {

}
