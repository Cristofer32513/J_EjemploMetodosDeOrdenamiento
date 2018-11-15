import java.util.Arrays;

class MetodosDeOrdenamiento{
	int contadorComparaciones;
	int contadorIntercambios;
	int contadorRecorridos;
	long tiempoEjecucion;
	
	public void mostrarVector(int[] datos){
		System.out.println(Arrays.toString(datos));
	}
	
	public void deBurbuja0(int[] datos){
		int aux=0;
		for(int i=0;i<datos.length;i++){
			for(int j=(i+1);j<datos.length;j++){
				if(datos[i]>datos[(j)]){
					aux=datos[i];
					datos[i]=datos[j];
					datos[j]=aux;
				}
			}
		}
	}
	
	public void deBurbuja1(int[] datos){
		contadorComparaciones=0;
		contadorIntercambios=0;
		tiempoEjecucion=0;
		long tiempoInicio=0;
		long tiempoFin=0;
		int aux=0;
		tiempoInicio=System.currentTimeMillis();
		for(int i=2;i<datos.length;i++){
			for(int j=0;j<datos.length-i;j++){
				contadorComparaciones++;
				if(datos[j]>datos[(j+1)]){
					aux=datos[j];
					datos[j]=datos[j+1];
					datos[j+1]=aux;
					contadorIntercambios++;
				}
			}
		}
		tiempoFin=System.currentTimeMillis();
		tiempoEjecucion=tiempoFin-tiempoInicio;
	}
	
	public void ordenmientoPorSeleccion(int[] datos){
		contadorComparaciones=0;
		contadorIntercambios=0;
		tiempoEjecucion=0;
		long tiempoInicio=0;
		long tiempoFin=0;
		tiempoInicio=System.currentTimeMillis();
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
		}
		tiempoFin=System.currentTimeMillis();
		tiempoEjecucion=tiempoFin-tiempoInicio;
	}
	
}


public class EjemploMetodosOrdenamiento {

	public static void main(String[] args) {
	int[] edades={34, 25, 12, 87, 9, 10, 34, 37, 24, 2};
	
	MetodosDeOrdenamiento mo=new MetodosDeOrdenamiento();
	
	System.out.println("=================VECTOR ORIGINAL======================");
	mo.mostrarVector(edades);
	System.out.println();
	System.out.println("===============ORDENAMIENTO BURBUJA====================");
	mo.deBurbuja0(edades);
	mo.mostrarVector(edades);
	//System.out.println();
	//mo.deBurbuja1(edades);
	//mo.mostrarVector(edades);
	
	System.out.println("DATOS DE EFICICENCIA DEL ALGORITMO");
	System.out.println();
	System.out.println("    - Cantidad de recorridos realizados: "+mo.contadorComparaciones);
	System.out.println("    - Cantidad de comparaciones realizadas: "+mo.contadorComparaciones);
	System.out.println("    - Cantidad de intercambios realizados: "+mo.contadorIntercambios);
	System.out.println("    - Tiempo total de ejecucion: "+mo.tiempoEjecucion);
	
		
	/*System.out.println("===============ORDENAMIENTO SELECCION====================");
	mo.ordenmientoPorSeleccion(edades);
	mo.mostrarVector(edades);
	System.out.println();
	
	System.out.println("DATOS DE EFICICENCIA DEL ALGORITMO");
	System.out.println();
	System.out.println("    - Cantidad de recorridos realizados: "+mo.contadorRecorridos);
	System.out.println("    - Cantidad de comparaciones realizadas: "+mo.contadorComparaciones);
	System.out.println("    - Cantidad de intercambios realizados: "+mo.contadorIntercambios);
	System.out.println("    - Tiempo total de ejecucion: "+mo.tiempoEjecucion);
	*/
		
	}
}