public class TVZ2 {
  public static void main(String[] args) {
    int broj, sum = 0;
    do {
      broj = Svetovid.in.readInt("Unesite prirodan broj ");
    } while (broj <= 0);

    while (broj != 0) {
      // Svetovid.out.println(broj % 10);
      sum += broj % 10;
      broj /= 10;
    }
    Svetovid.out.print(sum);
  }
}
