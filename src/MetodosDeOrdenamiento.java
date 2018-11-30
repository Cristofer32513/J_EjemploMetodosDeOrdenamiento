import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	
	
	//========METODO DE ORDENAMIENTO POR INTERCALACION DE ARCHIVOS=========
	public void ordenamientoPorIntercalacion(){
		long contadorComparaciones=0, contadorIntercambios=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		
		File archivo1=new File("./src/ArchivoI1.txt");//Archivos a leer
		File archivo2=new File("./src/ArchivoI2.txt");//Archivos a leer
		File archivoSalida=new File("./src/ArchivoSalidaI.txt");
				
		System.out.println("  ======================================================DATOS DEL ARCHIVO 1======================================================\n");
		mostrarArchivo(archivo1);
		System.out.println("  ======================================================DATOS DEL ARCHIVO 2======================================================\n");
		mostrarArchivo(archivo2);
				
		FileReader frA1 = null;
		BufferedReader brA1;
		FileReader frA2 = null;
		BufferedReader brA2;
		
		FileWriter archivo3=null;
		PrintWriter pr=null;
		
		tiempoInicial=System.nanoTime();
		try{//Apertura del archivo de salida para escritura
			archivo3=new FileWriter("./src/ArchivoSalidaI.txt", false);
			pr=new PrintWriter(archivo3);
			
			try {//Apertura del archivo1 para lectura
				frA1=new FileReader(archivo1);
				brA1=new BufferedReader(frA1);
				String lineaArchivo1;
				
				try {//Apertura del archivo2 para lectura
					frA2=new FileReader(archivo2);
					brA2=new BufferedReader(frA2);
					String lineaArchivo2;
					boolean repetir=true;
					
					lineaArchivo1=brA1.readLine();
					lineaArchivo2=brA2.readLine();
					
					contadorRecorridos++;	
					do{//Se realizan comparaciones mientras la bandera no cambie
						contadorComparaciones++;
						if(Integer.parseInt(lineaArchivo1)<Integer.parseInt(lineaArchivo2)){
							contadorIntercambios++;
							pr.println(lineaArchivo1);
							if((lineaArchivo1=brA1.readLine())==null){
								pr.println(lineaArchivo2);
								while((lineaArchivo2=brA2.readLine())!=null){
									pr.println(lineaArchivo2);
								}
								repetir=false;
							}
						}
						else if(Integer.parseInt(lineaArchivo1)>Integer.parseInt(lineaArchivo2)){
							contadorIntercambios++;
							pr.println(lineaArchivo2);
							if((lineaArchivo2=brA2.readLine())==null){
								pr.println(lineaArchivo1);
								while((lineaArchivo1=brA1.readLine())!=null){
									pr.println(lineaArchivo1);
								}
								repetir=false;
							}
						}
						else{
							pr.println(lineaArchivo1);
							pr.println(lineaArchivo2);
							if((lineaArchivo1=brA1.readLine())==null){
								pr.println(lineaArchivo2);
								while((lineaArchivo2=brA2.readLine())!=null){
									pr.println(lineaArchivo2);
								}
								repetir=false;
							}
							if((lineaArchivo2=brA2.readLine())==null){
								pr.println(lineaArchivo1);
								while((lineaArchivo1=brA1.readLine())!=null){
									pr.println(lineaArchivo1);
								}
								repetir=false;
							}
						}
					}while(repetir);
				} catch (FileNotFoundException e) {
					System.out.println("Error al abrir el archivo");
					//e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						frA2.close();
					} catch (IOException e) {
						System.out.println("Error al cerrar el archivo");
					}	
				}//Final del archivo2
			} catch (FileNotFoundException e) {
				System.out.println("Error al abrir el archivo");
				//e.printStackTrace();
			} catch (@SuppressWarnings("hiding") IOException e) {
				e.printStackTrace();
			}finally{
				try {
					frA1.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el archivo");
				}
			}//Final del archivo1
			//System.out.println("Archivos combinados y ordenados correctamente");
		}catch (IOException e){
			System.out.println("Error al abrir o crear el archivo");
		}finally{
			try{
				archivo3.close();
			}catch(IOException e){
				System.out.println("Error al cerrar el archivo");
			}
		}//Final del archivo3
		
		tiempoTotal=System.nanoTime()-tiempoInicial;
		System.out.println("  ======================================================ARCHIVO SALIDA======================================================\n");
		mostrarArchivo(archivoSalida);
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorIntercambios, contadorRecorridos, tiempoTotal);
		
		
	}

	public void mostrarArchivo(File archivo){
		FileReader fr = null;
		BufferedReader br;
		String linea;
		byte cont=1;
		
		try {//Apertura del archivo2 para lectura
			fr=new FileReader(archivo);
			br=new BufferedReader(fr);
			
			while((linea=br.readLine())!=null){
				if(cont==15){
					System.out.println("  "+linea+",	");
					cont=1;
				}
				else{
					System.out.print("  "+linea+",	");
					cont++;
				}		
			}
			System.out.println();
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo");
			}	
		}
	}
	
	
	//========METODO DE ORDENAMIENTO MEZCLA DIRECTA=========
	public void mergeSort(Integer[] array, int lo, int n){
		int low=lo;
		int high=n;
		if(low>=high){
			return;
		}
		
		int middle=(low+high)/2;
		mergeSort(array, low, middle);
		mergeSort(array, middle+1, high);
		int end_low=middle;
		int start_high=middle+1;
		while((lo<=end_low)&&(start_high<=high)){
			if(array[low]<array[start_high]){
				low++;
			}
			else{
				int temp=array[start_high];
				for(int k=start_high-1;k>=low;k--)
					array[k+1]=array[k];
				array[low]=temp;
				low++;
				end_low++;
				start_high++;
			}
		}
	}

	
	//========METODO DE ORDENAMIENTO MEZCLA NATURAL=========
	public static Integer[] lectura() {
		File archivo1=new File("./src/ArchivoMezclaNatural.txt");
		FileReader frA1=null;
		BufferedReader brA1;
		Integer[] arr1=new Integer[0];
		
		try { //Se lee el archivo
			frA1=new FileReader(archivo1);
			brA1=new BufferedReader(frA1);
			String lineaArchivo1;
			try {
				lineaArchivo1 = brA1.readLine();
				String [] numeros= lineaArchivo1.split(",");
				arr1=new Integer[numeros.length];
				for(int i=0; i<=numeros.length-1; i++) {
					 Integer intObj = new Integer(numeros[i]);
					 arr1[i]=intObj;
				 }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el archivo");
			e.printStackTrace();
		}try {
			frA1.close();
		}catch(IOException e) {
			System.out.println("Error al cerrar el archivo");
		}
		return arr1;
	}
	
	private static Comparable[] aux;
	
	public static void ordenamientoMezclaNatural(Comparable[] a) { //Originalmente es el  
		aux = new Comparable[a.length];                              // que se manda a llamar
		ordenamientoMezclaNatural(a, 0, a.length - 1);
		//mostrar(a);
		escribir(a);
		
	}
	
	public static boolean estaOrdenado(Comparable[] a) { //Para ver si el arreglo ya esta ordenado
		for (int i = 1; i < a.length; i += 1) {
			if (a[i - 1].compareTo(a[i]) > 0) {
				return false;
				}
			}
		return true;
	}
	
	//Se sobrecarga el metodo con diferentes parametros
	private static void ordenamientoMezclaNatural(Comparable[] a, int primero, int ultimo) { 
		int i = primero;
		int j = 0;
		int medio = 0;
		int az = 0;
		while (true) {
			i = 0;
			while (i < a.length) {
				if (i == a.length - 1) {
					break;
				}
				else if (a[i].compareTo(a[i + 1]) > 0) {
					break;
				}
				i++;
			}
			j = i + 1;
			while (j < a.length) {
				if (j == a.length - 1) {
					break;
				}
				else if (a[j].compareTo(a[j + 1]) > 0) {
					break;
				}
				j++;
			}
			//      medio = primero + (j - primero) / 2;

			Mezcla(a, primero, i, j);
			primero = 0;
			if (estaOrdenado(a)) {
				break;
			}
		}
	}
	
	public static void Mezcla(Comparable[] a, int primero, int medio, int ultimo) {
		int i = primero;
		int j = medio + 1;
		for (int k = primero; k <= ultimo; k++) {
			aux[k] = a[k];
		}
		for (int k = primero; k <= ultimo; k++) {
			if (i > medio) {
				a[k] = aux[j++];
			}
			else if (j > ultimo) {
				a[k] = aux[i++];
			} else if (aux[i].compareTo(aux[j]) > 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
	
	public static void mostrar(Comparable[] a) {
		byte cont=1;
		for (int i = 0; i < a.length; i++) {
			if(cont==15){
				System.out.println("  "+a[i]+",	");
				cont=1;
			}
			else{
				System.out.print("  "+a[i]+",	");
				cont++;
			}		
		}
	}
	
	public static void escribir(Comparable[] a){
		
		FileWriter archivoS=null;
		PrintWriter pr=null;
		try{//Apertura del archivo de salida para escritura
			archivoS=new FileWriter("./src/ArchivoSalidaMN.txt", false);
			pr=new PrintWriter(archivoS);
			
			for (int i = 0; i < a.length; i++) 
				pr.println(a[i]);
			
		}catch (IOException e){
			System.out.println("Error al abrir o crear el archivo");
		}finally{
			try{
				archivoS.close();
			}catch(IOException e){
				System.out.println("Error al cerrar el archivo");
			}
		}//Final del archivo para escritura.
	}
}