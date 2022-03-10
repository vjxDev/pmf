class Zadatak1 {
  public static void main(String[] args) {
    int n, min;
    do {
      n = Svetovid.in.readInt("Unesite prirodan broj n:");
    } while (n <= 0);

    min = Svetovid.in.readInt("Unesite broj");

    for (int i = 2; i <= n; i++) {
      int x = Svetovid.in.readInt("Unesite broj");
      if (min > x) {
        min = x;
      }
    }
    Svetovid.out.println(min);
  }
}