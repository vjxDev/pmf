public class SPAK3Kolokvijum3Z2 {

  public static Stek<Integer> createStack() {
    Stek<Integer> stek = new Stek<Integer>();
    for (int i = 1; i <= 15; i++) {
      stek.stavi(i);
    }

    return stek;
  }

  public static void removeOddFromStek(Stek<Integer> stek) {
    int vrh = stek.skiniVrh();
    while (!stek.jePrazan() && vrh % 2 == 1) {
      vrh = stek.skiniVrh();
    }
    // || stek.jePrazan() u slucaju da je vrh bio poslednji, mora da se vrati zbog
    // "i ako ima još elemenata"
    if (vrh % 2 == 0 || stek.jePrazan())
      stek.stavi(vrh);
  }

  public static void printStek(Stek<Integer> stek) {
    while (!stek.jePrazan()) {
      Svetovid.out.println(stek.skiniVrh());
    }
  }

  public static void main(String[] args) {
    Stek<Integer> stek = createStack();
    removeOddFromStek(stek);
    printStek(stek);
  }
}
