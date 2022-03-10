public class NizZadatak2 {

  static int[] readArray(int n, String ime) {
    int A[] = new int[n];
    for (int i = 0; i < n; i++) {
      A[i] = Svetovid.in.readInt(ime + "[" + i + "]");
    }
    return A;
  }

  public static void main(String[] args) {
    int n;

    do {
      n = Svetovid.in.readInt("Unesi n ");
    } while (!(n < 0));

    int A[] = readArray(n, "A");
    int B[] = readArray(n, "B");

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int t = A[i] % B[j];
        if (t == 0)
          Svetovid.out.println("(" + A[i] + "," + B[j] + ")");
      }
    }

  }
}
