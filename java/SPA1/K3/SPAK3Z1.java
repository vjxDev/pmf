import java.util.ArrayList;

public class SPAK3Z1 {

  public static ArrayList<String> readListFromFile(String f) {
    ArrayList<String> list = new ArrayList<String>();
    if (!Svetovid.testIn(f))
      return null;
    while (Svetovid.in(f).hasMore()) {
      String line = Svetovid.in(f).readLine();
      list.add(line);
    }
    Svetovid.in(f).close();

    return list;
  }

  public static boolean printListToFile(ArrayList<String> list, String f) {
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

    ArrayList<String> listFromFile = readListFromFile("java/f/imena.txt");
    Svetovid.out.println(listFromFile);

    printListToFile(list, "java/f/randomlista.txt");

  }
}
