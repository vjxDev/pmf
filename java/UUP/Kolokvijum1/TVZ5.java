public class TVZ5 {
  public static void main(String[] args) {
    int cifra, brParni = 0, brNeparni = 0;
    cifra = Svetovid.in.readInt();

    while (cifra != 0) {
      if (cifra % 2 == 0) {
        brParni++;
      } else {
        brNeparni++;
      }
      cifra = Svetovid.in.readInt("Unesite broj:");
    }
    ;
    Svetovid.out.println("Parni:" + brParni);
    Svetovid.out.println("Neparni:" + brNeparni);

  }
}
