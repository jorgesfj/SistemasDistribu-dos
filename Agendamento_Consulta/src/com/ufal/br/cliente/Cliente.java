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
	public Consulta agendarConsulta(int id, String nomePaciente, int dia, int hora, int minuto, String descricao) {
		Consulta consulta = new Consulta(id, nomePaciente, dia, hora, minuto, descricao);
		
		return consulta;
	}
	
	public static void main(String[] args) {
		
		try{
			//criando o socket para rodar na máquina local(localhost) e na porta 5555
			Socket socket = new Socket("localhost", 5555);
			Cliente cliente = new Cliente();
			//instânciando o recebimento
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			//instânciando o envio
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Scanner ler = new Scanner(System.in);
			
			System.out.println("Digite o Seu nome: ");
			String nomePaciente = ler.next();
			
			System.out.println("Digite o dia que você quer se consultar: ");
			int dia = ler.nextInt();
			
			System.out.println("Digite a Hora da consulta: (só o inteiro) ");
			int hora = ler.nextInt();
			
			System.out.println("Digite qual minuto começará a consulta: ");
			int minuto = ler.nextInt();
			
			System.out.println("Descreva a colsulta: ");
			String descricao = ler.next();
			
			Consulta consulta = cliente.agendarConsulta(0, nomePaciente, dia, hora, minuto, descricao);
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
