import java.util.List;
        public class DataBase {
        private static List<Movie> movies;
        private static  List<Actor> actors;

        public static List<Movie> getMovies() {
            return movies;
        }

        public static void setMovies(List<Movie> movies) {
            DataBase.movies = movies;
        }

        public static List<Actor> getActors() {
            return actors;
        }

        public static void setActors(List<Actor> actors) {
            DataBase.actors = actors;
        }
    }

