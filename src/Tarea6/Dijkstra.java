package Tarea6;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra implements Algoritmo{

	
	public String[] calcularCaminoDeCostoMinimo(int[][] matrix,int nodoInic) {

		ArrayList<Integer> e = new ArrayList<Integer>();//marcados
		ArrayList<Integer> q = new ArrayList<Integer>();//cola
		q.add(nodoInic);
		e.add(nodoInic);
		String[] caminoMasCorto = new String[matrix.length];
		caminoMasCorto[nodoInic] = ""+nodoInic;
		int[] distancias = new int[matrix.length];
		distancias[nodoInic] = 0;
		for(int z=1;z<distancias.length;z++) 
		{
			//Llena distancias con infinito
			distancias[z] = Integer.MAX_VALUE;
		}
		while ( !q.isEmpty())
		{
			//Encontrar el siguiente a elegir(Costo minimo local)
			int minimo  = 0;
			for (int i = 1; i < q.size(); i++){
				
				if (distancias[q.get(i)]<distancias[minimo])
					minimo = i;
					
			}
			int min = q.get(minimo);
			q.remove(minimo);
			

			for(int j=0;j<distancias.length;j++) 
			{
				if(!(matrix[min][j] == -1))
				{
					if(!(matrix[min][j] == 0 ) && !(e.contains(j)))
					{
						e.add(j);
						q.add(j);
					}


					if(distancias[min] + matrix[min][j] <  distancias[j])
					{
						if( distancias[min] == Integer.MAX_VALUE)
						{
							distancias[j] =  matrix[min][j];


						}
						else
						{
							distancias[j] = distancias[min] + matrix[min][j];

						}

						caminoMasCorto[j] = caminoMasCorto[min] + "   " + j;
					}					
				}	

			}
		}
		return caminoMasCorto;
	}




}
