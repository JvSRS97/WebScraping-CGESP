package jvreis.webscrapingtest;

//Obs.: Crtl+espaço ao digitar classe importa automaticamente a biblioteca que a contém
import java.io.File;//importando biblioteca para trabalhar com entrada e saída de arquivo
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;//biblioteca para escrever arquivo
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ScrapingConfiguration {//obs.: editar caminho do arquivo em caso de mudança de pasta
	private String path = "C:\\Users\\jvict\\eclipse-workspace\\webscraping-test\\ScrapingFile.txt";
	// caminho para o arquivo a ser gravado
	
	private String link;// link para o WebScraping
	private OutputStreamWriter writer;// para escrever no arquivo

	public ScrapingConfiguration() {// construtor que chamará método
		configFile(); // para configurar o arquivo para gravar
		executar();// método para executar scraping
	}

	// ------------------------------------------------------------------
	private void configFile() {// método para configurar o arquivo para gravar
		try {
			File arquivo = new File(path);// declarando variável do tipo File chamada "arquivo" com o caminho "path"
											// declarado lá em cima
			if (!arquivo.exists()) {// se arquivo não existe [note "!" antes]
				arquivo.createNewFile();// criando arquivo
			}
			writer = new OutputStreamWriter(new FileOutputStream(arquivo));// para escrever arquivo
			writer.write("## By JvReis\n");// escrevendo cabeçalho no arquivo
			writer.flush();// limpar memória do writer
		} catch (Exception e) {
			e.printStackTrace();// imprime informações sobre erro, caso ocorra
		}
	}
	// ------------------------------------------------------------------
	private void escreverFile(String texto) {//função para escrever texto no arquivo
		try {
			File arquivo = new File(path);// declarando variável do tipo File chamada "arquivo" com o caminho "path"
											// declarado lá em cima
			if (!arquivo.exists()) {// se arquivo não existe [note "!" antes]
				arquivo.createNewFile();// criando arquivo
			}
			writer = new OutputStreamWriter(new FileOutputStream(arquivo));// para escrever arquivo
			writer.write(texto);
			writer.flush();// limpar memória do writer
		} catch (Exception e) {
			e.printStackTrace();// imprime informações sobre erro, caso ocorra
		}
	}

	// ------------------------------------------------------------------
	private void executar() {
		String Texto_Arquivo;
		GregorianCalendar calendar = new GregorianCalendar();// precisa do dia, do mês e do ano de uma determianda data
																// por conta do formato de busca do site
																// "https://www.cgesp.org/v3/alagamentos.jsp?dataBusca=23%2F02%2F2022&enviaBusca=Buscar"
		// O calendar já começa com a data de hoje 23/02/2022 (dia em que está rodando).
		// Mudando posteriormente.
		SimpleDateFormat dia = new SimpleDateFormat("dd");
		SimpleDateFormat mes = new SimpleDateFormat("MM");
		SimpleDateFormat ano = new SimpleDateFormat("yyyy");
		//para converter SimpleDateFormat em String, usar a função: .format(GregorianCalendar.getTime())
		String Dia, Mes, Ano;
		int contador = 1;
		while (contador<=31) {//pega histórico de 1 mês
			//convertendo SimpleDateFormat em String
			//[função .getTime pega a data gerada]
			Dia = dia.format(calendar.getTime());
			Mes = mes.format(calendar.getTime());
			Ano = ano.format(calendar.getTime());
			
			formatarLink(Dia, Mes, Ano);// chamando função para formatar link 
			Texto_Arquivo = Scrap.search(Dia, Mes, Ano, link);//chamando função search da classe Scrap
			escreverFile(Texto_Arquivo);
			calendar.add(GregorianCalendar.DATE, -1);//decrementando da data
			contador +=1;
		}
	}

	// ------------------------------------------------------------------
	public void formatarLink(String dia, String mes, String ano) {// comando para formatar link
		this.link = "https://www.cgesp.org/v3/alagamentos.jsp?dataBusca=" + dia + "%2F" + mes + "%2F" + ano
				+ "&enviaBusca=Buscar";
	}


}
