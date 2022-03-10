// 3. Napisati program koji određuje 
//optimalnu isplatu zadate svote novca 
//u apoenima od 1, 2, 5, 10, 20, 50 i 100 dinara.

public class Poeni {
	
	public static void main (String[] args) {
		int unos, n1=0,n2=0,n5=0,n10=0,n20=0,n50=0,n100=0;
		unos = Svetovid.in.readInt("Unesite kolicinu novca");
		
		n100 = unos / 100; // 220  2
		unos = unos%100; // 220 - 200
		
		n50 = unos / 50;
		unos = unos%50;
		
		n20 = unos / 20;
		unos = unos%20;
		
		n10 = unos / 10;
		unos = unos%10;
		
		n5 = unos / 5;
		unos = unos%5;
		
		n2 = unos / 2;
		unos = unos%2;
		
		n1 = unos / 1;
		unos = unos%1;
		
		Svetovid.out.println("100:"+n100);
		Svetovid.out.println("50:"+n50);
		Svetovid.out.println("20:"+n20);
		Svetovid.out.println("10:"+n10);
		Svetovid.out.println("5:"+n5);
		Svetovid.out.println("2:"+n2);
		Svetovid.out.println("1:"+n1);
		
	}
}

