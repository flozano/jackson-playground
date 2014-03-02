package com.flozano.jacksonplayground;

public class Dog extends DomesticAnimal {
	public String dogName;

	public String getDogName() {
		return dogName;
	}

	public Dog(String dogName) {
		this.dogName = dogName;
	}
}
