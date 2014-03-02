package com.flozano.jacksonplayground;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/** Wild animals **/
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "behaves", visible = true)
@JsonSubTypes({ @JsonSubTypes.Type(value = Kangaroo.class, name = "NICE"),
		@JsonSubTypes.Type(value = Snake.class, name = "NASTY") })
public class WildAnimal extends Animal {

}
