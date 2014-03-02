package com.flozano.jacksonplayground;

public class Snake extends WildAnimal {
	public String snakeName;

	public String getSnakeName() {
		return snakeName;
	}

	public Snake(String snakeName) {
		this.snakeName = snakeName;
	}
}
