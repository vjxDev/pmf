public class PV6testZ1 {

  public static void main(String[] args) {

    int n;
    do {
      n = Svetovid.in.readInt("Unesite 1 <= n <= 20");
    } while (!(1 <= n && n <= 20));

    int[][] A = new int[n][n];
    int m = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + "][" + j + "] = ");
        if (i == 0 && j == 0) {
          m = A[i][j];
        }
        if (i == j && m < A[i][j]) {
          m = A[i][j];
        }
      }
    }
    int br = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j && m > A[i][j]) {
          br++;
        }
      }
    }

    Svetovid.out.println("Maksimalni elemet glavne diagonale je " + m
        + ". Broj elementa van dijagonale koji su strogo manji od " + m + ": " + br);

  }
}
