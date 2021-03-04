package criba;

import java.util.Scanner;

public class Criba {
		
		public static int[] generarPrimos(int max) {
			if (max >=2) {
				int dim= max + 1; 
				
				boolean[] esPrimo = iniciarPrimos(dim);
				
				esPrimo[0] = esPrimo[1] = false;
							
				criba(dim, esPrimo);
				int cuenta = cuentaPrimos(dim, esPrimo);
				
				int[] primos = rellenarPrimos(dim, esPrimo, cuenta);
				
				return primos;
			} else {// max <2
				return new int[0];
				// Vector vacio
			}
			
		}
		public static int[] rellenarPrimos(int dim, boolean[] esPrimo, int cuenta) {
			int i;
			int j;
			int [] primos = new int[cuenta];
			for (i=0, j=0; i<dim; i++) {
				if(esPrimo[i])
					primos[j++] = i;
			}
			return primos;
		}
		public static int cuentaPrimos(int dim, boolean[] esPrimo) {
			int i = 0, cuenta = 0;
			for (i=0; i<dim; i++) {
				if (esPrimo[i])
					cuenta++;
			}
			return cuenta;
		}
		public static void criba(int dim, boolean[] esPrimo) {
			int i = 0, j = 0;
			for (i=2; i<Math.sqrt(dim)+1; i++) {
				if (esPrimo[i]) {
			
					for(j=2*i; j<dim; j+=i)
						esPrimo[j] = false;
				}
			}
		}
		public static boolean[] iniciarPrimos(int dim) {
			int i;
			boolean[] esPrimo = new boolean[dim];
			for (i=0; i<dim; i++ )
				esPrimo[i] = true;
			return esPrimo;
		}
		
		//METODO MAIN//
		public static void main(String[] args) {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce el número para la criba de Erastotenes: ");
			int dato = teclado.nextInt();
			int vector[] = new int[dato];
			System.out.println("\nVector inicial hasta : " + dato);
			for (int i = 0; i < vector.length; i++) {
				if (i%10==0) System.out.println();
				System.out.println(i+1+"\t");
				
			}
			vector = generarPrimos(dato);
			System.out.println("\nVector de primos hasta" + dato);
			for (int i = 0; i < vector.length; i++) {
				if (i%10==0)System.out.println();
				System.out.println(vector[i]+"\t");
				
				teclado.close();
				
			}	
		}
	}
