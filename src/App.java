import java.io.Console;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        final var conf = new Config();
        Map<Integer, Filme> filmes;
        // Uma alternativa pela grande @Jacqueline Oliveira:
        // https://alura-filmes.herokuapp.com/conteudos

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = conf.get("url");
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            var movie = new Filme(filme);
            System.out.println(movie);
        }
    }
}
