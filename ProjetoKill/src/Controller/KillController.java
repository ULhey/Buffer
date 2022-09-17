package Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	public void Process(String process) {
		try {
			Process read = Runtime.getRuntime().exec(process);
			InputStream flow = read.getInputStream();
			InputStreamReader reading = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reading);
			String line = buffer.readLine();

			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (Exception e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
	}

	public void Killpid(int pid, String os) {
		StringBuffer buffer = new StringBuffer();
		String cod = null;
		if (os.contains("Windows")) { // verificar o OS que está
			cod = "TASKKILL /PID "; // Passa para a varavel a função
		} else {
			cod = "kill -9 ";
		}
		try {
			buffer.append(cod); // Apresenta os parametros armazenados
			buffer.append(pid);
		} catch (Exception a) {
			System.out.println(a);
		}
		Process(buffer.toString());
	}

	public void Killname(String name, String os) {
		StringBuffer buffer = new StringBuffer();
		String cod = null;
		if (os.contains("Windows")) { // verificar o OS que está
			cod = "TASKKILL /IM "; // Passa para a varavel a função
		} else {
			cod = "pkill -f ";
		}
		try {
			buffer.append(cod);
			buffer.append(name);
		} catch (Exception a) {
			String msgErro = a.getMessage();
			System.err.println(msgErro);
		}
		Process(buffer.toString());
	}
}