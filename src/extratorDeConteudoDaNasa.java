import java.util.List;

public class extratorDeConteudoDaNasa {
    
    public List<conteudo> extraiConteudos (String json){
        
        // extrair os dados que interessam (título, imagem, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(json);

    }
}
