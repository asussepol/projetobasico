package selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;





public class TesteCadastroProjeto {
	
	private WebDriver driver;
	private DSLprojeto dsl;
	private CadastroPage page;
	
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		// driver.manage().window().setSize(new Dimension(1200,765));
		driver.manage().window().maximize();

		 driver.get("http://localhost:8080/titulos/novo");
		dsl = new DSLprojeto(driver);
		page = new CadastroPage(driver);

	}
	
	/* interagir com o cadastro*/
	
	@Test
	public void interagirComTelaCadastro(){
		
		page.setDescricao("pagamento");
		
		Assert.assertEquals("pagamento",page.retornaNome());
		
		page.setDataVencimento("22/03/2018");
		Assert.assertEquals("22/03/2018",page.retornaData());
		page.setValor("234");
		Assert.assertEquals("234",page.retornaValor());
		page.setStatus("Recebido");
		page.salvar();
		
		
	}
	
	/*caixa de mensagens*/
	
	
	
	
	

}
