public class PV2Test3 {
  public static void main(String[] args) {
    int broj, cifra, brProstihCifra = 0;

    do {
      broj = Svetovid.in.readInt("Unesite prirodan broj ");
    } while (broj <= 0);

    while (broj > 0) {
      cifra = broj % 10;
      boolean prost = true;

      for (int i = 2; i <= cifra / 2; i++) {
        if (cifra % i == 0) {
          prost = false;
        }
      }
      if (prost) {
        brProstihCifra++;
      }

      broj = broj / 10;
    }

    Svetovid.out.println("Broj ima " + brProstihCifra + " proste cifra.");

  }
}
