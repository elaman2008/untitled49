
    import java.time.LocalDate;
    import java.util.List;

    public class Movie {
        private String name;
        private LocalDate year;
        private Genre genre;
        private Producer producer;
        private List<Actor> actors;

        public Movie(String name, LocalDate year, Genre genre, Producer producer, List<Actor> actors) {
            this.name = name;
            this.year = year;
            this.genre = genre;
            this.producer = producer;
            this.actors = actors;
        }

        public String getName() {
            return name;
        }

        public LocalDate getYear() {
            return year;
        }

        public Genre getGenre() {
            return genre;
        }

        public Producer getProducer() {
            return producer;
        }

        public List<Actor> getActors() {
            return actors;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "name='" + name + '\'' +
                    ", year=" + year +
                    ", genre=" + genre +
                    ", producer=" + producer +
                    ", actors=" + actors +
                    '}';
        }
    }

