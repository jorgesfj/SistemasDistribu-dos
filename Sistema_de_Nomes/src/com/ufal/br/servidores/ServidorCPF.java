package com.ufal.br.servidores;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

import com.ufal.br.cliente.Cadastro;

public class ServidorCPF {
	
	
    public static boolean isCPF(String CPF) {
        if (CPF.equals("00000000000")||(CPF.length() != 11)) {
        	return(false);
        }

        char d10;
        char d11;
        int soma;
        int i;
        int j;
        int numero;
        int peso;
        try {
             soma = 0;peso = 10;
            
             for (i=0; i<9; i++) {
	            numero = (int)(CPF.charAt(i) - 48);
	            soma += numero * peso;
	            peso -= 1;
             }

            j = 11 - (soma % 11);
            if ((j == 10) || (j == 11)) {
                d10 = '0';
            } else {
            	d10 = (char)(j + 48);
            }
            
            soma = 0;peso = 11;
            for(i=0; i<10; i++) {
	            numero = (int)(CPF.charAt(i) - 48);
	            soma = soma + (numero * peso);
	            peso = peso - 1;
            }

            j = 11 - (soma % 11);
            if ((j == 10) || (j == 11)) {
            	 d11 = '0';	
            }
            else {
            	d11 = (char)(j + 48);
            	}

        
            if ((d10 == CPF.charAt(9)) && (d11 == CPF.charAt(10))) {
                 return(true);
            }
            else {
            	return(false);
            }
                } catch (InputMismatchException e) {
                return(false);
            }
        }

    
    public static String retornaCPF(String CPF) {
        return(CPF.substring(0, 3) + "." 
        		+ CPF.substring(3, 6) + "." +
        		CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
	
    
    public static void Registrar(String value) {
		try {
			Cadastro msg = new Cadastro(value);
			msg.setEndereco("localhost:55555");
			msg.setServico("validacpf");
			
			
			Socket cliente = new Socket("localhost", 5000);
			
			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			
			
			saida.writeObject(msg);
			saida.flush();
			
			
			String msgReply = entrada.readUTF();
			System.out.println("Mensagem recebida: "+ msgReply);
			
			
			entrada.close();
			saida.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    public static void main(String[] args) {

		
		
		ServerSocket servidor;	
		try {
				Registrar("registro");
				
				
				servidor = new ServerSocket(55555);
				System.out.println("Porta: 55555");
				
			    while(true) {
			    	System.out.println("Aberto para conexão.");
			    	Socket cliente = servidor.accept();
			    	
			        System.out.println("Conectado: " + cliente.getInetAddress().getHostAddress());
			        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			        
			        String CPF = entrada.readUTF();
			        try{
			        	isCPF(CPF);
			        	saida.writeUTF("Confimado " + retornaCPF(CPF));
			        	saida.flush();
			        	System.out.println("Fim");
				        saida.close();
				        entrada.close();
				        cliente.close();
			       } catch (IOException e) {
						e.printStackTrace();
					}
					
			    }
			} catch (IOException e1) {
				e1.printStackTrace();
			}

	}

}
