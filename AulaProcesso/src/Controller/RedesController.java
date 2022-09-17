package Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	public RedesController() {
		super();
	}

	public void ProcessRead(String process, String OS, int option) {
		try {
			Process read = Runtime.getRuntime().exec(process); // Armazena os dados nessa variavel
			InputStream flow = read.getInputStream(); // Fluxo de entrada dos dados para armazenar no "read"
			InputStreamReader reading = new InputStreamReader(flow); // Faz a leitura e converte para String
			BufferedReader buffer = new BufferedReader(reading); // Não deixa que a variavel "read" estore e de erro
			String line = buffer.readLine(); // Pega a primeira linha do buffer e discarta

			while (line != null) {
				if (option == 2) { // Passar parametro da opção
					if (OS.contains("Windows")) { // Check de linha
						if (line.contains("IPv4")) {
							String vet[] = line.trim().split(":");
							JOptionPane.showInternalMessageDialog(null, "IPv4: " + vet[1]);
						}
					} else {
						if (line.contains("inet")) {
							String vet[] = line.trim().split(" "); // Armazena o dado no vetor para a separação
							if (vet[0].equals("inet")) {
								JOptionPane.showMessageDialog(null, "Inet: " + vet[1]);
							}
						}
					}
				}
				if (option == 3) {
					if (OS.contains("Windows")) {
						if (line.contains("dia")) {
							String vet[] = line.split("dia =");
							JOptionPane.showMessageDialog(null, "Média: " + vet[1]);
						}
					} else {
						if (line.contains("mdev")) {
							String vet[] = line.trim().split("=");
							String vett[] = vet[1].trim().split("/");
							JOptionPane.showMessageDialog(null, "Média: " + vett[1]);
						}
					}
				}
				line = buffer.readLine();
			}
			buffer.close(); // Finaliza todo os processos ao acabar
			reading.close();
			flow.close();
		} catch (Exception e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro); // Apresenta erro da tentativa
		}
	}
}