class MetodosDeOrdenamiento {
	public void mostrarVector(int[] datos){
		byte cont=1;
		for(int i=0;i<datos.length;i++){
			if(cont==15){
				System.out.println("  "+datos[i]+",	");
				cont=1;
			}
			else{
				System.out.print("  "+datos[i]+",	");
				cont++;
			}
		}
	}
	
	public void mostrarDatosDeEficiencia(long contadorComparaciones,
			long contadorIntercambios, long contadorRecorridos, long tiempoTotal){
		System.out.println("       DATOS DE EFICIENCIA DEL ALGORITMO");
		System.out.println();
		System.out.println("    - Cantidad  de  recorridos  realizados:	"+contadorRecorridos);
		System.out.println("    - Cantidad de comparaciones realizadas:	"+contadorComparaciones);
		System.out.println("    - Cantidad  de intercambios realizados:	"+contadorIntercambios);
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000000+" segundos");
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000+" milisegundos");
	}
	
	
	//=======METODO DE ORDENAMIENTO BURBUJA=======
	public void ordenamientoBurbuja0(int[] datos){
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
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
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
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
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
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
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
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
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
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
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
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
	
	
	//========METODO DE ORDENAMIENTO SELLSORT=========
	public void ordenamientoSellSort(int[] datos){
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		int salto, aux, i;
		boolean cambios;
		
		tiempoInicial=System.nanoTime();
		for(salto=datos.length/2;salto!=0;salto/=2){
			cambios=true;
			while(cambios){
				cambios=false;
				contadorRecorridos++;
				for (i=salto;i<datos.length;i++){
					contadorComparaciones++;
					if(datos[i-salto]>datos[i]){
						contadorIntercambios++;
						aux=datos[i];
						datos[i]=datos[i-salto];
						datos[i-salto]=aux;
						cambios=true;
					}
				}
			}
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
	}
	
	
	//========METODO DE ORDENAMIENTO QUICKSORT=========
	int partition(int datos[], int low, int high){
		int pivot = datos[high]; 
	    int i = (low-1);
	    for (int j=low; j<high; j++){
	    	if (datos[j] <= pivot){
	    		i++;
	            int temp = datos[i];
	            datos[i] = datos[j];
	            datos[j] = temp;
            }
    	}
	     
	    int temp = datos[i+1];
	    datos[i+1] = datos[high];
	    datos[high] = temp;
	    
	    return i+1;
    }

	void ordenamientoQuickSort(int datos[], int low, int high){
	    if (low < high){
	        int pi = partition(datos, low, high);
	        ordenamientoQuickSort(datos, low, pi-1);
	        ordenamientoQuickSort(datos, pi+1, high);
	    }
	}
	
	//========METODO DE ORDENAMIENTO RADIXSORT=========
	public void ordenamientoRadixSort(int[] datos){
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		
		tiempoInicial=System.nanoTime();
        if(datos.length == 0)
            return;
        int[][] np = new int[datos.length][2];
        int[] q = new int[0x100];
        int i,j,k,l,f = 0;
        for(k=0;k<4;k++){
            for(i=0;i<(np.length-1);i++)
                np[i][1] = i+1;
            np[i][1] = -1;
            for(i=0;i<q.length;i++)
                q[i] = -1;
            for(f=i=0;i<datos.length;i++){
            	contadorRecorridos++;
                j = ((0xFF<<(k<<3))&datos[i])>>(k<<3);
                contadorComparaciones++;
                if(q[j] == -1){
                    l = q[j] = f;
                    contadorIntercambios++;
                }
                else{
                    l = q[j];
                    while(np[l][1] != -1)
                        l = np[l][1];
                    np[l][1] = f;
                    l = np[l][1];
                }
                f = np[f][1];
                np[l][0] = datos[i];
                np[l][1] = -1;
            }
            for(l=q[i=j=0];i<0x100;i++)
                for(l=q[i];l!=-1;l=np[l][1])
                        datos[j++] = np[l][0];
        }
        tiempoTotal=System.nanoTime()-tiempoInicial;
		mostrarVector(datos);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
    }
		
	
	
	
	
	
	
	
	
	
	
}