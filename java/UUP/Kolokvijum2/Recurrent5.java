/* Napisati program koji za date cele brojeve n, 0 <= n <= 50, i r, 2 <= r <= 20,
   ispisuje vrednost elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
   f_n = f_n-1 - g_n-2 + f_n-r - g_n-r, n >= r
   g_n = g_n-1 + f_n-2 - f_n-r - g_n-r, n >= r
   f_n = 1, 0 <= n < r
   g_n = 2, 0 <= n < r
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */

class Recurrent5 {

  static final int maxN = 50;
  static final int maxR = 20;

  // (a) rekurzivno preko definicije
  static int fRec1(int n, int r) {
    if (n < r)
      return 1;
    else
      return fRec1(n - 1, r) - gRec1(n - 2, r) + fRec1(n - r, r) - gRec1(n - r, r);
  }

  static int gRec1(int n, int r) {
    if (n < r)
      return 2;
    else
      return gRec1(n - 1, r) + fRec1(n - 2, r) - fRec1(n - r, r) - gRec1(n - r, r);
  }

  // (b) rekurzivno pomocu akumulirajuceg parametra
  static int fg(int f[], int g[], int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      f[r] = f[r - 1] - g[r - 2] + f[0] - g[0];
      g[r] = g[r - 1] + f[r - 2] - f[0] - g[0];
      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }
      return fg(f, g, i + 1, n, r);
    }
  }

  static int fRec2(int n, int r) {
    int f[] = new int[r + 1];
    int g[] = new int[r + 1];
    if (n < r)
      return 1;
    else {
      for (int j = 0; j < r; j++) {
        f[j] = 1;
        g[j] = 2;
      }
      return fg(f, g, r, n, r);
    }
  }

  // (c) iterativno
  static int fIter(int n, int r) {
    // n=8, r=8
    if (n < r)
      return 1;
    int f[] = new int[r + 1];
    int g[] = new int[r + 1];
    for (int i = 0; i < r; i++) {
      f[i] = 1;
      g[i] = 2;
    }

    for (int i = r; i <= n; i++) {
      f[r] = f[r - 1] - g[r - 2] + f[0] - g[0];
      g[r] = g[r - 1] + f[r - 2] - f[0] - g[0];

      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }
    }

    return f[r];
  }

  public static void main(String[] args) {
    System.out.print("Unesite n (0 <= n <= " + maxN + "): ");
    int n = Svetovid.in.readInt();
    System.out.print("Unesite r (2 <= r <= " + maxR + "): ");
    int r = Svetovid.in.readInt();
    if (0 <= n && n <= maxN && 2 <= r && r <= maxR) {
      System.out.println("fRec1(n, r) = " + fRec1(n, r));
      System.out.println("fRec2(n, r) = " + fRec2(n, r));
      System.out.println("fIter(n, r) = " + fIter(n, r));
    } else {
      System.out.println("n i/ili r je van dozvoljenih granica");
    }
  }
}