import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
	
	public static void main(String[] args) {
		
		ServerSocket servidor = null;
		try {
			System.out.println("Inicializando o servidor...");
			servidor = new ServerSocket(9999);
			System.out.println("Servidor iniciado!");
			
			while(true){
				Socket cliente = servidor.accept();
				new GerenciadorDeClientes(cliente);
			}
			
		} catch (IOException e) {
			
			try {
				if(servidor != null)
					servidor.close();
			} catch (IOException e1) {}
			
			System.err.println("A porta está ocupada ou servidor foi fechado");
			e.printStackTrace();
		}
		
	}
}
