import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.io.*;

public class App {

    // declarar o ANSI_RESET de forma a fazer o reset de uma cor escolhida
    public static final String ANSI_RESET = "\u001B[0m";
    // declarar a cor do background
    public static final String PURPLE_BACKGROUND = "\u001B[45m";

    public static void main(String[] args) throws Exception {
        // fazer uma conexão HTTP e obter o top 250 filmes
        // url alternativa
        //String url = "https://api.mocki.io/v2/549a5d8b";
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_d6o9vfgi";
        String url = "https://imdb-api.com/en/API/MostPopularMovies/k_d6o9vfgi";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // extrair os dados que interessam (título, imagem, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        // apresentar e manipular os dados 
        for (Map<String,String> filme : listaDeFilmes) {
            String urlImagem = filme.get("image");
            InputStream InputStream = new URL(urlImagem).openStream();
            System.out.println(filme.get("title"));
            System.out.println();
            System.out.println(PURPLE_BACKGROUND + "Classificação: " + filme.get("imDbRating") + ANSI_RESET);
            System.out.println("teste" + " \2B50");
            System.out.println();
            
        }
    }
}
