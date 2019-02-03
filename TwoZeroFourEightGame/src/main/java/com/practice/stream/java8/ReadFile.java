package com.practice.stream.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		Files.lines(Paths.get("C:\\Users\\Shivam\\eclipse-workspace\\TwoZeroFourEightGame\\pom.xml"))
				.filter(name -> name.contains("groupId"))
				.map(line -> line.replace("<groupId>", " ").replaceAll("</groupId>", " ").trim()).forEach(System.out::println);
	}
}
