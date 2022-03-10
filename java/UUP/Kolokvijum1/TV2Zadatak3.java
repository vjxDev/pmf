public class TV2Zadatak3 {
  public static void main(String args[]) {
    int n, cifra;
    do {
      n = Svetovid.in.readInt("Unesite n <= 0 ");
    } while (n <= 0);

    do {
      cifra = n % 10;
      n = n / 10;
    } while (n > 0 && cifra % 2 == 0);

    if (cifra % 2 == 0) {
      Svetovid.out.println("Sve cifre broja su parne");
    } else {
      Svetovid.out.println("Cifra " + cifra + " je neparna");

    }
  }
}
