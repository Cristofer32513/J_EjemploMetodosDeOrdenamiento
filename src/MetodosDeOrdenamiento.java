class MetodosDeOrdenamiento {
	public void mostrarVector(int[] datos){
		long cont=1;
		for(int i=0;i<datos.length;i++){
			if(cont==15){
				System.out.println("  "+datos[i]+",	");
				cont=0;
			}
			else{
				System.out.print("  "+datos[i]+",	");
				cont++;
			}
		}
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
	
	
	//=======METODO DE ORDENAMIENTO BURBUJA=======
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
	
	
	//======METODO DE ORDENAMIENTO POR SELECCION======
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
	
	
	//======METODO DE ORDENAMIENTO POR INSERCION======
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