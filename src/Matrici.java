import java.util.Scanner;
public class Matrici {
	public static void Riempi(int v[][]) {
		for(int i=0;i<v.length;i++) {
			for(int x=0;x<v[0].length;x++) {
				v[i][x]= (int) (Math.random()*51);
			}
		}
		
	}
	public static void Stampa(int v[][]) {
		for(int i=0;i<v.length;i++) {
			for(int x=0;x<v[0].length;x++) {
				System.out.print(" "+v[i][x]);
			}
			System.out.println("");
		}
		
	}
 
	public static void calcMaxMin(int v[][],int v1[][],int row) {
		int max= v[row][0];
		int Mc=1;
		for(int i=1;i<v[0].length;i++) {
			if(max<v[row][i]){
				max= v[row][i];
				Mc++;
			}
		}
		System.out.println("il numero massimo della prima matrice nella riga ("+row+","+Mc+") ed e':"+max+" ");
		int min= v1[row][0];
		int Mm=1;
		for(int i=1;i<v1[0].length;i++) {
			if(min>v1[row][i]){
				min= v1[row][i];
				Mm++;
			}
		}
		System.out.println("il numero minimo della seconda matrice nella riga ("+row+","+Mm+") ed e':"+min+" ");
	}

	public static void mediaRigCol(int v[][],int v1[][],int row,int row1) {
		float media;
		int somma=0;
		int x=0;
		int div=0;
		for(int i=0;i<v[0].length;i++) {
			somma=somma+(v[row][i]+v1[row1][x]);
			x++;
			div=div+2;
			}
			
		System.out.println(""+div);
		System.out.println(""+somma);
		media=somma/div;
		System.out.println("la media tra le due righe e'"+media+"");
}
	public static void occDiag(int v[][], int v1[][]) {
		int i;
		int j;
		int ii;
		int jj;
		for(i=0;i<v.length;i++) {
			for(ii=0;ii<v.length;ii++) {
				if(v[i][i]==v1[ii][ii]) {
					System.out.println("nella posizione della prima matrice("+i+","+i+") c'e' un occorrenza di:"+v[i][i]);
				}
			}
		}
		for(j=i-1,jj=0;j>=0;j--,jj++) {
			for(ii=v.length,i=0;ii>=0;ii--,i++) {
				if(v[jj][j]==v1[i][ii]) {
					System.out.println("nella posizione della seconda matrice("+i+","+i+") c'e' un occorrenza di:"+v1[i][i]);
		}
}
		}
	}
	public static void parDispDiag(int v[][],int v1[][]) {
		int i;
		int j;
		int ii;
		int jj;
		
		for( i=0;i<v.length;i++) {
			if(v[i][i]%2==0) {
				System.out.println("nella posizione:("+i+","+i+") c'e' un numero pari:"+v[i][i]);
			}
		}
		for( j=0;j<v1.length;j++) {
			if(v1[j][j]%2==0) {
				System.out.println("nella posizione:("+j+","+j+") c'e' un numero pari:"+v1[j][j]+"seconda matrioce");
				
			}	
		
	}
		for(ii=0,jj=i-1;jj>=0;ii++,jj--) {
			if(v[ii][jj]%2!=0) {
				System.out.println("il numero nella poszione:("+ii+","+jj+"), e' disapri:"+v[ii][jj]);
			}
			if(v1[ii][jj]%2!=0) {
				System.out.println("il numero nella poszione:("+ii+","+jj+"), e' disapri:"+v1[ii][jj]+"nella seconda matrice");
			}
		}
}
	

	public static void main(String[] args) {
		int vett[][];
		int vett2[][];
		int row;
		int col;
		int indice;
		int row1;
		Scanner tastiera= new Scanner(System.in);
		System.out.println("inserisci quante righe vuoi, il numero delle colonne sara' lo stesso");
		System.out.println("il numero minimo di righe e colonne e' 4 e massimo 8");
		row= tastiera.nextInt();
		col=row;
		if(row<=8 && row>=4) {//controllo per verificare la validità delle righe e colonne
			vett= new int [row][col];
			vett2= new int [row][col];
			Riempi(vett);
			Riempi(vett2);
			Stampa(vett);
			System.out.println("*******");
			Stampa(vett2);
			System.out.println("inserisci un numero e io svolgero l'azione richiesta(massimo 4)");
			indice=tastiera.nextInt();
			switch(indice) {// decisione del metodo da usare 
			case 1:
				System.out.println("questo metodo cerca il numero piu' grande di una righa della prima matrice");
				System.out.println("inserisci quale righa vuoi controllare");
				row=tastiera.nextInt();
				if(row<9 && row>=0) {
					calcMaxMin(vett,vett2,row);
				}else {
					System.err.print("hai inserito un numero di riga non vlido");
				}
				break;
			case 2:				System.out.println("questo metodo fa la media tra due righe delle due matrici");
			System.out.println("inserisci la riga della prima matrice");
			row= tastiera.nextInt();
			System.out.println("inserisci la riga della seconda matrice");
			row1=tastiera.nextInt();
			if(row<9 && row>=0 && row1<9 && row1>=0) {
				mediaRigCol(vett,vett2,row,row1);
				
			}else {
				System.err.print("hai inserito un numero di riga non vlido");
			}
				break;
			case 3:
				System.out.println("questo metodo cerca nelle diagonali se si trova un occorrenza di numeri.");
				occDiag(vett,vett2);
			case 4:
				System.out.println("questo metodo ti dice i numeri pari della prima diagonale delle matreici e i dispari delle diagonali contrarie");
				parDispDiag(vett,vett2);
				break;
			default:
				System.err.println(indice+" non e' un numero valido");
				break;
			
			}
		}else {
		System.err.println("hai inserito un numero di righe e colonne non vlaido");
		}
		

	}

}
