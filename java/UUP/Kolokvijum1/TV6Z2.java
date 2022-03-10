public class TV6Z2 {
  public static void main(String[] arg) {
    int duz = 5;
    int brojZaNalaz = 2;

    do {
      duz = Svetovid.in.readInt("Unesite duz");
    } while (0 > duz);

    int A[] = new int[duz];
    for (int i = 0; i < A.length; i++) {
      int unos;
      do {
        unos = Svetovid.in.readInt();
      } while (!(i == 0 || unos > A[i]));
      A[i] = unos;
    }
    int levi = 0;
    int desni = A.length - 1;
    boolean nadjen = false;
    do {
      int srednji = (levi + desni) / 2;

      if (brojZaNalaz == A[srednji]) {
        nadjen = true;
      } else if (brojZaNalaz < A[srednji]) {
        desni = srednji - 1;
      } else {
        levi = srednji + 1;
      }
    } while ((desni >= levi) && !nadjen);

    if (nadjen) {
      Svetovid.out.println("Nadjen");
    } else {
      Svetovid.out.println("Nije nadjen");

    }
  }
}
