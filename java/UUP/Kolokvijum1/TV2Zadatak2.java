public class TV2Zadatak2 {
  public static void main(String[] args) {
    double a, b, bNaN;
    int n;

    do {
      a = Svetovid.in.readDouble("Unesite a");
    } while (a <= 1.0);

    do {
      b = Svetovid.in.readDouble("Unesite a");
    } while (b <= 1.0);

    n = 0;
    bNaN = 1.0;

    while (a > bNaN) {
      n++;
      bNaN *= b;
    }
    Svetovid.out.println(n - 1);
  }
}
