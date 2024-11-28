import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Producer producer1 = new Producer("Абжалов", "Эламан");
        Actor actor1 = new Actor( "Abdumalikov", "Фарсаж");
        Actor actor2 = new Actor("Abdurahmanov", "Боевик");

        List<Actor> actors = new ArrayList<>();
        actors.add(actor1);
        actors.add(actor2);

        Movie movie1 = new Movie("Проклятый дом", LocalDate.of(2020, 5, 23), Genre.ACTION, producer1, actors);

        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);

        MovieFindableService movieFindableService = new MovieFindableService(movies);
        MovieSortableService movieSortableService = new MovieSortableService(movies);

        Scanner scanner = new Scanner(System.in);
        boolean trueOrFalse = true;

        while (trueOrFalse) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Найти фильм по названию");
            System.out.println("2. Найти фильм по актеру");
            System.out.println("3. Найти фильм по году");
            System.out.println("4. Сортировать фильмы по названию");
            System.out.println("5. Сортировать фильмы по году");
            System.out.println("6. Выход");

            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название фильма: ");
                    String name = scanner.nextLine();
                    Movie foundMovieByName = movieFindableService.findMovieByFullNameOrPartName(name);
                    if (foundMovieByName != null) {
                        System.out.println("Найден фильм: " + foundMovieByName.getName());
                    } else {
                        System.out.println("Фильм не найден.");
                    }
                    break;

                case 2:
                    System.out.print("Введите имя актера: ");
                    String actorName = scanner.nextLine();
                    Movie foundMovieByActor = movieFindableService.findMovieByActorName(actorName);
                    if (foundMovieByActor != null) {
                        System.out.println("Найден фильм: " + foundMovieByActor.getName());
                        System.out.println("Актеры в этом фильме:");
                        for (Actor actor : foundMovieByActor.getActors()) {
                            System.out.println(actor.getActorFullName() + " как " + actor.getRole());
                        }
                    } else {
                        System.out.println("Фильм не найден.");
                    }
                    break;

                case 3:
                    System.out.print("Введите год (2012): ");
                    String date = scanner.nextLine();
                    try {
                        LocalDate year = LocalDate.parse(date);
                        Movie foundMovieByYear = movieFindableService.findMovieByYear(year);
                        if (foundMovieByYear != null) {
                            System.out.println("Найден фильм: " + foundMovieByYear.getName());
                        } else {
                            System.out.println("Фильм не найден.");
                        }
                    } catch (Exception e) {
                        System.out.println("Неверный формат даты. Используйте формат UUUU-BB-DD.");
                    }
                    break;

                case 4:
                    System.out.print("Сортировать по имени): ");
                    String sortNameOrder = scanner.nextLine();
                    movieSortableService.sortMovieByName(sortNameOrder);
                    System.out.println("Фильмы отсортированы по названию:");
                    for (Movie movie : movies) {
                        System.out.println(movie.getName());
                    }
                    break;

                case 5:
                    System.out.print("Сортировать по году (по возрастанию): ");
                    String sortYearOrder = scanner.nextLine();
                    movieSortableService.sortByYear(sortYearOrder);
                    System.out.println("Фильмы отсортированы по году:");
                    for (Movie movie : movies) {
                        System.out.println(movie.getYear());
                    }
                    break;

                case 6:
                    System.out.println("Вы завершили сессию!!!");
                    trueOrFalse = false;
                    break;

                default:
                    System.out.println("Неверный выбор.");
            }
        }
        scanner.close();
    }
}
