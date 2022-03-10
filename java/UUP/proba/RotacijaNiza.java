import org.svetovid.Svetovid;

public class RotacijaNiza {
  static String[][] readArray(int n, int m) {
    String A[][] = new String[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        A[i][j] = Svetovid.in.readLine("A[" + i + "]");
      }
    }

    return A;
  }

  static void printArray(String A[][], int m, int n) {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        Svetovid.out.print(A[i][j] + "  ");
      }
      Svetovid.out.println("");
    }

  }

  public static void main(String[] args) {
    int m, n;
    do {
      n = Svetovid.in.readInt(" N ");
    } while (!(n > 0));

    do {
      m = Svetovid.in.readInt(" M ");
    } while (!(m > 0));

    String A[][] = readArray(n, m);
    String B[][] = new String[m][n];

    for (int i = 0; i < n; i++) { // Broj redova A
      for (int j = 0; j < m; j++) { // Broj kolona A
        B[m - 1 - j][i] = A[i][j];

        String velika = B[m - 1 - j][i].toUpperCase();
        char ch = velika.charAt(0); // auto Auto AUITo

        switch (ch) {
          case 'A':
          case 'E':
          case 'I':
          case 'O':
          case 'U':
            B[m - 1 - j][i] = velika;
            break;
        }
      }
    }
    printArray(B, n, m);
  }
}
