package by.epam.training.triangle;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeTriangleTest {

	Triangle triangle;

	private String message1 = "a<=0";
	private String message2 = "b<=0";
	private String message3 = "c<=0";
	private String message4 = "a+b<=c";
	private String message5 = "a+c<=b";
	private String message6 = "b+c<=a";

	public static final double MAX_VALUE = 1.7976931348623157E308;

	@DataProvider(name = "negativeInputDataProvider") // Использование нулевых и отрицательных значений в качестве параметров, а также несоблюдение основных свойств треугольника
	public Object[][] createIncorrectData() {
		return new Object[][] { { new Double(0), new Double(0), new Double(0), message1 },
				{ new Double(0), new Double(3.0), new Double(2.0), message1 },
				{ new Double(3.0), new Double(0), new Double(2.0), message2 },
				{ new Double(2.0), new Double(3.0), new Double(0), message3 },
				{ new Double(-1), new Double(2.0), new Double(2.0), message1 },
				{ new Double(2.0), new Double(-1), new Double(2.0), message2 },
				{ new Double(2.0), new Double(2.0), new Double(-1), message3 },
				{ new Double(4.0), new Double(2.0), new Double(7.0), message4 },
				{ new Double(4.0), new Double(7.0), new Double(2.0), message5 },
				{ new Double(7.0), new Double(2.0), new Double(4.0), message6 } };
	}

	@DataProvider(name = "getIllegalSquareDataProvider")
	public Object[][] createIllegalGetSquareData() {
		return new Object[][] { { new Double(1.0), new Double(2.0), new Double(3.0) },
				{ new Double(-2.0), new Double(2.0), new Double(3.0) } };
	}

	@Test(dataProvider = "negativeInputDataProvider") // Проверка метода checkTriangle с некорректными параметрами
	public void negativeInputTest(double a, double b, double c, String message) {
		this.triangle = new Triangle(a, b, c);
		Assert.assertEquals(triangle.checkTriangle(), false);
		Assert.assertEquals(triangle.getMessage(), message);
	}

	@Test(dataProvider = "getIllegalSquareDataProvider") //Программа высчитывает площадь у несуществующего треугольника
	public void getSquareOfIllegalTriangle(double a, double b, double c) {
		double expectedSquare = 0;
		this.triangle = new Triangle(a, b, c);
		Assert.assertEquals(triangle.getSquare(), 0, 0.0001);
	}

	@Test(expectedExceptions = ArithmeticException.class) //Получение в качестве площади бесконечности
	public void infinitySquareTest() throws ArithmeticException {
		this.triangle = new Triangle(MAX_VALUE, MAX_VALUE, MAX_VALUE);
		triangle.getSquare();
	}

	@Test
	public void zeroSidesTriangle() {
		Assert.fail("The program doesn't provide case for processing zero values");
	}

	@Test
	public void illegalArgumentsTriangle() {
		Assert.fail("The program doesn't provide case for processing not numbers");
	}

}
