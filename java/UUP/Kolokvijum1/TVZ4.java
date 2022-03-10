public class TVZ4 {
  public static void main(String[] args) {

    int broj;
    do {
      broj = Svetovid.in.readInt("Unesite prirodan broj ");
    } while (broj <= 0);

    while (broj != 0) {
      Svetovid.out.print(broj % 10);
      broj /= 10;
    }
  }
}
