public class TV2Zadatak6 {
  public static void main(String[] args) {
    int n;

    do {
      n = Svetovid.in.readInt("Unesite prvi");
    } while (n <= 0);
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        Svetovid.out.print("*");
      }
      Svetovid.out.println();
    }
  }
}
