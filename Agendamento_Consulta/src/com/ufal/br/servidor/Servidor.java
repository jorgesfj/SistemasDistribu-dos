package com.ufal.br.servidor;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ufal.br.model.Consulta;
import com.ufal.br.model.Threadex;

public class Servidor {
	
	private ServerSocket serverSocket;

	private void criarServerSocket(int porta) throws IOException{
		serverSocket = new ServerSocket(porta);
	}
	
	private Socket esperaConexao() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}
	
	private void fecharSocket(Socket socket) throws IOException {
		socket.close();
	}
	
	private void tratarConexao(Socket socket) throws IOException, ClassNotFoundException {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

			Consulta consulta = (Consulta) input.readObject();
			Consulta consulta2 = (Consulta) input.readObject();
			Consulta consulta3 = (Consulta) input.readObject();
			
			Threadex t1 = new Threadex(consulta);
			Threadex t2 = new Threadex(consulta2);
			Threadex t3 = new Threadex(consulta3);
			
			ExecutorService threadExecutor = Executors.newFixedThreadPool(10);
			threadExecutor.execute(t1);
			threadExecutor.execute(t2);
			threadExecutor.execute(t3);
			
			
			input.close();
			output.close();
		}catch(IOException e) {
			System.out.println("Problema no tratamento da conexão");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			fecharSocket(socket);
		}
	}
	
	public static void main(String[] args) {
		try {
			Servidor servidor = new Servidor();
			System.out.println("Aguardando Conexão");
			servidor.criarServerSocket(5555);
			Socket socket = servidor.esperaConexao();
			System.out.println("Cliente Conectado");
			servidor.tratarConexao(socket);
			System.out.println("Cliente Finalizado");
		} catch (IOException e) {
			System.out.println("Erro no servidor: " + e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println("Erro no cast" + e.getMessage());
		}
		
	}
}
