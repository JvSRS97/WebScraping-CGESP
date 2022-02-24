package jvreis.webscrapingtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;//importado ao criar variável "documento"
import org.jsoup.nodes.Element;//importado ao criar variável "elemento"
import org.jsoup.select.Elements;

public class Scrap {// classe que contém os dados HTML
	static String texto = " ";
	// função para buscar no site. Cria uma cópia HTML da URL e buscará elementos pela classe dada
	//imprimirá os dados e retornará uma string texto para escrita em arquivo
	public static String search(String Dia, String Mes, String Ano, String link) {
		
		Document documento = null;
		// System.out.println(link);//testando impressão
		try {
			documento = Jsoup.connect(link).get();// usando biblioteca Jsoup apra se conectar ao link

		} catch (Exception e) {
			System.out.println("Site Indisponível ou falha na requisição!");
		}
		// Elementos são um array e o .getElementsByClass pegará os elementos com a
		// classe informada
		
		for (Element elemento : documento.getElementsByClass("tb-pontos-de-alagamentos")) {// pegar pela classe da
																							// tabela (está no arquivo
																							// "Ideia para WebScraping
																							// CGESP.txt")
			System.out.println("Link: \n" + link);// testando impressão. Só irá imprimir o link se
			// houver alagamento na data
			System.out.print("Data " + Dia + "/" + Mes + "/" + Ano + " --> ");// imprimindo a data

			//Trabalhar essa parte da Zona
			//Elements zona = documento.getElementsByClass("tit-bairros");//classe que contém a zona do alagamento
			//System.out.print("Zona: " + zona.text()+" ");// OK! Imprimindo apenas o bairro
			
			Elements bairro = elemento.getElementsByClass("bairro arial-bairros-alag linha-pontilhada");// pega pela
																										// classe do
																										// bairro //
																										// tabela
			// System.out.println(bairro);//imprime a tag com o bairro
			System.out.print("Bairro: " + bairro.text());// OK! Imprimindo apenas o bairro
			
			
			Elements dados_1 = elemento.getElementsByClass("arial-descr-alag col-local");// classe que contém
																							// informações como hora de
																							// início, hora final e
																							// localidade
			System.out.println("; Descrição: " + dados_1.text() + "\n\n");// OK! Imprimindo os dados
			// imprime "De xx:xx a xx:xx Rua A"
			// caso tenha mais de um alagamento no dia, imprime da seguinte forma:
			// "De xx:xx a xx:xx Rua A De xx:xx a xx:xx Rua B"
						
			//passando dados para string texto que será exportada
			texto += "\n\nLink: \n"+link+"\nData " + Dia + "/" + Mes + "/" + Ano + " --> "+"Bairro: " + bairro.text()+"; Descrição: " + dados_1.text() + "\n\n";
		}
		return texto;
	}
}
