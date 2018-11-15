import java.util.Arrays;

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
	
	public void ordenmientoPorSeleccion(int[] datos){
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
	
}

public class EjemploMetodosOrdenamiento {

	public static void main(String[] args) {
		int[] edades;
		edades=new int[]{34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
		
		MetodosDeOrdenamiento metodos=new MetodosDeOrdenamiento();
		
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
		
		
		
		
		
	}
}