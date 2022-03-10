public class ListP {
  public static void main(String[] args) {
    SSL list = new SSL();
    String s = "hello";
    list.insert(s, null);
    Svetovid.out.println(list);
  }
}

class SSL {
  SSLNode first;

  public SSL() {
    this.first = null;
  }

  public void insetFirst(Object element) {
    SSLNode inst = new SSLNode(element, null);
    inst.succ = this.first;
    this.first = inst;
  }

  public void insert(Object element, SSLNode pred) {
    SSLNode inst = new SSLNode(element, null);
    if (pred == null) {
      inst.succ = this.first;
      this.first = inst;
    } else {
      inst.succ = pred.succ;
      pred.succ = inst;
    }
  }

  public String toString() {
    String s = "";
    SSLNode curr = this.first;
    s += "[";
    while (curr != null) {
      s += curr.element + ",";
      curr = curr.succ;
    }
    s += "]";
    return s;
  }
}

class SSLNode {
  Object element;
  SSLNode succ;

  public SSLNode(Object el, SSLNode succ) {
    this.element = el;
    this.succ = succ;
  }

}