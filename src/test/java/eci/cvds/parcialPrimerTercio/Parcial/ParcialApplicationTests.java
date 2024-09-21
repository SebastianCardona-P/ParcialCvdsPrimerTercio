package eci.cvds.parcialPrimerTercio.Parcial;

import eci.cvds.parcialPrimerTercio.Parcial.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ParcialApplicationTests {

	private ProductService productService;

	@Test
	void applicationStartsSuccessfully() {
		ParcialApplication.main(new String[] {});
	}

	@Test
	void applicationFailsToStartWithInvalidArgs() {
		assertThrows(Exception.class, () -> {
			ParcialApplication.main(new String[] {"invalidArg"});
		});
	}

}
