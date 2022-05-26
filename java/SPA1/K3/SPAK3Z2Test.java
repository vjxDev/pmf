public class SPAK3Z2Test {

  public static Red<String> readQueueFromFile(String f) {
    Red<String> queue = new Red<String>();
    if (!Svetovid.testIn(f))
      return null;
    while (Svetovid.in(f).hasMore() && !queue.jePun()) {
      String line = Svetovid.in(f).readLine();
      queue.naKraj(line);
    }
    Svetovid.in(f).close();

    return queue;
  }

  public static void printQueueToFile(Red<String> q, String f) {
    if (!Svetovid.testOut(f)) {
    }
    while (!q.jePrazan()) {
      Svetovid.out(f).println(q.izbaciPrvi());
    }
    Svetovid.out(f).close();
  }

  public static Stek<Integer> readStackFromFile(String f) {
    Stek<Integer> stek = new Stek<>();
    if (!Svetovid.testIn(f))
      return null;
    while (Svetovid.in(f).hasMore() && !stek.jePun()) {
      stek.stavi(Svetovid.in(f).readInt());
    }
    Svetovid.in(f).close();
    return stek;
  }

  public static void printStekToFile(Stek<Integer> q, String f) {
    if (!Svetovid.testOut(f)) {
    }
    while (!q.jePrazan()) {
      Svetovid.out(f).println(q.skiniVrh());
    }
    Svetovid.out(f).close();
  }

  public static void main(String[] args) {
    Red<String> queue = readQueueFromFile("java/f/r1.txt");
    Svetovid.out.println(queue);

    while (!queue.jePrazan() && queue.prvi().contains("e")) {
      queue.izbaciPrvi();
    }
    Svetovid.out.println(queue);

    String file = "java/f/" + Svetovid.in.readLine();
    printQueueToFile(queue, file);
    Svetovid.out.println("---Deo 2---");

    // drugi deo
    Stek<Integer> stek1 = readStackFromFile("java/f/p1.txt");
    Stek<Integer> stek2 = readStackFromFile("java/f/p2.txt");

    Svetovid.out.println(stek1);
    while (!stek1.jePrazan() && (20 < stek1.vrh() && stek1.vrh() < 30)) {
      stek1.skiniVrh();
    }
    Svetovid.out.println(stek1);
    Svetovid.out.println("------");
    Svetovid.out.println(stek2);
    int vrh = stek1.skiniVrh();
    while (!stek2.jePrazan() && vrh % 2 != stek2.vrh() % 2) {
      vrh = stek2.skiniVrh();
    }
    stek2.stavi(vrh);
    Svetovid.out.println(stek2);

    Svetovid.out.println("------");

    Stek<Integer> stekpp = new Stek<>();

    while (!stek1.jePrazan() || !stek2.jePrazan()) {
      if (!stek1.jePrazan())
        stekpp.stavi(stek1.skiniVrh());
      if (!stek2.jePrazan())
        stekpp.stavi(stek2.skiniVrh());
    }
    Svetovid.out.println(stekpp);

    printStekToFile(stekpp, "java/f/pp.txt");

  }
}
