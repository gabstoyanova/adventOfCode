package adventOfCode2023.days.day1;

import adventOfCode2023.Day;

import java.util.List;

public class Day1 extends Day {

  private static final List<String> numbers = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

  public static void main(String[] args) {
    Day1 day1 = new Day1();
    System.out.println(day1.part1());
    System.out.println(day1.part2());
  }

  @Override
  public Object part1() {
    var input = readInputFile("src/adventOfCode2023/days/day1/input");
    return "Part 1: " + input.mapToInt(Day1::calculateCalibrationValue).sum();
  }

  @Override
  public Object part2() {
    var input = readInputFile("src/adventOfCode2023/days/day1/input");
    return "Part 2: " + input.map(Day1::convertLineToNumbers).mapToInt(Day1::calculateCalibrationValue).sum();
  }

  public static int calculateCalibrationValue(String line) {
    char first = 0;
    for (int i = 0; i < line.length(); i++) {
      if (!Character.isAlphabetic(line.charAt(i))) {
        first = line.charAt(i);
        break;
      }
    }
    char last = 0;
    for (int i = line.length() - 1; i > -1; i--) {
      if (!Character.isAlphabetic(line.charAt(i))) {
        last = line.charAt(i);
        break;
      }
    }
    return Integer.parseInt(first + "" + last);
  }

  private static String convertLineToNumbers(String line) {
    for (int i = 0; i < numbers.size(); i++) {
      var number = numbers.get(i);
      while (line.contains(number)) {
        line = line.replaceFirst(number, "" + number.charAt(0) + (i + 1) + number.charAt(number.length() - 1));
      }
    }
    return line;
  }
}
