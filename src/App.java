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
        //String url = "https://imdb-api.com/en/API/MostPopularMovies/k_d6o9vfgi";
        String url = "https://api.nasa.gov/planetary/apod?api_key=coea0W7a796J0IB00v2BET6gdkhngNaNeN3AZ1jW&start_date=2022-07-21&end_date=2022-07-24";
        
        
        // extrair os dados que interessam (título, imagem, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(body);
        
        // apresentar e manipular os dados 
        var fabrica = new fabricaDeStickers();
        
        for (int i = 0; i < 4; i++) {
        
            Map<String,String> conteudo = listaDeConteudos.get(i);

            String urlImagem = 
                //conteudo.get("image")
                conteudo.get("url")
                .replaceAll("(@+)(.*).jpg$", "$1.jgp");

            String titulo = conteudo.get("title")
                .replace(":", "");
            
            
            InputStream InputStream = new URL(urlImagem).openStream();
            String nomeFicheiro = "saida/" + titulo + ".png";

            fabrica.cria(InputStream, nomeFicheiro);

            System.out.println(titulo);
            System.out.println();
            
        
    }
}
}
