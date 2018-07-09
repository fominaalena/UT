package by.epam.training.triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveTriangleTest {

	Triangle triangle;

	final int TR_EQUILATERAL = 1; // равносторонний
	final int TR_ISOSCELES = 2; // равнобедренный
	final int TR_ORDYNARY = 4; // обычный
	final int TR_RECTANGULAR = 8; // прямоугольный

	@DataProvider(name = "checkDataProvider")
	public Object[][] createDataCheckTriangle() {
		return new Object[][] { { new Double(2.0), new Double(2.0), new Double(3.0) } };
	}

	@DataProvider(name = "detectDataProvider")
	public Object[][] createDataDetectTriangle() {
		return new Object[][] { { new Double(2.0), new Double(2.0), new Double(2.0), new Integer(1) + new Integer(2) },
				{ new Double(2.0), new Double(3.0), new Double(2.0), new Integer(2) },
				{ new Double(3.0), new Double(2.0), new Double(2.0), new Integer(2) },
				{ new Double(2.0), new Double(2.0), new Double(3.0), new Integer(2) },
				{ new Double(2.0), new Double(1.5), new Double(3.0), new Integer(4) },
				{ new Double(3.0), new Double(4.0), new Double(5.0), new Integer(8) },
				{ new Double(5.0), new Double(4.0), new Double(3.0), new Integer(8) },
				{ new Double(4.0), new Double(5.0), new Double(3.0), new Integer(8) },
				{ new Double(7e34), new Double(1.35), new Double(7e34), new Integer(2) }, };
	}

	@DataProvider(name = "getSquareDataProvider")
	public Object[][] createDataGetSquare() {
		return new Object[][] { { new Double(2.5), new Double(2.0), new Double(3.1), new Double(2.4948) } };
	}

	@Test(dataProvider = "checkDataProvider") // Проверка метода checkTriangle с корректными параметрами
	public void CheckTriangleTest(double a, double b, double c) {
		Triangle triangle = new Triangle(a, b, c);
		Assert.assertEquals(triangle.checkTriangle(), true);
	}

	@Test(dataProvider = "detectDataProvider") // Проверка метода detectTriangle с корректными параметрами
	public void detectTriangleTest(double a, double b, double c, int type) {
		Triangle triangle = new Triangle(a, b, c);
		Assert.assertEquals(triangle.detectTriangle(), type);
	}

	@Test(dataProvider = "getSquareDataProvider") // Проверка вычисления площади с корректными параметрами
	public void getTriangleSquare(double a, double b, double c, double result) {
		Assert.assertEquals(triangle.getSquare(), result, 0.001);
	}
}
