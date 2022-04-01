public class SPAK2Z3Test {
  public static void main(String[] args) {
    int n = Svetovid.in.readInt("Unestite broj n");
    SSLK2Z3 list = new SSLK2Z3();
    list.print();
    for (int i = 0; i < n; i++) {
      String s = Svetovid.in.readLine("Unesite " + i + " element liste:");
      list.append(s);
    }
    list.print();
    list.printOdd();

    list.print();
    list.removeStartingWithNumber();
    list.print();

    String sub = Svetovid.in.readLine("Unesite subsing za ibacivanje:");
    SSLK2Z3 newList = list.extractToList(sub);
    list.print();
    newList.print();
  }
}

class SSLK2Z3 {

  Element first;

  public SSLK2Z3() {
    this.first = null;
  }

  public void append(String s) {
    Element newNode = new Element(s);
    newNode.succ = first;
    first = newNode;
  }

  public void print() {
    Svetovid.out.println("\nDemostracija* ");
    Element el = first;
    while (el != null) {
      Svetovid.out.println(el.value);
      el = el.succ;
    }
    Svetovid.out.println("--");
  }

  public void printOdd() {
    Element el = first;
    while (el != null) {
      if (el.value.length() % 2 == 1) {
        Svetovid.out.println(el.value);
      }
      el = el.succ;
    }
  }

  public void removeStartingWithNumber() {
    while (first != null && first.value.charAt(0) >= '0' && first.value.charAt(0) <= '9') {
      first = first.succ;
    }
    if (first != null) {
      Element current = first;
      while (current.succ != null) {
        Element prethodni = current;
        current = current.succ;
        if (current.value.charAt(0) >= '0' && current.value.charAt(0) <= '9') {
          prethodni.succ = current.succ;
          current = prethodni;
        }
      }
    }
  }

  public SSLK2Z3 extractToList(String sub) {
    SSLK2Z3 newList = new SSLK2Z3();

    Element newListEnd = null;

    Element current, prev;

    while (first != null && first.value.startsWith(sub)) {
      current = first;
      first = first.succ;
      if (newList.first == null) {
        newList.first = current;
        newListEnd = current;
        current.succ = null;
      } else {
        newListEnd.succ = current;
        current.succ = null;
        newListEnd = current;
      }
    }

    if (first != null) {
      current = first;
      while (current.succ != null) {
        prev = current;
        current = current.succ;
        if (current.value.startsWith(sub)) {
          prev.succ = current.succ;
          if (newList.first == null) {
            newList.first = current;
            current.succ = null;
            newListEnd = current;
          } else {
            newListEnd.succ = current;
            current.succ = null;
            newListEnd = current;
          }
          current = prev;
        }
      }
    }

    return newList;
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