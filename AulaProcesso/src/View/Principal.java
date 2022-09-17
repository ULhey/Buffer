package View;

import javax.swing.JOptionPane;
import Controller.RedesController;

public class Principal {
	public static String os, version;

	private static String Sistema(String OS, String Version) {
		OS = System.getProperty("os.name");
		Version = System.getProperty("os.version");
		return OS + "\nVersão: " + Version;
	}

	public static void main(String[] args) {
		RedesController Controller = new RedesController();
		String process = null;
		int opc = 0;
		while (opc != 4) {
			opc = Integer.parseInt(
					JOptionPane.showInputDialog("--------------------------------------------------------------\n"
							+ "      MENU PROCESSO - (Windows e Linux)				       \n"
							+ "                                   >_<                      \n"
							+ "   1 - Identificação do OS                                  \n"
							+ "   2 - Consulta do IP                                       \n"
							+ "   3 - Consulta do Ping                                     \n"
							+ "   4 - Finaliza Programa                                    \n"
							+ "-----------------------------------------------------------------"));
			switch (opc) {
			case 1:
				os = Sistema(os, version);
				JOptionPane.showInternalMessageDialog(null, "Sistema: " + os);
				break;
			case 2:
				if (os.contains("Windows")) {
					process = "ipconfig";
				} else {
					process = "ifconfig";
				}
				Controller.ProcessRead(process, os, opc);
				break;
			case 3:
				if (os.contains("Windows")) {
					process = "ping -4 -n 10 www.google.com.br";
				} else {
					process = "ping -4 -c 10 www.google.com.br";
				}
				Controller.ProcessRead(process, os, opc);
				break;
			case 4:
				System.exit(0); // Finalizar programa
				break;
			default: // Erro de quando a alternativa não é de 1 a 4
				JOptionPane.showMessageDialog(null, "ERRO");
				break;
			}
		}
	}
}