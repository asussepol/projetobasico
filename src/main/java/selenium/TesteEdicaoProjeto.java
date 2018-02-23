package selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteEdicaoProjeto {

	private WebDriver driver;
	private DSLprojeto dsl;
	private CadastroPage page;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://localhost:8080/titulos");
		dsl = new DSLprojeto(driver);
		page = new CadastroPage(driver);

	}

	/* interação com a tela de edição */
	@Test
	public void testeInteragirEdicao() {

		page.clicarEditar();

		/* editar o status */
		page.setStatus("Recebido");
		page.salvar();

	}

	/* interaçao com a tela de exclusao */
	@Test
	public void testeInteracaoExcluir() {
		page.excluir();
		
		driver.switchTo().activeElement();

		

		// find the button which contains text "Yes" as we have dynamic id
		//driver.findElement(By.name("Excluir")).click();
		// page.excluirModal();

		// page.excluirModal();

	}
}
