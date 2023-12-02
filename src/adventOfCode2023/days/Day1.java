package adventOfCode2023.days;

import adventOfCode2023.Day;

import java.util.Scanner;

public class Day1 extends Day {
  public static void main(String[] args) {
    System.out.println("Provide the task input please: ");
    Scanner s = new Scanner(System.in);
    while (s.hasNextLine()) {
      String line = s.nextLine();
      if (line.isEmpty()) {
        break;
      }
      input += line + "\n";
    }
    Day1 day1 = new Day1();
    System.out.println(day1.part1());
  }


  @Override
  public Object part1() {

    int sum = 0;
    for (String s : input.split("\n")) {
      if (s == null) {
        continue;
      }
      char first = 0;
      for (int i = 0; i < s.length(); i++) {
        if (!Character.isAlphabetic(s.charAt(i))) {
          first = s.charAt(i);
          break;
        }
      }
      char last = 0;
      for (int i = s.length() - 1; i > -1; i--) {
        if (!Character.isAlphabetic(s.charAt(i))) {
          last = s.charAt(i);
          break;
        }
      }
      sum += Integer.parseInt(first + "" + last);
    }
    return Integer.toString(sum);
  }

  @Override
  public Object part2() {
    return null;
  }

}
