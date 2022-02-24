package jvreis.webscrapingtest;

import java.io.OutputStreamWriter;
import java.util.GregorianCalendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;//importado ao criar veriável "documento"

public class Scrap {
	public static void search(GregorianCalendar calendar, String link, OutputStreamWriter writer) {//função para buscar no site
	Document documento = null;
	try {
		documento = Jsoup.connect(link).get();//usando biblioteca Jsoup apra se conectar ao link
		
	}catch (Exception e) {
		System.out.println("Stite Indisponível ou falha na requisição!");
	}
	}
}
