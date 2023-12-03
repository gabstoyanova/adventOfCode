package adventOfCode2023.days.day2;

import adventOfCode2023.Day;

import java.util.HashMap;
import java.util.Map;

public class Day2 extends Day {

  public static void main(String[] args) {
    Day2 day2 = new Day2();
    System.out.println(day2.part1());
//    System.out.println(day2.part2());
  }

  @Override
  public Object part1() {
    var input = readInputFile("src/adventOfCode2023/days/day2/input");
    return input.filter(Day2::checkGameValidity).mapToInt(Day2::getGameNumber).sum();
  }

  @Override
  public Object part2() {
    return null;
  }

  public static int getGameNumber(String line) {
    return Integer.parseInt(line.split(": ")[0].replace("Game ", ""));
  }

  public static boolean checkGameValidity(String line) {
    boolean valid = true;

    String[] sets = line.split(";");
    for (String set : sets) {
      String[] words = set.replace(",", "").split(" ");
      Map<Color, Integer> countedCubesPerSetPart = countCubesByColor(words);
      if (!checkSetValidity(countedCubesPerSetPart)) {
        valid = false;
        break;
      }
    }

    return valid;
  }

  static Map<Color, Integer> countCubesByColor(String[] words) {
    Map<Color, Integer> cubesCount = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      switch (words[i]) {
        case "green":
          cubesCount.put(Color.GREEN, Integer.parseInt(words[i - 1]));
          break;
        case "red":
          cubesCount.put(Color.RED, Integer.parseInt(words[i - 1]));
          break;
        case "blue":
          cubesCount.put(Color.BLUE, Integer.parseInt(words[i - 1]));
          break;
      }
    }
    return cubesCount;
  }

  static boolean checkSetValidity(Map<Color, Integer> countedCubes) {
    for (Map.Entry<Color, Integer> entry : countedCubes.entrySet()) {
      if (entry.getKey().getLimit() < entry.getValue()) {
        return false;
      }
    }
    return true;
  }

}
