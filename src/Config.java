import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<String, String> mapa;

    public Config() {
        // Mapeando
        mapa = new HashMap<String, String>();
        var url = new File("config.ini").getAbsolutePath().toString();
        try {
            // ler tudo
            String todoTextDoArquivo = Files.readString(Path.of(url), StandardCharsets.UTF_8);
            // divide por linha ";"
            var linhas = todoTextDoArquivo.split(";");
            String key = "", value = "";
            // lê todas as linhas
            for (String linha : linhas) {
                // Ex.: url="www.alura.com.br"
                // [0] => url
                // [1] => "www.alura.com.br"
                key = linha.split("=>")[0];
                value = linha.split("=>")[1];
                // add no mapa
                mapa.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String chave) {
        return mapa.get(chave);
    }
}
