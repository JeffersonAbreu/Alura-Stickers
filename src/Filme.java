import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Filme {

    private String id;
    private String title;
    private String backdropPath;
    private String posterPath;
    private String voteAverage;
    private String releaseDate;

    public Filme(Map<String, String> filme) {
        id = filme.get("id");
        title = filme.get("title");
        backdropPath = filme.get("backdrop_path");
        posterPath = filme.get("poster_path");
        voteAverage = filme.get("vote_average");
        releaseDate = filme.get("release_date");
    }

    @Override
    public String toString() {
        return "\u001b[97m \u001b[32m" + title + "\u001b[m"
                + "\n"
                + backdropPath
                + "\n"
                + "\u001b[37m \u001b[44m " + estrelas() + " \u001b[m"
                + "\n";
    }

    private int estrelas() {
        Double d = Double.parseDouble(voteAverage);
        return d.intValue();
    }

    private String getData() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(releaseDate).format(formatter);
    }

}
