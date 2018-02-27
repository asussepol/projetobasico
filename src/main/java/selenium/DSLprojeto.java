package selenium;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;





public class DSLprojeto {

	private WebDriver driver;

	public DSLprojeto(WebDriver driver) {

		this.driver = driver;
	}

	/********* TextField e TextArea ************/

	public void escrever(By by, String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}
	
	public void escreverNumero(By by,String texto) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}

	public void escrever(String id_elemento, String texto) {

		driver.findElement(By.id(id_elemento)).sendKeys(texto);
	}

	public String retornaValor(String id_elemento) {

		return driver.findElement(By.id(id_elemento)).getAttribute("value");
	}

	/********* Radio e Check ************/

	public void clicarRadio(String id_elemento) {
		driver.findElement(By.id(id_elemento)).click();
	}

	public Boolean foiClicadoRadio(String id_elemento) {
		return driver.findElement(By.id(id_elemento)).isSelected();

	}

	public void clicarCheck(String id) {
		driver.findElement(By.id(id)).click();
	}

	public boolean isCheckMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();
	}

	/********* Combo ************/

	public void selecionarCombo(String id_elemento, String texto) {

		WebElement elemento = driver.findElement(By.id(id_elemento));

		Select combo = new Select(elemento);
		combo.selectByVisibleText(texto);
	}
	

	public void deselecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	
	public String retornaValorCombo(String id_elemento) {
		WebElement elemento = driver.findElement(By.id(id_elemento));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	

	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	/********* Botao ************/

	public void clicarBotao(String id_elemento) {
		WebElement botao = driver.findElement(By.id(id_elemento));
		botao.click();
	}
	

	public void obterTextoNaPagina(By by) {
		WebElement link = driver.findElement(by);

	}

	public String obterTexto(String id_elemento) {
		return driver.findElement(By.id(id_elemento)).getText();

	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		driver.switchTo().frame(id);
	}
	
	public void sairFrame(){
		driver.switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}
	
}
