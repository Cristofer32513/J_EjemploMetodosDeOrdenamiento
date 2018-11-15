class MetodosDeOrdenamiento{

	
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
	
}

public class EjemploMetodosOrdenamiento {

	public static void main(String[] args) {
			
	}
}