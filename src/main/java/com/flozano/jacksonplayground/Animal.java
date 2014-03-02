package com.flozano.jacksonplayground;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class Animal {

	/** Domestic animals **/

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "behaves", visible = true)
	@JsonSubTypes({ @JsonSubTypes.Type(value = Dog.class, name = "NICE"),
			@JsonSubTypes.Type(value = Cat.class, name = "NASTY") })
	public static class DomesticAnimal /*extends Animal*/ {

	}

	public static class Dog extends DomesticAnimal {
		public String dogName;

		public String getDogName() {
			return dogName;
		}

		public Dog(String dogName) {
			this.dogName = dogName;
		}
	}

	public static class Cat extends DomesticAnimal {
		public String catName;

		public String getCatName() {
			return catName;
		}

		public Cat(String catName) {
			this.catName = catName;
		}

	}

	/** Wild animals **/
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "behaves", visible = true)
	@JsonSubTypes({ @JsonSubTypes.Type(value = Kangaroo.class, name = "NICE"),
			@JsonSubTypes.Type(value = Snake.class, name = "NASTY") })
	public static class WildAnimal /*extends Animal*/ {

	}

	public static class Snake extends WildAnimal {
		public String snakeName;

		public String getSnakeName() {
			return snakeName;
		}

		public Snake(String snakeName) {
			this.snakeName = snakeName;
		}

	}

	public static class Kangaroo extends WildAnimal {
		public String kangarooName;

		public String getKangarooName() {
			return kangarooName;
		}

		public Kangaroo(String kangarooName) {
			this.kangarooName = kangarooName;
		}

	}
}
