package adventOfCode2023.days.day2;

public enum Color {
  RED(12),
  GREEN(13),
  BLUE(14);

  private final int limit;

  Color(final int limit) {
    this.limit = limit;
  }

  public int getLimit() {
    return this.limit;
  }

}
