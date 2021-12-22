package dev.vkekukh;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {

    public Stream<String> generateEmptyStream() {
        return Stream.empty();
    }

    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    public Stream<String> streamOfCollection() {
        Collection<String> collection = Arrays.asList("a", "b", "c");
        return collection.stream();
    }

    public Stream<String> streamOfArray() {

        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);

        return streamOfArray;
    }

    public Stream<String> builder() {
        return Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .build();
    }

    public static Stream<String> streamGenerated() {
        return Stream.generate(() -> "element").limit(10);
    }

    public static Stream<Integer> iterate() {
        return Stream.iterate(40, n -> 2 * n).limit(25);
    }


    public IntStream getIntStream() {
        return IntStream.range(1, 3);
    }


    public LongStream getRangeClosed() {
        return LongStream.rangeClosed(1, 3);
    }

    private DoubleStream getDoubleStream() {
        return new Random().doubles(3);
    }

    private Stream<String> getStringStream() {
        return Pattern.compile(", ").splitAsStream("a, b, c");
    }
}
