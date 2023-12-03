package adventOfCode2023.days.day3;

import adventOfCode2023.Day;

import java.util.Arrays;

public class Day3 extends Day {

  public static void main(String[] args) {
    Day3 day3 = new Day3();
    System.out.println(day3.part1());
//    System.out.println(day3.part2());
  }

  @Override
  public Object part1() {
    var input = readInputFile("src/adventOfCode2023/days/day3/input");
    assert input != null;
    char[][] inputMatrix = input.map(String::toCharArray).toArray(char[][]::new);


    System.out.println(Arrays.deepToString(inputMatrix));
    return findEngineSchematicNumbers(inputMatrix);
  }

  @Override
  public Object part2() {
    return null;
  }

  private int findEngineSchematicNumbers(char[][] inputMatrix) {
    int sum = 0;
    for (int row = 0; row < inputMatrix.length; row++) {

      int i = 0;
      while (i < inputMatrix[0].length) {

        if (Character.isDigit(inputMatrix[row][i])) {
          int j = 1;
          String number = String.valueOf(inputMatrix[row][i]);

          while (i + j < inputMatrix[0].length && Character.isDigit(inputMatrix[row][i + j])) {
            number += inputMatrix[row][i + j];
            j++;
          }

          boolean isAdjacent = false;

          // check neighbours
            // check upper row
            if (row - 1 >= 0) {
              for (int k = i - 1; k <= i + j; k++) {
                if (k >= 0 && k < inputMatrix[0].length) {
                  if (isSymbol(inputMatrix[row - 1][k])) {
                    isAdjacent = true;
                    break;
                  }
                }
              }
            }

            // check lower row
            if (row + 1 < inputMatrix.length) {
              for (int k = i - 1; k <= i + j; k++) {
                if (k >= 0  && k < inputMatrix[0].length) {
                  if (isSymbol(inputMatrix[row + 1][k])) {
                    isAdjacent = true;
                    break;
                  }
                }
              }
            }

          // check left side
          if (i - 1 >= 0) {
            if (isSymbol(inputMatrix[row][i - 1])) {
              isAdjacent = true;
            }
          }

          // check right side
          if (i + j < inputMatrix[row].length) {
            if (isSymbol(inputMatrix[row][i + j])) {
              isAdjacent = true;
            }
          }

          if (isAdjacent) {
            sum += Integer.parseInt(number);
          }

          i += j + 1;
        } else {
          i += 1;
        }
      }
    }
    return sum;
  }

  boolean isSymbol(Character character) {
    return character != '.';
  }




}
