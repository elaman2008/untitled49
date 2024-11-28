
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MovieFindableService {
    private List<Movie> movies;

    public MovieFindableService(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie findMovieByFullNameOrPartName(String name) {

        for (Movie movie : DataBase.getMovies()) {
            if(movie.getName().contains(name)){
                return movie;
            }else {
                System.out.println("Фильм  не найден");
            }
        }
        return null;
    }

    public Movie findMovieByActorName(String actorName) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getActorFullName().toLowerCase().contains(actorName.toLowerCase())))
                .findFirst().orElse(null);
    }

    public Movie findMovieByYear(LocalDate year) {
        return movies.stream()
                .filter(movie -> movie.getYear().equals(year))
                .findFirst().orElse(null);
    }

    public Movie findMovieByProducer(String producerFullName) {
        return movies.stream()
                .filter(movie -> movie.getProducer().getFullName().equalsIgnoreCase(producerFullName))
                .findFirst().orElse(null);
    }

    public Movie findMovieByGenre(Genre genre) {
        return movies.stream()
                .filter(movie -> movie.getGenre() == genre)
                .findFirst().orElse(null);
    }

    public Movie findMovieByRole(String role) {
        return movies.stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getRole().equalsIgnoreCase(role)))
                .findFirst().orElse(null);
    }
}

































