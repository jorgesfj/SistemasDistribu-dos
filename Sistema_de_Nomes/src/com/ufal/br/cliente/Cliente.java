package com.ufal.br.cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
		
	public static String lookup(String value) {
		String endereco = "";
		Cadastro msg = new Cadastro(value);
		
		msg.setServico("validacpf");
		try {
			Socket cliente = new Socket("localhost", 5000);
			
			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			
			saida.writeObject(msg);
			saida.flush();
			String msgReply = entrada.readUTF();
			endereco = msgReply;
			
			System.out.println("Mensagem recebida: "+ msgReply);
			entrada.close();
			saida.close();
			cliente.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return endereco;
	}
	
	
	public static void main(String[] args) {
		String endereco = lookup("lookup");
		String[] strings = endereco.split("\\:");
		String endereco2 = strings[0];
		
		int porta = Integer.parseInt(strings[1]);
		
		try {
			Socket socket = new Socket(endereco2, porta);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Scanner ler = new Scanner(System.in);
			System.out.println("Digite o CPF (SÓ NUMEROS: 99999999999)");
			String cpf = ler.next();
			String msg = cpf; 
			output.writeUTF(msg);
			output.flush();
			String msgReply = input.readUTF();
			System.out.println("Mensagem recebida -  "+ msgReply);
			input.close();
			output.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
