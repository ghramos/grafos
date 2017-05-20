package br.furb.trabalho02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import br.furb.Utils.Grafo;

public class teste {
	private static BufferedReader b;
	private static File f;

	public static void main(String[] args) throws IOException {
		f = new File("/home/siena/workspace/TeoriaDosGrafos/src/br/furb/trabalho02/teste.txt");
		b = new BufferedReader(new FileReader(f));
		Grafo g = new Grafo();

		String readLine = "";
		int total = 1;

		// Popula o grafo
		while ((readLine = b.readLine()) != null) {
			readLine = readLine.replaceAll("\\s+", "");
			String output[] = readLine.split(Pattern.quote(")("));
			System.out.print(output[0].replaceAll("\\(", "").replaceAll(",", "\t") + "\t");
			System.out.print(output[1].replaceAll("\\)", "").replaceAll(",", "\t") + "\n");
			total++;
			// System.out.println(readLine);

		}
		System.out.println(total);

	}

}
