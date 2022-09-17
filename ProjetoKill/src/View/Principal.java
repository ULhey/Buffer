package View;
import javax.swing.JOptionPane;

import Controller.KillController;

public class Principal {
	public static String os, version;
	private static String Sistema(String OS, String Version) {
		OS = System.getProperty("os.name");
		Version = System.getProperty("os.version");
		return OS + "\nVersão: " + Version;
	}
	
	public static void main(String[] args) {
		KillController controller = new KillController();	
		int opc = 0;
		while (opc != 4) {
			opc = Integer.parseInt(
					JOptionPane.showInputDialog("--------------------------------------------------------------\n"
							+ "      MATA TUTO - (Windows e Linux)				           \n"
							+ "                                   O_O                      \n"
							+ "   1 - Identificação do OS                                  \n"
							+ "   2 - Tabela de Processos                                  \n"
							+ "   3 - Mata PID                                             \n"
							+ "   4 - Mata Nome                                            \n"
							+ "   5 - Finalizar Programa                                   \n"
							+ "-----------------------------------------------------------------"));
			switch (opc) {
			case 1:
				os = Sistema(os, version);
				JOptionPane.showInternalMessageDialog(null, "Sistema: " + os);
				break;
			case 2:
				if(os.contains("Windows")) {
				controller.Process("TASKLIST /FO TABLE");
				} else {
					controller.Process("ps -ef");
				}				
				break;
			case 3:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID: "));
				controller.Killpid(pid, os);
				JOptionPane.showMessageDialog(null, "Programa finalizado >_<");
				break;
			case 4:
				String name = JOptionPane.showInputDialog("Digite o NOME do programa: ");
				controller.Killname(name, os);
				JOptionPane.showMessageDialog(null, "Programa finalizado >_<");
				break;
			case 5:
				System.exit(0); // Finalizar programa
				break;
			default: // Erro de quando a alternativa não é de 1 a 4
				JOptionPane.showMessageDialog(null, "ERRO");
				break;
			}
		}
	}
}