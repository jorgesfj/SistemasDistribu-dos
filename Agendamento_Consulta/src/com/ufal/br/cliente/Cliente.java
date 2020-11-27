package com.ufal.br.cliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
	
	public static void main(String[] args) {
		
		try{
			//criando o socket para rodar na máquina local(localhost) e na porta 5555
			Socket socket = new Socket("localhost", 5555);
			
			//instânciando o recebimento
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			//instânciando o envio
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			
			//fechando o envio
			input.close();
			//fechando o recebimento
			output.close();
			//fechando o socket
			socket.close();
		}catch(IOException e) {
			//tratando o erro
			System.out.println("Erro no cliente: " + e);
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

}
