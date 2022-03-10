public class NizZadatak3 {

  public static void main(String[] args) {

    String s = Svetovid.in.readLine("Unesite string s \n");
    s = s.toUpperCase();

    int Slova[] = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char karatker = s.charAt(i);
      if ('A' <= karatker && karatker <= 'Z') {
        Slova[karatker - 'A']++;
      }
    }

    for (int i = 0; i < Slova.length; i++) {
      char c = (char) ((int) 'A' + i);
      Svetovid.out.print(c + "  ");

      for (int j = 0; j < Slova[i]; j++) {
        Svetovid.out.print("*");
      }
      Svetovid.out.println("");
    }

  }
}
