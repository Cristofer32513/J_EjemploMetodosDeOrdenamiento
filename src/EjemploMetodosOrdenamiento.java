import java.util.Arrays;

class MetodosDeOrdenamiento{

	public void mostrarVector(int[] datos){
		System.out.println(Arrays.toString(datos));
	}
	
	public void mostrarDatosDeEficiencia(int contadorComparaciones,
			int contadorIntercambios, int contadorRecorridos, long tiempoTotal){
		System.out.println("       DATOS DE EFICIENCIA DEL ALGORITMO");
		System.out.println();
		System.out.println("    - Cantidad de recorridos realizados: "+contadorComparaciones);
		System.out.println("    - Cantidad de comparaciones realizadas: "+contadorComparaciones);
		System.out.println("    - Cantidad de intercambios realizados: "+contadorIntercambios);
		System.out.println("    - Tiempo total de ejecucion: "+tiempoTotal);
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
	
	
	
	
}

public class EjemploMetodosOrdenamiento {

	public static void main(String[] args) {
			
	}
}