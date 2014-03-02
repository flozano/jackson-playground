package com.flozano.jacksonplayground;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HierTest {

	// quite silly data model...
	final Kangaroo kangaroo = new Kangaroo("Bob");
	final Snake snake = new Snake("Lisa");
	final Dog dog = new Dog("Maria");
	final Cat cat = new Cat("Esther");

	ObjectMapper mapper;

	Set<String> validValuesForKind = new HashSet<String>(
			Arrays.<String> asList("WILD", "DOMESTIC"));
	Set<String> validValuesForBehaves = new HashSet<String>(
			Arrays.<String> asList("NICE", "NASTY"));

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
		JSONArray arr = new JSONArray(mapper.writeValueAsString(Arrays
				.<Animal> asList(snake, kangaroo, dog, cat)));
		System.err.println(arr);
		for (int i = 0; i < arr.length(); i++) {
			assertNotNull(arr.getJSONObject(i).optString("behaves", null));
			assertNotNull(arr.getJSONObject(i).optString("kind", null));

			assertTrue(validValuesForBehaves.contains(arr.getJSONObject(i)
					.getString("behaves")));
			assertTrue(validValuesForKind.contains(arr.getJSONObject(i)
					.getString("kind")));
		}
	}

	@Test
	public void testSerializationInPlainCollectionWithHelp()
			throws JSONException, JsonProcessingException {
		JSONArray arr = new JSONArray(mapper.writerWithType(
				mapper.getTypeFactory().constructCollectionType(List.class,
						Animal.class)).writeValueAsString(
				Arrays.<Animal> asList(snake, kangaroo, dog, cat)));
		System.err.println(arr);
		// Weird result:
		// [{"snakeName":"Lisa","kind":"NASTY"},{"kangarooName":"Bob","kind":"NICE"},{"dogName":"Maria","kind":"NICE"},{"catName":"Esther","kind":"NASTY"}]
		// "kind" is filled with values for "behaves" :?
		for (int i = 0; i < arr.length(); i++) {
			assertNotNull(arr.getJSONObject(i).optString("behaves", null));
			assertNotNull(arr.getJSONObject(i).optString("kind", null));

			assertTrue(validValuesForBehaves.contains(arr.getJSONObject(i)
					.getString("behaves")));
			assertTrue(validValuesForKind.contains(arr.getJSONObject(i)
					.getString("kind")));
		}
	}
}
