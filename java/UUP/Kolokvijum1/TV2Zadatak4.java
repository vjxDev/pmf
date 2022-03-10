public class TV2Zadatak4 {
  public static void main(String[] args) {
    int prvi, drugi;

    do {
      prvi = Svetovid.in.readInt("Unesite prvi");
    } while (prvi <= 0);

    do {
      drugi = Svetovid.in.readInt("Unesite drugi");
    } while (drugi <= 0);

    while (prvi != drugi) {
      if (prvi > drugi) {
        prvi -= drugi;
      } else {
        drugi -= prvi;
      }
    }
    Svetovid.out.println("Najveci zjednicki deljitelj 534" + prvi);
  }
}
