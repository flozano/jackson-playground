package com.flozano.jacksonplayground;

public class Cat extends DomesticAnimal {
	public String catName;

	public String getCatName() {
		return catName;
	}

	public Cat(String catName) {
		this.catName = catName;
	}

}