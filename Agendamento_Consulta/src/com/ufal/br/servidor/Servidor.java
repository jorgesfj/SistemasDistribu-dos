package com.ufal.br.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.ufal.br.model.Consulta;

public class Servidor {
	
	private ServerSocket serverSocket;
	
	//1 - Criar Servidor de conex�es
	private void criarServerSocket(int porta) throws IOException{
		serverSocket = new ServerSocket(porta);
	}

	//2 - Espera um pedido de conex�o e cria uma nova conex�o
	private Socket esperaConexao() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}
	
	//6- Fechar server socket
	private void fecharSocket(Socket socket) throws IOException {
		socket.close();
	}
	
	//3 - Criar streams de entrada e sa�da
	//4 - Tratar a conversa��o entre cliente e servidor
	//4.1 - Fechar o socket de comunica��o entre cliente/servidor
	//4.2 - Fechar streams de entrada e sa�da
	private void tratarConexao(Socket socket) throws IOException, ClassNotFoundException {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			//M�todos
			Consulta consulta = (Consulta) input.readObject();
			System.out.println(consulta.getNomePaciente());
			input.close();
			output.close();
		}catch(IOException e) {
			System.out.println("Problema no tratamento da conex�o");
			System.out.println("Erro: " + e.getMessage());
		}finally {
			fecharSocket(socket);
		}
	}
	
	public static void main(String[] args) {
		try {
			Servidor servidor = new Servidor();
			System.out.println("Aguardando Conex�o");
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
