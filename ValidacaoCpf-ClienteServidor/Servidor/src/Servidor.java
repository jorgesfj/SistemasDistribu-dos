import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
public class Servidor {
	//1 - Criar Servidor de conexões
	//2 - Esperar um pedido de conexão
	//2.1 - Criar uma nova conexão
	//3 - Criar streams de entrada e saída
	//4 - Tratar a conversação entre cliente e servidor
	//4.1 - Fechar o socket de comunicação entre cliente/servidor
	//4.2 - Fechar streams de entrada e saída
	//5 - Voltar para o passo 2
	//6 - Fechar server socket
	
	private ServerSocket serverSocket;
	
	private void criarServerSocket(int porta) throws IOException {
		serverSocket = new ServerSocket(porta);
	}
	
	private Socket esperaConexao() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}
	
	private void fecharSocket(Socket socket) throws IOException{
		socket.close();
		
	}
	
	private boolean validarCPF(String CPF) {
		 // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
	
	private void tratarConexao(Socket socket) throws IOException {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			
			String cpf = input.readUTF();
			System.out.println("CPF Recebido: " + cpf);
			output.writeBoolean(validarCPF(cpf));
			output.flush();
			
			input.close();
			output.close();
		}catch(IOException e) {
			System.out.println("Problema no tratamento da conexão com o cliente: " + socket.getInetAddress());
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
		}catch (IOException e){
			//Tratar exceção
		}
	}
}
