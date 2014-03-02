package com.flozano.jacksonplayground;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flozano.jacksonplayground.Animal.Cat;
import com.flozano.jacksonplayground.Animal.Dog;
import com.flozano.jacksonplayground.Animal.Kangaroo;
import com.flozano.jacksonplayground.Animal.Snake;

public class HierTest {
	// quite silly data model...
	final Kangaroo kangaroo = new Kangaroo("Bob");
	final Snake snake = new Snake("Lisa");
	final Dog dog = new Dog("Maria");
	final Cat cat = new Cat("Esther");

	ObjectMapper mapper;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();
	}

	@Test
	public void testSerializationOneByOne() throws JsonProcessingException {
		JSONObject obj = new JSONObject(mapper.writeValueAsString(snake));
		System.err.println(obj);
		assertEquals(snake.getSnakeName(), obj.getString("snakeName"));
		assertEquals("NASTY", obj.getString("behaves"));
	}

	@Test
	public void testSerializationInPlainCollection() throws JSONException,
			JsonProcessingException {
		JSONArray arr = new JSONArray(mapper.writeValueAsString(Arrays.asList(
				snake, kangaroo, dog, cat)));
		System.err.println(arr);
		for (int i = 0; i < arr.length(); i++) {
			assertNotNull(arr.getJSONObject(i).optString("behaves", null));
		}
	}

	@Test
	public void testSerializationInPlainCollectionWithHelp()
			throws JSONException, JsonProcessingException {
		JSONArray arr = new JSONArray(mapper.writerWithType(
				mapper.getTypeFactory().constructCollectionType(List.class,
						Object.class)).writeValueAsString(
				Arrays.asList(snake, kangaroo, dog, cat)));
		System.err.println(arr);
		for (int i = 0; i < arr.length(); i++) {
			assertNotNull(arr.getJSONObject(i).optString("behaves", null));
		}
	}
}
