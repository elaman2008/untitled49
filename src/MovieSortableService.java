import java.time.LocalDate;
import java.util.List;

public class MovieSortableService {
    private List<Movie> movies;

    public MovieSortableService(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie findMovieByFullNameOrPartName(String name) {
        return movies.stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst().orElse(null);
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
        return null;
    }

    public void sortMovieByName(String sortNameOrder) {
    }

    public void sortByYear(String sortYearOrder) {
    }
}























