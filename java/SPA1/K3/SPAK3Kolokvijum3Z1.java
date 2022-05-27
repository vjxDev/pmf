import java.util.LinkedList;

public class SPAK3Kolokvijum3Z1 {

  public static LinkedList<Double> readListFromFile(String f) {
    LinkedList<Double> list = new LinkedList<Double>();
    if (!Svetovid.testIn(f))
      return null;
    while (Svetovid.in(f).hasMore()) {
      double line = Svetovid.in(f).readDouble();
      list.add(line);
    }
    Svetovid.in(f).close();
    return list;
  }

  public static boolean printListToFile(LinkedList<Double> list, String f) {
    if (!Svetovid.testOut(f)) {
      return false;
    }
    for (Double item : list) {
      Svetovid.out(f).println(item);
    }
    Svetovid.out(f).close();
    return true;
  }

  public static void main(String[] args) {
    // String path = Svetovid.in.readLine("Unesite lokaciju fajla liste");

    LinkedList<Double> list = readListFromFile("java/f/k3list.txt");
    Svetovid.out.println(list);
    double toFind = Svetovid.in.readDouble("Unesite broj koji se trazi");
    int index = list.indexOf(toFind);
    if (list.size() > index + 1 && index != -1) {
      double el1 = list.get(index), el2 = list.get(index + 1);
      Svetovid.out.println(el2);
      list.addFirst(el2);
      list.addFirst(el1);
    }
    Svetovid.out.println(list);

    // path = Svetovid.in.readLine("Unesite lokaciju izlaznog fajla");
    printListToFile(list, "java/f/outk3list.txt");
  }
}
