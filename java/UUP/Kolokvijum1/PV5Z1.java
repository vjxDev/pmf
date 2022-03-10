public class PV5Z1 {
  public static void main(String[] args) {
    int n;
    do {
      n = Svetovid.in.readInt("Unesite n<100");
    } while (!(0 < n && n < 100));
    int A[] = new int[n];
    int brPoz = 0, brNeg = 0;

    for (int i = 0; i < n; i++) {

      A[i] = Svetovid.in.readInt("Realan broj A[" + i + "]=");
      if (A[i] > 0) {
        brPoz++;
      }
      if (A[i] < 0) {
        brNeg++;
      }
    }

    String s = "";
    if (brPoz == brNeg) {
      s = "=";
    } else if (brPoz > brNeg) {
      s = ">";
    } else {
      s = "<";
    }
    Svetovid.out.println("Odnos izmedu strogo pozitivni " + s + " strogo negativnim");
  }
}
