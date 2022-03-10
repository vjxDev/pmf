public class NizZadatak1 {

  static int[][] readArray2d(int n) {
    int A[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        A[i][j] = Svetovid.in.readInt("A[" + i + "][" + j + "]");
      }
    }
    return A;
  }

  static boolean simetrijaPoGlavnojDiagonali(int A[][], int n) {
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (A[i][j] != A[j][i]) {
          return false;
        }
      }
    }
    return true;

  }

  static boolean simetrijaPoSporednojDiagonali(int A[][], int n) {

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (A[i][j] != A[n - 1 - j][n - 1 - i]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int n;

    do {
      n = Svetovid.in.readInt("Unesi n (n<20)");
    } while (!(n < 20));

    int A[][] = readArray2d(n);

    if (simetrijaPoGlavnojDiagonali(A, n)) {
      Svetovid.out.println("Niz je simetrcan po glavnoj diagolali");
    } else {
      Svetovid.out.println("Niz nije simetrcan po glavnoj diagolali");
    }

    if (simetrijaPoSporednojDiagonali(A, n)) {
      Svetovid.out.println("Niz je simetrcan po sporednoj diagolali");
    } else {
      Svetovid.out.println("Niz nije simetrcan po sporednoj diagolali");
    }

  }
}
