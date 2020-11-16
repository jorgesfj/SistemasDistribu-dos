import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

class Cliente {
	
	public static void main(String[] args) {
		try {
			
		Socket socket = new Socket("localhost", 5555);
	

		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		
		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o CPF (SÓ NUMEROS: 99999999999)");
		String cpf = ler.next();
		output.writeUTF(cpf);
		output.flush();
		System.out.println("Mensagem enviada: " + cpf);
		boolean res = input.readBoolean();
		System.out.println("O CPF é: " + res);
		
		
		input.close();
		output.close();
		
		socket.close();
		}catch(IOException e) {
			System.out.println("Erro no cliente: " + e);
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
