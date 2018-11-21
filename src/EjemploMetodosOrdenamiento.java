import java.util.Random;
import java.util.Scanner;

public class EjemploMetodosOrdenamiento {

	public static void main(String[] args) {
		MetodosDeOrdenamiento metodos=new MetodosDeOrdenamiento();
				
		@SuppressWarnings("resource")
		Scanner entrada=new Scanner(System.in);
		boolean repetirMenuPrincipal=true;
		int opcion=0;
		int[] datos=new int[0];
		
		do{
			System.out.println("1 = Metodo de ordenamiento Burbuja.");
			System.out.println("2 = Metodo de ordenamiento por Seleccion.");
			System.out.println("3 = Metodo de ordenamiento por Insercion.");
			System.out.println("4 = Metodo de ordenamiento Sellsort.");
			System.out.println("5 = Elegir tamaño del vector a utilizar.");
			System.out.println("6 = Salir");
			System.out.println("-----------------------------------------");
			System.out.println("Elija una opcion...");
			opcion=entrada.nextInt();
			System.out.println();
			System.out.println();
			
			if(opcion>=1 && opcion <=6){
				switch(opcion){
				case 1:
					if(datos.length>0){
						boolean repetirMenuMetodoburbuja=true;
						int opcionBurbuja=0;		
						
						do{
							System.out.println("  Utilizar metodo...");
							System.out.println();
							System.out.println("    1 = Burbuja 0.");
							System.out.println("    2 = Burbuja 1.");
							System.out.println("    3 = Burbuja 2.");
							System.out.println("    4 = Burbuja 3.");
							System.out.println("    -----------------------------------------");
							System.out.print("    Elija una opcion...\n    ");
							opcionBurbuja=entrada.nextInt();
							System.out.println();
						
							if(opcionBurbuja>=1 && opcionBurbuja <=4){				
								switch(opcionBurbuja){
								case 1:
									System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
									metodos.mostrarVector(datos);
									System.out.println("\n\n");
									System.out.println("  ===================================================ORDENAMIENTO BURBUJA 0==================================================\n");
									metodos.ordenamientoBurbuja0(datos.clone());
									break;
								case 2:
									System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
									metodos.mostrarVector(datos);
									System.out.println("\n\n");
									System.out.println("  ===================================================ORDENAMIENTO BURBUJA 1==================================================\n");
									metodos.ordenamientoBurbuja1(datos.clone());
									break;
								case 3:
									System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
									metodos.mostrarVector(datos);
									System.out.println("\n\n");
									System.out.println("  ===================================================ORDENAMIENTO BURBUJA 2==================================================\n");
									metodos.ordenamientoBurbuja2(datos.clone());
									break;
								case 4:
									System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
									metodos.mostrarVector(datos);
									System.out.println("\n\n");
									System.out.println("  ===================================================ORDENAMIENTO BURBUJA 3==================================================\n");
									metodos.ordenamientoBurbuja3(datos.clone());
									break;
								}
								repetirMenuMetodoburbuja=false;
							}
							else
								System.out.println("    *"+opcionBurbuja+" no es una opcion valida, intenta otra vez.");
							System.out.println();
							System.out.println();
						}
						while(repetirMenuMetodoburbuja);
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 2:
					if(datos.length>0){
						System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
						metodos.mostrarVector(datos);
						System.out.println("\n\n");
						System.out.println("  =================================================ORDENAMIENTO POR SELECCION================================================\n");
						metodos.ordenamientoPorSeleccion(datos.clone());
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 3:
					if(datos.length>0){
						System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
						metodos.mostrarVector(datos);
						System.out.println("\n\n");
						System.out.println("  =================================================ORDENAMIENTO POR INSERCION================================================\n");
						metodos.ordenamientoPorInsercion(datos.clone());
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 4:
					if(datos.length>0){
						System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
						metodos.mostrarVector(datos);
						System.out.println("\n\n");
						System.out.println("  =================================================ORDENAMIENTO SELLSORT================================================\n");
						metodos.ordenamientoSellSort(datos.clone());
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 5:
					boolean repetirMenuTamañoVector=true;
					int opcionVector=0;		
					
					do{
						System.out.println("Realizar pruebas con...");
						System.out.println();
						System.out.println("  1 = 1,000 datos.");
						System.out.println("  2 = 10,000 datos.");
						System.out.println("  3 = 100,000 datos.");
						System.out.println("  4 = 1,000,000 datos.");
						System.out.println("  -----------------------------------------");
						System.out.print("  Elija una opcion...\n  ");
						opcionVector=entrada.nextInt();
						System.out.println();
					
						if(opcionVector>=1 && opcionVector <=4){				
							switch(opcionVector){
							case 1:
								datos=new int[1000];
								System.out.println("  Creando vector...");
								for(int i=0;i<datos.length;i++){
									datos[i]=new Random().nextInt(100);
								}
								break;
							case 2:
								datos=new int[10000];
								System.out.println("  Creando vector...");
								for(int i=0;i<datos.length;i++){
									datos[i]=new Random().nextInt(100);
								}
								break;
							case 3:
								datos=new int[100000];
								System.out.println("  Creando vector...");
								for(int i=0;i<datos.length;i++){
									datos[i]=new Random().nextInt(100);
								}
								break;
							case 4:
								datos=new int[1000000];
								System.out.println("  Creando vector...");
								for(int i=0;i<datos.length;i++){
									datos[i]=new Random().nextInt(100);
								}
								break;
							}
							repetirMenuTamañoVector=false;
							System.out.println();
							System.out.println("  El vector ha sido creado y llenado.");
							System.out.println();
							System.out.println("  *NOTA: El vector a utilizar en los metodos sera el mismo mientras que no se escoja un tamaño diferente.");
						}
						else{
							System.out.println("    *"+opcion+" no es una opcion valida, intenta otra vez.");
						}
						System.out.println();
						System.out.println();
					}
					while(repetirMenuTamañoVector);
					break;
				case 6:
					repetirMenuPrincipal=false;
					break;
				}
			}
			else{
				System.out.println("  *"+opcion+" no es una opcion valida, intenta otra vez.");
				System.out.println();
				System.out.println();
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println();
		}
		while(repetirMenuPrincipal);
		System.out.println("Usted ha salido.");
	}
}