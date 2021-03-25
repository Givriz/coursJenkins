package fr.givrix.coursJenkins;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
class CalculsTest {

	Calculs c = null;
	/*
	Calculs c2 = null;
	Calculs c3 = null;
	*/
	
	@BeforeEach
	public void initTest()
	{
		c = new Calculs(10,0);
		/*
		c2 = new Calculs(55,2);
		c3 = new Calculs(60,10);
		*/
	}
	

	 static Stream<Arguments> chargerJeuDeTestAdditionner() throws Throwable
	 {
		// Eventuellement : lire ces informations de tests depuis un fichier
		 
		 return Stream.of(
				 	Arguments.of(5, 10, 15),
				 	Arguments.of(55, 2, 57),
				 	Arguments.of(110, 120, 230),
				 	Arguments.of(60, 10, 70)
				 );
	 }

	 static Stream<Arguments> chargerJeuDeTestSoustraire() throws Throwable
	 {
		// Eventuellement : lire ces informations de tests depuis un fichier
		 
		 return Stream.of(
				 	Arguments.of(5, 10, -5),
				 	Arguments.of(55, 2, 53),
				 	Arguments.of(110, 120, -10),
				 	Arguments.of(60, 10, 50)
				 );
	 }

	 static Stream<Arguments> chargerJeuDeTestMultiplier() throws Throwable
	 {
		// Eventuellement : lire ces informations de tests depuis un fichier
		 
		 return Stream.of(
				 	Arguments.of(5, 10, 50),
				 	Arguments.of(55, 2, 110),
				 	Arguments.of(110, 120, 13200),
				 	Arguments.of(60, 10, 600)
				 );
	 }
	
	
	 // testAdditionner(5,10);
	 // testAdditionner(55,2);
	 // testAdditionner(60,10);
	@ParameterizedTest(name="Test de l'addition nÂ°{index} : on additionne {0} + {1} et on vÃ©rifie que le rÃ©sultat est {2}")
	@MethodSource("chargerJeuDeTestAdditionner")
	public void testAdditionner(int firstParam, int secondParam, int expectedResult) 
	{
		Calculs c = new Calculs(firstParam, secondParam);
		assertEquals(c.additionner(), expectedResult, "Test additionner en erreur, rÃ©sultat attendu : " + expectedResult);

		/*
		assertEquals(c.additionner(), 15, "Test additionner en erreur, rÃ©sultat attendu : 50");
		assertEquals(c2.additionner(), 57, "Test additionner en erreur, rÃ©sultat attendu : 57");
		assertEquals(c3.additionner(), 70, "Test additionner en erreur, rÃ©sultat attendu : 70");
		*/
	}

		
	@Test
	public void testDiviser() 
	{
		assertThrows(ArithmeticException.class, ()-> 
		{
			c.diviser();
		} ); // c.diviser est censÃ© Throw ArithmeticException puisque division par zÃ©ro
	}
	
	@ParameterizedTest(name="Test de la soustraction nÂ°{index} : on soustrait {0} - {1} et on vÃ©rifie que le rÃ©sultat est {2}")
	@MethodSource("chargerJeuDeTestSoustraire")
	public void testSoustraire(int firstParam, int secondParam, int expectedResult)
	{
		Calculs c = new Calculs(firstParam, secondParam);
		assertEquals(c.soustraire(), expectedResult, "Test soustraire en erreur, rÃ©sultat attendu : " + expectedResult);		
	}
	
	@ParameterizedTest(name="Test de la multiplication nÂ°{index} : on multiplie {0} x {1} et on vÃ©rifie que le rÃ©sultat est {2}")
	@MethodSource("chargerJeuDeTestMultiplier")
	public void testMultiplier(int firstParam, int secondParam, int expectedResult)
	{
		Calculs c = new Calculs(firstParam, secondParam);
		assertEquals(c.multiplier(), expectedResult, "Test multiplier en erreur, rÃ©sultat attendu : " + expectedResult);		
	}
	
	
}