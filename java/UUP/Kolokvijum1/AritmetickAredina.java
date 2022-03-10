

public class AritmetickAredina {
	
	public static void main (String[] args) {
		int prvi, drugi;
		double rezultat;
		
		Svetovid.out.print("Unesite prvi broj");
		prvi = Svetovid.in.readInt();
		drugi = Svetovid.in.readInt("Unesite grugi broj");
		
		rezultat = (prvi+drugi)/2.0;
		
		Svetovid.out.println("Rezultet je" + rezultat);
	}
}

