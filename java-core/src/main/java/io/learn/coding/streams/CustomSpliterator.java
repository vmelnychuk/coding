package io.learn.coding.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import io.learn.coding.streams.model.Person;

public class CustomSpliterator {

    public static void main(String[] args) throws URISyntaxException {
        ClassLoader classLoader = CustomSpliterator.class.getClassLoader();
        URL resource = classLoader.getResource("people.txt");
        Path path = Paths.get(resource.toURI());

        try (Stream<String> lines = Files.lines(path)) {
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);

            Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
            people.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("There are no file with path '" + path.toString() + "'");
            e.printStackTrace();
        }
    }
}
