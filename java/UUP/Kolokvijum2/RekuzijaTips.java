public class RekuzijaTips {
  /*
   * Zadatak
   * Za unete n i r (0<=n<=25) (5<=r<=20) izracunati vrednosti celobrojnog niza
   * f_n
   * 
   * f_n = |f_n-r - g_n-1| n>=r, n deljvo sa 5
   * f_n = g_n-3 + f_n-1 n>=r, n nije deljvo sa 5
   * f_n = 3r-2 n<r
   * 
   * g_n = g_n-r + f_n-2 g_n-r+1 n>=r, n+r deljivo sa 6
   * g_n = f_n-r + g_n-2 f_n-r+1 n>=r, n+r pri deljenju sa 6 daje ostatak 6
   * g_n = max(f_n-r+2, g_n-r+1) n>=r, inace
   * g_n = (-1)^n - n n<r
   */

  /*
   * Ovo su ivicni uslovi za
   * za f
   * f_n = 3r-2
   * 
   * za g
   * g_n = (-1)^n - n
   * 
   * oni su bitni za rad iterativno i rad preko akumulacionih parametara
   */

  // Rekurzija preko definicije
  // Radis kako je napisano i pratis uslove

  public static int fDef(int n, int r) {
    // * f_n = |f_n-r = g_n-1| n>=r, n deljvo sa 5
    // * f_n = g_n-3 + f_n-1 n>=r, n nije deljvo sa 5
    // * f_n = 3r-2 n<r

    if (n >= r) { // n>=r
      if (n % 5 == 0) { // n deljvo sa 5
        // f_n = |f_n-r = g_n-1|
        return Math.abs(fDef(n - r, r) - gDef(n - 1, r));
      } else {
        // f_n = g_n-3 + f_n-1
        return -gDef(n - 3, r) + fDef(n - 1, r);
      }
    } else {
      // f_n = 3r-2
      return 3 * r - 2;
    }
  }

  public static int gDef(int n, int r) {
    // * g_n = g_n-r + f_n-2 g_n-r+1 n>=r, n+r deljivo sa 6
    // * g_n = f_n-r + g_n-2 f_n-r+1 n>=r, n+r pri deljenju sa 6 daje ostatak 6
    // * g_n = max(f_n-r+2, g_n-r+1) n>=r, inace
    // * g_n = (-1)^n-n n<r

    if (n >= r) { // n>=r
      if ((n + r) % 6 == 0) { // n+r deljivo sa 6
        // g_n = g_n-r + f_n-2 g_n-r+1
        return gDef(n - r, r) + fDef(n - 2, r) * gDef(n - r + 1, r);
      } else if ((n + r) % 6 == 1) { // n+r pri deljenju sa 6 daje ostatak 6
        // g_n = f_n-r + g_n-2 f_n-r+1
        return fDef(n - r, r) + gDef(n - 2, r) * fDef(n - r + 1, r);
      } else { // inace
        // g_n = max(f_n-r+2, g_n-r+1)
        return Math.max(fDef(n - r + 2, r), gDef(n - r + 1, r));
      }
    } else {
      // g_n = (-1)^n-n
      return (int) Math.pow(-1, n) - n;
    }
  }

  /*
   * Rad preko akumulacionih parametara
   * 
   * Ivicni uslovi odnosni (n<r)
   * za f
   * f_n = 3r-2
   * 
   * za g
   * g_n = (-1)^n - n
   * 
   * oni su bitni za rad iterativno i rad preko akumulacionih parametara
   */
  static final int R_MAX = 20;

  static int fRek(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];

    if (n < r) { // Ivicni uslov (n<r) 1️⃣
      return 3 * r - 2;
    } else { // Radi se popunjavanj niza sa ivicnim uslovima 2️⃣
      for (int i = 0; i < r; i++) {
        f[i] = 3 * r - 2; // popunjava se niz f sa ivicnim uslov
        g[i] = (int) Math.pow(-1, i) - i; // popunjava se niz g sa ivicnim uslov
      }
      return fg(f, g, r, n, r);
    }
  }

  static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n) { // Ovo je uvek isto
      return f[r]; // Ovo je uvek isto
    } else {
      // Ivicne uslove za f i g su vec uracunati,
      // sad je nephodno da se iracuna sve ostalo

      // !!!!!!!!!!!!!! 3️⃣8
      // Ovde se n menja sa r, odnosno za funciju
      //
      // g_n = g_n-r + f_n-2 * g_n-r+1 to je
      // g[r] = g[0] + f[r - 2] * g[1];
      //
      // n-r postaje 0
      // n-2 postaje r-2
      // n-r+1 posaje 1
      // !!!!!!!!!!!!!!

      // racunanje f
      if (i % 5 == 0) { // deljivo sa 5
        // f_n = |f_n-r - g_n-1|
        f[r] = Math.abs(f[0] - g[r - 1]);
      } else {
        // f_n = g_n-3 + f_n-1
        f[r] = -g[r - 3] + f[r - 1];
      }

      // racunanje g
      if ((i + r) % 6 == 0) { // deljivo sa 6
        // g_n = g_n-r + f_n-2 g_n-r+1
        g[r] = g[0] + f[r - 2] * g[1];
      } else if ((i + r) % 6 == 1) { // ostatak pri deljenu sa 6 je 1
        // g_n = f_n-r + g_n-2 f_n-r+1
        g[r] = f[0] + g[r - 2] * f[1];
      } else {
        // g_n = max(f_n-r+2, g_n-r+1)
        g[r] = Math.max(f[2], g[1]);
      }

      // siftovanje je uvek nephodno
      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }
    }
    return fg(f, g, i + 1, n, r); // Ovo je uvek isto
  }

  // Rad iterativno

  // Dosta stvari je isto kao kad se radi sa akumulacionim parametrima

  static int fIter(int n, int r) {
    if (n < r) { // Provera ivicnog slucaja, isto kao i ⬆️ 1️⃣
      return 3 * r - 2;
    }

    int[] f = new int[R_MAX + 1];
    int[] g = new int[R_MAX + 1];

    for (int i = 0; i < r; i++) { // Popunjavanj niza sa ivicnim vrednostima, ⬆️ 2️⃣
      f[i] = 3 * r - 2;
      g[i] = (int) Math.pow(-1, i) - i;
    }

    // !!!!!!!!!!!
    // Ovde imamo for petlju koja pocinje od r
    // petlja se vrti do i <= n
    // !!! int i = r; i <= n; i++ !!!
    // !!!!!!!!!!!
    for (int i = r; i <= n; i++) {

      // Objasnjeje za ovaj unutrasnji deo koda je isti kao 3️⃣
      if (i % 5 == 0) {
        f[r] = Math.abs(f[0] - g[r - 1]);
      } else {
        f[r] = -g[r - 3] + f[r - 1];
      }

      if ((i + r) % 6 == 0) {
        g[r] = g[0] + f[r - 2] * g[1];
      } else if ((i + r) % 6 == 1) {
        g[r] = f[0] + g[r - 2] * f[1];
      } else {
        g[r] = Math.max(f[2], g[1]);
      }

      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }

    }
    return f[r]; // vraca se f[r] bitno
  }

  public static void main(String[] args) {
    int n, r;
    do {
      n = Svetovid.in.readInt("Unesite n ( 0<=n<=25 )");
    } while (!(0 <= n && n <= 25));
    do {
      r = Svetovid.in.readInt("Unesite n ( 5<=n<=20 )");
    } while (!(5 <= r && r <= 20));

    Svetovid.out.println("Resenje preko definicje je " + fDef(n, r));
    Svetovid.out.println("Resenje preko aku parametra je " + fRek(n, r));
    Svetovid.out.println("Resenje preko aku parametra je " + fIter(n, r));

  }

}
