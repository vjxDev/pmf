public class PV2Test1 {
  public static void main(String[] args) {
    int broj;
    boolean prost = true;

    do {
      broj = Svetovid.in.readInt("Unesite prirodan broj ");
    } while (broj <= 0);

    for (int i = 2; i <= broj / 2; i++) {
      if (broj % i == 0) {
        Svetovid.out.println("Broj je deljiv sa: " + i);
        prost = false;
      }
    }

    if (prost) {
      Svetovid.out.println("Broj je prost");
    }
  }
}
