package selenium;

import org.openqa.selenium.WebDriver;



public class CadastroPage {
	
	private DSLprojeto dsl;
	
	
	
	public CadastroPage(WebDriver driver) {
		
		dsl=new DSLprojeto(driver);
	}



	public void setDescricao(String nome){
		
		dsl.escrever("descricao",nome);
	}
	
public void setDataVencimento(String texto){
		
		dsl.escrever("dataVencimento",texto);
	}

public void setValor(String valor){
	dsl.escrever("valor",valor);
}


public void setStatus(String valor){
dsl.selecionarCombo("status", valor);
}

public void salvar(){
	dsl.clicarBotao("btnSalvar");
}

public String retornaNome(){
	return dsl.retornaValor("descricao");
}

public String retornaData(){
	return dsl.retornaValor("dataVencimento");
}

public String retornaValor(){
	return dsl.retornaValor("valor");
}

public void clicarEditar(){
	dsl.clicarBotao("btnEdicao");
}

public void excluir(){
	dsl.clicarBotao("btnExcluir");
}

public void excluirModal(){
	dsl.clicarBotao("btnModalExcluir");
}

}
