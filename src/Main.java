import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Cria uma instância da classe ConsultaCep
        ConsultaCep consultaCep = new ConsultaCep();

        System.out.println("Digite um CEP para consulta:");
        var cep = scanner.nextLine();

        try {
            // Cria uma instância da classe Endereco atribuindo a instância consultaCep que
            // chama o método buscaEndereco e passa como parâmetro o CEP
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            // Gera o arquivo Json
            GeradorDeArquivo generate = new GeradorDeArquivo();
            generate.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}