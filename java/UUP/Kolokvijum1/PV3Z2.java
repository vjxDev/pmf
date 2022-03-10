public class PV3Z2 {

  public static void main(String[] args) {
    int n = 0, i, sum = 0, a;
    do {
      a = Svetovid.in.readInt("Unesite broj a");

    } while (a < 1);

    for (i = 1; sum < a; i++) {
      sum += i;
      if (sum < a) {
        n++;
      }

    }

    Svetovid.out.println(" broj n je: " + n);

  }

}
