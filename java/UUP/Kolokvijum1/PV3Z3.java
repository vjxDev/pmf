//  Napisati program koji učitava broj predstavljen u brojnom sistemu sa osnovom m (2 ≤ m ≤ 10),
// i štampa ga u dekadnom brojnom sistemu

public class PV3Z3 {
  public static void main(String[] args) {
    int osnova, broj;
    // Unos osnove
    do {
      osnova = Svetovid.in.readInt("Unesite osnovu m (2 ≤ m ≤ 10): ");
    } while (!(2 <= osnova && osnova <= 10));

    int sum, cifra = 11;

    boolean greska = false;
    do {
      sum = 0;
      greska = false;
      broj = Svetovid.in.readInt("Unesite broj za pretvaranje, sa osnovom " + osnova);
      for (int br = 0; broj > 0; br++) {
        cifra = broj % 10;

        sum += cifra * Math.pow(osnova, br);

        if (cifra >= osnova) {
          greska = true;
        }
        broj /= 10;
      }
      if (greska) {
        Svetovid.out.println("Greska: Broj nije nije ove osnove");
      }

    } while (greska);

    Svetovid.out.println(sum);
  }
}
