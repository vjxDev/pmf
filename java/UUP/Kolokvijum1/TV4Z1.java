public class TV4Z1 {
  public static void main(String[] args) {
    String a[] = new String[] { "21", "30", "5" };
    String m[] = new String[] { "21", "30", "5" };
    Object b[];
    Object c;
    String d[] = m;
    b = a;
    c = b;
    d = (String[]) c;
    Svetovid.out.println(a == m, d);

  }
}
