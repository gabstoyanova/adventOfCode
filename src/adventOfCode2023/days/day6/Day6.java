package adventOfCode2023.days.day6;

import adventOfCode2023.Day;

public class Day6 extends Day {

  public static void main(String[] args) {
    Day6 day6 = new Day6();
    System.out.println(day6.part1());
    System.out.println(day6.part2());
  }

  @Override
  public Object part1() {
    var input = readInputFile("src/adventOfCode2023/days/day6/input");
    assert input != null;
    String[] inputArr = input.toArray(String[]::new);

    return calculate(inputArr[0], inputArr[1], 0);
  }


  @Override
  public Object part2() {
    var input = readInputFile("src/adventOfCode2023/days/day6/input");
    assert input != null;
    String[] inputArr = input.toArray(String[]::new);

    return calculate(inputArr[0], inputArr[1], 2);
  }

  private long calculate(final String times, final String distances, final int limit) {
    final String[] timesSplit = times.split("\\s+", limit);
    final String[] distancesSplit = distances.split("\\s+", limit);

    long result = 1;

    for (int i = 1; i < timesSplit.length; i++) {
      long time = Long.parseLong(timesSplit[i].replaceAll("\\s+", ""));
      long distance = Long.parseLong(distancesSplit[i].replaceAll("\\s+", ""));
      int records = 0;
      for (int j = 1; j < time; j++) {
        if (beatsRecord(time, j, distance)) {
          records += 1;
        }
      }
      result *= records;
    }
    return result;
  }

  private boolean beatsRecord(long raceTime, long pressedMillis, long recordRaceDistance) {
    final long remainingTime = raceTime - pressedMillis;
    final long distTravelled = remainingTime * pressedMillis;
    return distTravelled > recordRaceDistance;
  }

}
