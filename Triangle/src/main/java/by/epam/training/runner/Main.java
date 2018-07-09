package by.epam.training.runner;

import by.epam.training.triangle.Triangle;

public class Main {

	public static void main(String[] args) {
		Triangle tr = new Triangle(1.0, 2.0, 3.0);
		System.out.println(tr.checkTriangle());
		System.out.println(tr.getMessage());
		System.out.println(tr.detectTriangle());
	}
}
