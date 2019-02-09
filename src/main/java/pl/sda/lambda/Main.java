package pl.sda.lambda;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        InterfaceAdd add = (a, b) -> a + b;
        add.calc(4,2);


//        //użycie klasy abstrakcyjnej
//        InterfaceAdd add2 = new InterfaceAdd() {
//            @Override
//            public int calc(int a, int b) {
//                return 0;
//            }
//        };


        List<Integer>numbers = Arrays.asList(1,2,3,4,5,6,7);

        for (Integer integer: numbers){
            System.out.println(integer);

        }

        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);


        numbers.forEach(System.out::println);


        List<Movie>movies = Arrays.asList(
                new Movie("Tytul",
                        "Jan",
                        LocalDate.of(2012,02,12),
                        60,
                        Arrays.asList("Jan", "Maciek")),
                new Movie("Tytul2",
                        "Jan2",
                        LocalDate.of(2017,02,12),
                        20,
                        Arrays.asList("Michał", "Maciek")),
                new Movie("Sensacja",
                        "Kamil",
                        LocalDate.of(2018,04,30),
                        30,
                        Arrays.asList("Jan", "Maciek")));



//        movies.stream().map(f -> f.getTitle());

//        for (Movie movie: movies){
//            System.out.println(movie.getTitle());
//        }

        //to samo co wyżej, tylko za pomocą streamu

        List<String>titles = movies.stream()
                .map(f -> f.getTitle())
                .collect(Collectors.toList());


        List<String>directors = movies.stream()
                .map(f -> f.getDirector())
                .collect(Collectors.toList());
        directors.forEach(System.out::println);
        System.out.println(directors);

        System.out.println(titles);

        List<Movie> movieList= movies.stream()
                .filter(f -> f.getPrice()>50)
                .filter(f ->f.getTitle().length()>5)
                .collect(Collectors.toList());

        movieList.forEach(System.out::println); //zwróci całe obiekty

        movieList.forEach(p -> System.out.println(p.getTitle() + p.getPrice())); //można dobrać się do konkretnych paametrów obiektu


        //zwróć listę tytułów filmów, których getPrice >10 i < 30


        List<Movie>movieList1 = movies.stream()
                .filter(f ->f.getPrice()>10)
                .filter(f-> f.getPrice()<30)
                .collect(Collectors.toList());
//        movieList1.forEach(System.out::println);
        movieList1.forEach(f -> System.out.println(f.getTitle()));

        //zwróć listę filów w których gra Jan
        List<Movie>moviesWithJan = movies.stream()
                .filter(f -> f.getActorList().contains("Jan"))
                .collect(Collectors.toList());
        System.out.println(moviesWithJan.size());

        List<String>moviesUpperCase = movies.stream()
                .filter(f -> f.getActorList().contains("Jan"))
                .map(f-> f.getTitle())
                .map(f -> f.toUpperCase())
                .collect(Collectors.toList());

    }

}
