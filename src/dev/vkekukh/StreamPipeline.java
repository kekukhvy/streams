package dev.vkekukh;

import java.util.stream.Stream;

public class StreamPipeline {

    private Stream<String> getSkip() {
        return Stream.of("abcd", "bbcd", "cbcd").skip(1);
    }

    private Stream<String> twiceModifiedStream() {
        return Stream.of("abcd", "bbcd", "cbcd")
                .skip(1)
                .map(element -> element.substring(0, 3));
    }
}
