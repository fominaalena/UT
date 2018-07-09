package by.epam.training.runner;

import by.epam.training.triangle.Triangle;

public class Main {

	public static void main(String[] args) {
		Triangle tr = new Triangle(1, 2, 3);
		System.out.println(tr.checkTriangle());
		System.out.println(tr.getMessage());
		System.out.println(tr.detectTriangle());
	}
}
