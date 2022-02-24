package jvreis.webscrapingtest;

//Obs.: Comando Alt+Shift+s -> "Generate Getters and Setters" gera automaticamente as funções 
//get e set para cada variável
public class Search {// classe para buscar na estrutura HTML
	private String zona;
	private String bairro;
	private String rua;
	private String h_inicial;
	private String h_final;

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getH_inicial() {
		return h_inicial;
	}

	public void setH_inicial(String h_inicial) {
		this.h_inicial = h_inicial;
	}

	public String getH_final() {
		return h_final;
	}

	public void setH_final(String h_final) {
		this.h_final = h_final;
	}

}
