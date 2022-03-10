public class PV2Test2 {
  public static void main(String[] args) {
    int broj;
    boolean prost = true;

    do {
      broj = Svetovid.in.readInt("Unesite prirodan broj ");
    } while (broj <= 0);

    for (int i = 2; i <= Math.sqrt(broj); i++) {
      if (broj % i == 0) {
        prost = false;
      }
    }

    if (prost) {
      Svetovid.out.println("Broj je prost");
    } else {
      Svetovid.out.println("Broj nije prost");
    }
  }
}
