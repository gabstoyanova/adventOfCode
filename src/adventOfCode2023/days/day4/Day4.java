package adventOfCode2023.days.day4;

import adventOfCode2023.Day;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 extends Day {

  public static void main(String[] args) {
    Day4 day4 = new Day4();
    System.out.println(day4.part1());
//    System.out.println(day4.part2());
  }

  @Override
  public Object part1() {
    var input = readInputFile("src/adventOfCode2023/days/day4/input");
    assert input != null;
    return input.map(this::splitGameParts)
      .mapToDouble((gameParts) -> calculateCardPoints(gameParts.get(0), gameParts.get(1)))
      .sum();
  }

  @Override
  public Object part2() {
    return null;
  }

  List<List<Integer>> splitGameParts(String game) {
    game = game.replaceFirst(game.split(":")[0], "");
    String[] gameParts = game.split("\\| ");

    gameParts[0] = gameParts[0].replaceFirst(": ", "");
    List<Integer> winningNumbers = extractCardNumbers(gameParts[0]);
    List<Integer> cardNumbers = extractCardNumbers(gameParts[1]);
    return List.of(winningNumbers, cardNumbers);
  }

  double calculateCardPoints(List<Integer> cardNumbers, List<Integer> winningNumbers) {
    int points = 0;
    for (int cardNumber : cardNumbers) {
      if (winningNumbers.contains(cardNumber)) {
        points += 1;
      }
    }
    return points > 0 ? Math.pow(2, points - 1) : 0;
  }

  List<Integer> extractCardNumbers(String numbers) {
    return Arrays.stream(numbers
        .split(" "))
      .filter(it -> !it.isEmpty())
      .map(Integer::parseInt).collect(Collectors.toList());
  }

}
