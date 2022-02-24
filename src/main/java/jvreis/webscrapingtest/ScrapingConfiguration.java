package jvreis.webscrapingtest;

import java.io.File;//importando biblioteca para trabalhar com entrada e saída de arquivo
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;//para escrever arquivo

public class ScrapingConfiguration {
	private String path = "C:\\Users\\jvict\\eclipse-workspace\\webscraping-test\\ScrapingFile.txt";// caminho para o arquivo a ser
																					// gravado
	private String link = "https://www.cgesp.org/v3/alagamentos.jsp?dataBusca=";// link para o WebScraping
	private OutputStreamWriter writer;// para escrever no arquivo

	public ScrapingConfiguration() {// construtor que chamará método
		configFile(); // para configurar o arquivo para gravar
	}

	private void configFile() {// método para configurar o arquivo para gravar
		try {
			File arquivo = new File(path);// declarando variável do tipo File chamada "arquivo" com o caminho "path"
											// declarado lá em cima
			if (!arquivo.exists()) {// se arquivo não existe [note "!" antes]
				arquivo.createNewFile();//criando arquivo
			}
			writer = new OutputStreamWriter(new FileOutputStream(arquivo));// para escrever arquivo
			writer.write("Zona\tBairro\tRua\tHora-Inicial\tHora-Final");//escrevendo cabeçalho
			writer.flush();// limpar memória do writer
		} catch (Exception e) {
			e.printStackTrace();//imprime informações sobre erro, caso ocorra
		}
	}
}
