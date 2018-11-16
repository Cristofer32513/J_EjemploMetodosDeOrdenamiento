import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MetodosDeOrdenamiento{

	public void mostrarVector(int[] datos){
		System.out.println(Arrays.toString(datos));
	}
	
	public void mostrarDatosDeEficiencia(int contadorComparaciones,
			int contadorIntercambios, int contadorRecorridos, long tiempoTotal){
		System.out.println("       DATOS DE EFICIENCIA DEL ALGORITMO");
		System.out.println();
		System.out.println("    - Cantidad de recorridos realizados: "+contadorRecorridos);
		System.out.println("    - Cantidad de comparaciones realizadas: "+contadorComparaciones);
		System.out.println("    - Cantidad de intercambios realizados: "+contadorIntercambios);
		System.out.println("    - Tiempo total de ejecucion: "+(double)tiempoTotal/1000000+" milisegundos");
	}
		
	public void ordenamientoBurbuja0(int[] datos){
		int contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		
		int aux=0;
		tiempoInicial=System.nanoTime();
		for(int i=0;i<datos.length;i++){
			for(int j=(i+1);j<datos.length;j++){
				contadorComparaciones++;
				if(datos[i]>datos[(j)]){
					contadorIntercambios++;
					aux=datos[i];
					datos[i]=datos[j];
					datos[j]=aux;
				}
			}
			contadorRecorridos++;
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
	}
	
	public void ordenamientoBurbuja1(int[] datos){
		int contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		
		int aux=0;
		tiempoInicial=System.nanoTime();
		for(int i=2;i<=datos.length;i++){
			for(int j=0;j<=(datos.length-i);j++){
				contadorComparaciones++;
				if(datos[j]>datos[j+1]){
					contadorIntercambios++;
					aux=datos[j];
					datos[j]=datos[j+1];
					datos[j+1]=aux;
				}
			}
			contadorRecorridos++;
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
	}
	
	public void ordenamientoBurbuja2(int[] datos){
		int contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		int i=1;
		boolean ordenado=false;
		int aux=0;
		tiempoInicial=System.nanoTime();
		while(i<datos.length && !ordenado){
			i++;
			ordenado=true;
			for(int j=0;j<=(datos.length-i);j++){
				contadorComparaciones++;
				if(datos[j]>datos[j+1]){
					contadorIntercambios++;
					ordenado=false;
					aux=datos[j];
					datos[j]=datos[j+1];
					datos[j+1]=aux;
				}
			}
			contadorRecorridos++;
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
	}
	
	public void ordenamientoBurbuja3(int[] datos){
		int contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		int i=1;
		boolean ordenado;
		int aux=0;
		
		tiempoInicial=System.nanoTime();
		do{
			i++;
			ordenado=true;
			for(int j=0;j<=(datos.length-i);j++){
				contadorComparaciones++;
				if(datos[j]>datos[j+1]){
					contadorIntercambios++;
					ordenado=false;
					aux=datos[j];
					datos[j]=datos[j+1];
					datos[j+1]=aux;
				}
			}
			contadorRecorridos++;
		}
		while(i<datos.length || !ordenado);
		tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
	}
	
	public void ordenamientoPorSeleccion(int[] datos){
		int contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		tiempoInicial=System.nanoTime();
		for(int i=0;i<datos.length;i++){
			int menor=i;
			for(int j=i+1;j<datos.length;j++){
				contadorComparaciones++;
				if(datos[j]<datos[menor])
					menor=j;
			}
			int aux=datos[i];
			datos[i]=datos[menor];
			datos[menor]=aux;
			contadorIntercambios++;
			contadorRecorridos++;
			contadorIntercambios++;
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
	}
	
	public void ordenamientoPorInsercion(int[] datos){
		int contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		int i=0, j=0;
		int aux=0;
		
		tiempoInicial=System.nanoTime();
		for(i=1;i<datos.length;i++){
			aux=datos[i];
			j=i-1;
			contadorComparaciones++;
			while(j>=0 && aux<datos[j]){
				contadorIntercambios++;
				datos[j+1]=datos[j];
				j--;
			}
			datos[j+1]=aux;
			contadorRecorridos++;
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
	}


}

public class EjemploMetodosOrdenamiento {

	public static void main(String[] args) {
		int[] edades;
		edades=new int[]{34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		
		/*MetodosDeOrdenamiento metodos=new MetodosDeOrdenamiento();
		
		System.out.println("=================VECTOR ORIGINAL======================");
		metodos.mostrarVector(edades);
		System.out.println();
		System.out.println();
		System.out.println("===============ORDENAMIENTO BURBUJA===================");
		metodos.ordenamientoBurbuja0(edades);
		
		edades=new int[]{34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		metodos.ordenamientoBurbuja1(edades);
		
		edades=new int[]{34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		metodos.ordenamientoBurbuja2(edades);
		
		edades=new int[]{34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		metodos.ordenamientoBurbuja3(edades);
		System.out.println();
		System.out.println();
		
		System.out.println("===============ORDENAMIENTO POR SELECCION====================");
		edades=new int[]{34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		metodos.ordenamientoPorSeleccion(edades);
		System.out.println();
		System.out.println();
		
		System.out.println("===============ORDENAMIENTO POR INSERCION====================");
		edades=new int[]{34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		metodos.ordenamientoPorInsercion(edades);
		*/
		
		
		@SuppressWarnings("resource")
		Scanner entrada=new Scanner(System.in);
		boolean repetirMenuPrincipal=true;
		int opcion=0;
		int[] datos=new int[0];
		int[] copiaDatos=datos;
		
		do{
			System.out.println("1 = Metodo de ordenamiento burbuja.");
			System.out.println("2 = Metodo de ordenamiento por seleccion.");
			System.out.println("3 = Metodo de ordenamiento por insercion.");
			System.out.println("4 = Elegir tamaño del vector a utilizar.");
			System.out.println("5 = Salir");
			System.out.println("-----------------------------------------");
			System.out.println("Elija una opcion...");
			opcion=entrada.nextInt();
			System.out.println();
			System.out.println();
			
			if(opcion>=1 && opcion <=5){
				switch(opcion){
				case 1:
					if(datos.length>0){
						boolean repetirMenuMetodoburbuja=true;
						int opcion3=0;		
						
						do{
							System.out.println("  Utilizar metodo...");
							System.out.println();
							System.out.println("    1 = Burbuja 0.");
							System.out.println("    2 = Burbuja 1.");
							System.out.println("    3 = Burbuja 2.");
							System.out.println("    4 = Burbuja 3.");
							System.out.println("    -----------------------------------------");
							System.out.print("    Elija una opcion...\n    ");
							opcion3=entrada.nextInt();
							System.out.println();
							System.out.println();
						
							if(opcion3>=1 && opcion3 <=4){				
								switch(opcion3){
								case 1:
									
									break;
								case 2:
									
									break;
								case 3:
									
									break;
								case 4:
									
									break;
								}
								repetirMenuMetodoburbuja=false;
								System.out.println();
								System.out.println("  El vector a sido creado y llenado.");
								System.out.println();
								System.out.println();
							}
							else{
								System.out.println("    *"+opcion+" no es una opcion valida, intenta otra vez.");
								System.out.println();
								System.out.println();
							}
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
						
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 3:
					if(datos.length>0){
						
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 4:
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
								for(int i=0;i<datos.length;i++)
									datos[i]=new Random().nextInt(100);
								copiaDatos=datos;
								break;
							case 2:
								datos=new int[10000];
								System.out.println("  Creando vector...");
								for(int i=0;i<datos.length;i++)
									datos[i]=new Random().nextInt(100);
								copiaDatos=datos;
								break;
							case 3:
								datos=new int[100000];
								System.out.println("  Creando vector...");
								for(int i=0;i<datos.length;i++)
									datos[i]=new Random().nextInt(100);
								copiaDatos=datos;
								break;
							case 4:
								datos=new int[100000];
								System.out.println("  Creando vector...");
								for(int i=0;i<datos.length;i++)
									datos[i]=new Random().nextInt(100);
								copiaDatos=datos;
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
				case 5:
					repetirMenuPrincipal=false;
					break;
				}
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println();
				System.out.println();
			}
			else{
				System.out.println("  *"+opcion+" no es una opcion valida, intenta otra vez.");
				System.out.println();
				System.out.println();
			}
		}
		while(repetirMenuPrincipal);
		System.out.println("Usted ha salido.");
	}
}