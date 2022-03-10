public class MatriceMaxDiagonala {
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
      }
    }

    max = A[0][n - 1];
    for (int i = 0; i < n; i++) {
      if (max < A[i][n - 1 - i]) {
        max = A[i][n - 1 - i];
      }
    }

    int brMax = 0;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i][j] == max) {
          brMax++;
        }
      }
    }

    Svetovid.out.println("Najveci elent je " + max + brMax);
  }
}
