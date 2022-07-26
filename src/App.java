import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

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
        
        var http = new clienteHTTP();
        String json = http.obtemDados(url);
        
        
        
        // apresentar e manipular os dados
        extratorDeConteudoDaNasa extrator = new extratorDeConteudoDaNasa(); 
        List<conteudo> conteudos = extrator.extraiConteudos(json);

        var fabrica = new fabricaDeStickers();
        
        for (int i = 0; i < 4; i++) {
        
            conteudo conteudo = conteudos.get(i);

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
