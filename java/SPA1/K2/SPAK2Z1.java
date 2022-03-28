public class SPAK2Z1 {

  public static void main(String[] args) {
    int n = Svetovid.in.readInt("Unesite broj elemenat liste n");
    SSLK2Z1 list = new SSLK2Z1();
    for (int i = 0; i < n; i++) {
      String s = Svetovid.in.readToken("Unesite elemenat liste broj" + i + ":");
      list.appendAtStart(s);
    }
    list.printStringsLen3();
    String b = Svetovid.in.readToken("Unesite String b za uporedjivanje:");
    int br = list.compoerWithList(b);
    Svetovid.out.println("Broj elmeneta iste duzine je " + br);
    list.printLast();
  }

}

class SSLK2Z1 {
  Element first;

  public SSLK2Z1() {
    this.first = null;
  }

  public void appendAtStart(String s) {
    Element newNode = new Element(s);
    newNode.succ = first;
    first = newNode;
  }

  public void printStringsLen3() {
    Element el = first;
    while (el != null) {
      if (el.value.length() > 3) {
        Svetovid.out.println(el.value);
      }
      el = el.succ;
    }
  }

  public int compoerWithList(String comp) {
    int br = 0;
    Element el = first;
    while (el != null) {
      if (el.value.equals(comp)) {
        br++;
      }
      el = el.succ;
    }

    return br;
  }

  public void printLast() {
    Element el = first;
    while (el != null) {
      if (el.succ == null) {
        Svetovid.out.println("Poslednji element:\n" + el.value);
      }
      el = el.succ;
    }
  }

  class Element {
    String value;
    Element succ;

    public Element(String value) {
      this.value = value;
      this.succ = null;
    }
  }

}
