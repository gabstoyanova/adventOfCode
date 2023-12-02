package adventOfCode2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public abstract class Day {

  public abstract Object part1();

  public abstract Object part2();

  public static Stream<String> readInputFile(String pathName) {
    try {
      Path path = Path.of(pathName).toAbsolutePath();
      return Files.lines(path);
    } catch (IOException e) {
      return null;
    }
  }

}
