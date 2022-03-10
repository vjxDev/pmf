public class TVZ3 {
  public static void main(String[] args) {
    int broj = (int) ((Math.random() * 100) + 1), x, br = 0;
    do {
      x = Svetovid.in.readInt("Pretpostavi broj Broj");
      br++;

      if (broj > x) {
        Svetovid.out.println("Broj je veci od " + x);
      } else if (broj < x) {
        Svetovid.out.println("Broj je manji od " + x);
      }
    } while (broj != x);

    Svetovid.out.println("Pogodili ste broj " + broj + "iz " + br + " pokusaja");
  }
}
