package dev.vkekukh;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {
    List<Optional<String>> listOfOptionals = Arrays.asList(
            Optional.empty(),
            Optional.of("foo"),
            Optional.empty(),
            Optional.of("bar"));

    List<String> filteredList = listOfOptionals.stream()
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());

    List<String> filteredList2 = listOfOptionals.stream()
            .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
            .collect(Collectors.toList());

    List<String> filteredList3 = listOfOptionals.stream()
            .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
            .collect(Collectors.toList());

    //Java 9
    List<String> filteredList4 = listOfOptionals.stream()
            .flatMap(Optional::stream)
            .collect(Collectors.toList());
}

