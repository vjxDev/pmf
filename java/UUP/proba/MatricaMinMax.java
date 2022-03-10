public class MatricaMinMax {
	static int NizMin(int[][] Niz) {
		int min = Niz[0][0];
		for(int i = 0; i < Niz.length; i++) {
			for(int j = 0; j < Niz[i].length; j++) {
				if(min > Niz[i][j])
					min = Niz[i][j];
			}
		}
		return min;
	}
	static int NizMax(int[][] Niz) {
		int max = Niz[0][0];
		for(int i = 0; i < Niz.length; i++) {
			for(int j = 0; j < Niz[i].length; j++) {
				if(max < Niz[i][j])
					max = Niz[i][j];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int n;
		do {
			n = Svetovid.in.readInt("Unesite n");
		} while(!(n>0));
		
		int A[][] = new int[n][n];
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i].length; j++) {
				A[i][j] = Svetovid.in.readInt("A["+i+"]["+j+"]= ");
			}
		}
		
		int min = NizMin(A);
		int max = NizMax(A);
		Svetovid.out.println("Min je " + min);
		Svetovid.out.println("Max je " + max);
	}
}
