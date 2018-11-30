import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
			System.out.println(" 1 = Metodo de ordenamiento Burbuja.");
			System.out.println(" 2 = Metodo de ordenamiento por Seleccion.");
			System.out.println(" 3 = Metodo de ordenamiento por Insercion.");
			System.out.println(" 4 = Metodo de ordenamiento Sellsort.");
			System.out.println(" 5 = Metodo de ordenamiento QuickSort.");
			System.out.println(" 6 = Metodo de ordenamiento RadixSort.");
			System.out.println(" 7 = Metodo de ordenamiento por Intercalacion de Archivos.");
			System.out.println(" 8 = Metodo de ordenamiento Merge Sort con archivos.");
			System.out.println(" 9 = Metodo de ordenamiento Mezcla Natural con archivos.");
			System.out.println("10 = Elegir tamaño del vector a utilizar.");
			System.out.println("11 = Salir");
			System.out.println("------------------------------------------------------------");
			System.out.println("Elija una opcion...");
			opcion=entrada.nextInt();
			System.out.println();
			System.out.println();
			
			if(opcion>=1 && opcion <=11){
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
						System.out.println("  ====================================================ORDENAMIENTO SELLSORT===================================================\n");
						metodos.ordenamientoSellSort(datos.clone());
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 5:
					if(datos.length>0){
						System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
						metodos.mostrarVector(datos);
						System.out.println("\n\n");
						System.out.println("  ===================================================ORDENAMIENTO QUICKSORT==================================================\n");
						int[]copiaDatos=datos.clone();
						long tiempoTotal=0, tiempoInicial=0;
						tiempoInicial=System.nanoTime();
						metodos.ordenamientoQuickSort(copiaDatos, 0, copiaDatos.length-1);
						tiempoTotal=System.nanoTime()-tiempoInicial;
						metodos.mostrarVector(copiaDatos);
						System.out.println();
						System.out.println();
						metodos.mostrarDatosDeEficiencia(0, 0, 0, tiempoTotal);
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 6:
					if(datos.length>0){
						System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
						metodos.mostrarVector(datos);
						System.out.println("\n\n");
						System.out.println("  ===================================================ORDENAMIENTO RADIXSORT==================================================\n");
						metodos.ordenamientoRadixSort(datos.clone());
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 7:
					metodos.ordenamientoPorIntercalacion();
					System.out.println();
					System.out.println();
					break;
				case 8:
					File archivoOriginal=new File("./src/ArchivoMergeSort.txt");
					File archivoSalidaMS=new File("./src/ArchivoSalidaMS.txt");
					
					System.out.println("  ======================================================ARCHIVO ORIGINAL======================================================\n");
					metodos.mostrarArchivo(archivoOriginal);
									
					long tiempoTotal=0, tiempoInicial=0;
					tiempoInicial=System.nanoTime();
					try{
						BufferedReader br=new BufferedReader(new FileReader("./src/ArchivoMergeSort.txt"));	
						List<Integer> lines=new ArrayList<Integer>();
						String line;
						while((line=br.readLine())!=null)
							lines.add(Integer.parseInt(line));
						br.close();
						Integer[] inputArray =lines.toArray(new Integer[lines.size()]);
						metodos.mergeSort(inputArray, 0, inputArray.length-1);
						
						FileWriter archivoS=null;
						PrintWriter pr=null;
						try{//Apertura del archivo de salida para escritura
							archivoS=new FileWriter("./src/ArchivoSalidaMS.txt", false);
							pr=new PrintWriter(archivoS);
							
							for(Integer i : inputArray)
								pr.println(i);
						}catch (IOException e){
							System.out.println("Error al abrir o crear el archivo");
						}finally{
							try{
								archivoS.close();
							}catch(IOException e){
								System.out.println("Error al cerrar el archivo");
							}
						}//Final del archivo para escritura.
					}catch(IOException ie){
						System.out.println(ie.getMessage());
					}
					tiempoTotal=System.nanoTime()-tiempoInicial;
					System.out.println("  ======================================================ARCHIVO ORDENADO======================================================\n");
					metodos.mostrarArchivo(archivoSalidaMS);
					metodos.mostrarDatosDeEficiencia(0, 0, 0, tiempoTotal);
					System.out.println();
					System.out.println();
					break;
				case 9:
					File archivoSalidaMN=new File("./src/ArchivoSalidaMN.txt");
					tiempoTotal=0;
					tiempoInicial=0;
					
					System.out.println("  ======================================================ARCHIVO ORIGINAL======================================================\n");
					metodos.mostrar(metodos.lectura());
					System.out.println();
					System.out.println();
					tiempoInicial=System.nanoTime();
					metodos.ordenamientoMezclaNatural(metodos.lectura());
					tiempoTotal=System.nanoTime()-tiempoInicial;
					System.out.println("  ======================================================ARCHIVO ORDENADO======================================================\n");
					metodos.mostrarArchivo(archivoSalidaMN);
					metodos.mostrarDatosDeEficiencia(0, 0, 0, tiempoTotal);
					System.out.println();
					System.out.println();
					break;
				case 10:
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
				case 11:
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