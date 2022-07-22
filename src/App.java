import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e obter o top 250 filmes
        // url alternativa
        //String url = "https://api.mocki.io/v2/549a5d8b";
        String url = "https://imdb-api.com/en/API/Top250Movies/k_d6o9vfgi";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair os dados que interessam (título, imagem, classificação)

        // apresentar e manipular os dados 
    }
}
