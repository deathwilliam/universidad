package com.springsimplespasos.universidad.universidadbackend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UniversidadBackendApplicationTests {
	Calculadora calculadora = new Calculadora();

	@Test
	@DisplayName("Suma de valorA y valorB")
	void sumaDeValores(){
		//given
		int valorA = 2;
		int valorB = 3;
		//when
		int resultadoEsperado = calculadora.sumar(valorA, valorB);
		int expectativa = 5;
		//then
		assertThat(expectativa).isEqualTo(resultadoEsperado);
	}

	@Test
	@DisplayName("Test deprecado")
	@Disabled("Test deprecado")
	void testDesactivado(){}

	class Calculadora{
		int sumar(int valor_a, int valor_b){
			return  valor_a +  valor_b;
		}
	}


}
