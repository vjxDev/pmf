public class Homogena {
  static int[][] readArray2d(int n) {
    int A[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + "][" + j + "]");
      }
    }
    return A;
  }

  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n");
    } while (!(0 < n));
    boolean homogena = false;
    boolean poluhomogena = true;
    boolean heterogena = true;

    int A[][] = readArray2d(n);
    int a = A[0][0], b = A[0][1];
    for (int i = 0; i < n && poluhomogena; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          if (a != A[i][j]) {
            poluhomogena = false;

          }
        } else {
          if (b != A[i][j]) {
            poluhomogena = false;
          }
        }
      }
    }
    if (poluhomogena && a == b) {
      homogena = true;
    }

    if (homogena) {
      Svetovid.out.println("Homogena");
    } else if (poluhomogena) {
      Svetovid.out.println("Poluhomogena");
    } else {
      Svetovid.out.println("Heterogena");
    }

  }
}
