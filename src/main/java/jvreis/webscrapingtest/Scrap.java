package jvreis.webscrapingtest;

import java.io.OutputStreamWriter;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;//importado ao criar variável "documento"
import org.jsoup.nodes.Element;//importado ao criar variável "elemento"

public class Scrap {// classe que contém os dados HTML
	public static void search(GregorianCalendar calendar, String link, OutputStreamWriter writer) {// função para buscar
																									// no site
		Document documento = null;
		// System.out.println(link);//testando impressão
		try {
			documento = Jsoup.connect(link).get();// usando biblioteca Jsoup apra se conectar ao link

		} catch (Exception e) {
			System.out.println("Site Indisponível ou falha na requisição!");
		}

		for (Element elemento : documento.getElementsByClass("tb-pontos-de-alagamentos")) {// pegar pela classe da
																							// tabela
			System.out.println(link);// testando impressão
		}
	}
}
