import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Iniciar conexão HTTP
        String apiKey = "k_nnxgj0mm";
        String url = "https://imdb-api.com/en/API/Top250Movies/"+apiKey;
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();
        
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);

        for (Map<String,String> filme : listaDeFilmes) {

            InputStream inputStream = new URL(filme.get("image")).openStream();
            
            GeradorDeFigurinhas geradorDeFigurinhas = new GeradorDeFigurinhas();
            geradorDeFigurinhas.criar(inputStream, filme.get("title") +".png");

            System.out.println(filme.get("title")); 
            System.out.println(filme.get("image"));
            System.out.println();
        }
    }
}
