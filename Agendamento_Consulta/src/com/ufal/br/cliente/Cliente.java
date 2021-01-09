package com.ufal.br.cliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ufal.br.model.Consulta;

public class Cliente {
	public Consulta agendarConsulta(String nomePaciente, String descricao, int id) {
		
		Consulta consulta = new Consulta(id,nomePaciente,descricao);
		
		return consulta;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		try{
			//criando o socket para rodar na máquina local(localhost) e na porta 5555
			Socket socket = new Socket("localhost", 5555);
			Cliente cliente = new Cliente();
			//instânciando o recebimento
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			//instânciando o envio
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());


			for(int i = 0; i<=10; i++) {
				Consulta consulta = new Consulta(i+1, "Paciente " + i, "Consulta");
				Thread.sleep(1000);
				output.writeObject(consulta);
				output.flush();
			}
			
			input.close();
			output.close();
		}catch(IOException e) {
			//tratando o erro
			System.out.println("Erro no cliente: " + e);
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

}
