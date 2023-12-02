package adventOfCode2023.days.day1;

import adventOfCode2023.Day;

public class Day1 extends Day {
  public static void main(String[] args) {
    Day1 day1 = new Day1();
    System.out.println(day1.part1());
  }

  public static int calculateLineNumber(String line) {
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

  @Override
  public Object part1() {
    var input = readInputFile("src/adventOfCode2023/days/day1/input");

    return "Part 1: " + input.mapToInt(Day1::calculateLineNumber).sum();
  }

  @Override
  public Object part2() {
    return null;
  }

}
