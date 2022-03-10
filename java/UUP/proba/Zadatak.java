public class Zadatak {
  public static void main(String[] args) {

    int broj1, broj2, rezultat = 0;
    char znak;

    broj1 = Svetovid.in.readInt("Unesi prvi broj");
    broj2 = Svetovid.in.readInt("Unesi drugi broj");

    znak = Svetovid.in.readChar("Unesi znak");
    if (znak == '+' || znak == '-' || znak == '/') {
      if (znak == '+') {
        rezultat = broj1 + broj2;
      } else if (znak == '-') {
        rezultat = broj1 - broj2;
      } else if (znak == '/') {
        rezultat = broj1 / broj2;
      }
      Svetovid.out.println("Rezultat je: " + rezultat);

    } else {
      Svetovid.out.print("Ne valja");
    }
  }
}
