public class PV4testZ1 {
  public static void main(String[] args) {
    int temp;
    int a = Svetovid.in.readInt("Unesite celi broj a");
    int b = Svetovid.in.readInt("Unesite celi broj b");

    if (a > b) {
      temp = a;
      a = b;
      b = temp;
    }

    int br = 0;

    int broj = Svetovid.in.readInt("Unesite celi broj tako da je " + a + " <= broj <= " + b);
    int min = broj;

    do {
      if (a > broj || broj > b) {
        break;
      }
      if (min > broj) {
        min = broj;
      }
      broj = Svetovid.in.readInt("Unesite celi broj tako da je " + a + " <= broj <= " + b);
      br++;
    } while (true);

    if (br == 0) {
      Svetovid.out.println("Nijedan broj nije u intervalu i ne postoji minimum");
    } else {
      Svetovid.out.println("Broj unosa u opsegu je " + br + ".\nMinimum je " + min);
    }

  }
}
