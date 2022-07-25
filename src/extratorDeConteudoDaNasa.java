import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorDeConteudoDaNasa {
    
    public List<conteudo> extraiConteudos (String json){
        
        // extrair os dados que interessam (título, imagem, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<conteudo> conteudos = new ArrayList<>();

        

        return conteudos;

        }
}
