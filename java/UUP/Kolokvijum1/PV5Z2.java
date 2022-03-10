public class PV5Z2 {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n broj elementa");
    } while (!(0 < n));

    int max = 0;
    int A[][] = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("Realan broj A[" + i + "][" + j + "]=");
        if (i == 0 && j == 0) {
          max = A[i][j];
        }
        if (max < A[i][j]) {
          max = A[i][j];
        }
      }
    }

    Svetovid.out.println("Najveci elent je " + max);
  }
}
