import java.util.ArrayList;
import java.util.LinkedList;

public class SPAK3Z1 {

  public static LinkedList<String> readListFromFile(String f) {
    LinkedList<String> list = new LinkedList<String>();
    if (!Svetovid.testIn(f))
      return null;
    while (Svetovid.in(f).hasMore()) {
      String line = Svetovid.in(f).readLine();
      list.add(line);
    }
    Svetovid.in(f).close();

    return list;
  }

  public static boolean printListToFile(LinkedList<String> list, String f) {
    if (!Svetovid.testOut(f)) {
      return false;
    }
    for (String item : list) {
      Svetovid.out(f).println(item);

    }
    Svetovid.out(f).close();
    return true;
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("Ana");
    list.add("Lana");
    list.add("Jana");
    list.add("Mina");

    Svetovid.out.println(list);
    String prevName = list.set(3, "Lidija");
    Svetovid.out.println(prevName);
    Svetovid.out.println(list);

    for (int i = 0; i < list.size(); i += 2) {
      Svetovid.out.println(list.get(i));
    }
    for (String item : list) {
      if (item.startsWith("S")) {
        Svetovid.out.println(item);
      }
    }
    Svetovid.out.println("-- Izbaci --");
    list.remove(2);
    Svetovid.out.println(list);

    String s = Svetovid.in.readLine("Uneste ime koje zelite da izbacite");
    list.remove(s);
    Svetovid.out.println(list);

    LinkedList<String> listFromFile = readListFromFile("java/f/imena.txt");
    Svetovid.out.println(listFromFile);

    for (String string : list) {
      listFromFile.add(string);
    }
    Svetovid.out.println(listFromFile);

    printListToFile(listFromFile, "java/f/randomlista.txt");

  }
}
