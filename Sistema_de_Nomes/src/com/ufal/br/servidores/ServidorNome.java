package com.ufal.br.servidores;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.ufal.br.cliente.Cadastro;

public class ServidorNome {

	public static void main(String[] args) throws ClassNotFoundException {
		ServerSocket serverSocket;
		Cadastro msg;
		Map<String, String> data = new HashMap<String, String>();
		
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println("Porta: 5000");
			while (true) {
				System.out.println("Esperando conexão.");
				Socket cliente = serverSocket.accept();
				
				System.out.println("Conectado: " + cliente.getInetAddress().getHostAddress());
				
				ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
		        ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());
		        
		        msg = (Cadastro)input.readObject();
		        
		        switch (msg.getOperacao()) {
					case "lookup": {
				        System.out.println("Serviço: "+ msg.getServico());
			        	output.writeUTF(data.get(msg.getServico()));
			        	output.flush();
				        output.close();
				        input.close();
				        cliente.close();
				        break;
					} case "registro":{
			        	data.put(msg.getServico(), msg.getEndereco());
				        System.out.println("Cadastrado");
				        output.writeUTF("Cadastrado");
				        output.flush();
				        output.close();
				        input.close();
				        cliente.close();
				        break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
