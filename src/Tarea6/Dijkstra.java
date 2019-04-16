package Tarea6;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra implements Algoritmo{

	//ir de j hasta i
	public String[] calcularCaminoDeCostoMinimo(int[][] matrix,int nodoInic) {

		ArrayList<Integer> e = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();		
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
			int i = q.poll();
			
			
			for(int j=0;j<distancias.length;j++) 
			{
				if(!(matrix[i][j] == -1))
				{
					if(!(matrix[i][j] == 0 ) && !(e.contains(j)))
					{
						e.add(j);
						q.add(j);
					}
					
					
					if(distancias[i] + matrix[i][j] <  distancias[j])
					{
						if( distancias[i] == Integer.MAX_VALUE)
						{
							distancias[j] =  matrix[i][j];
							
							
						}
						else
						{
							distancias[j] = distancias[i] + matrix[i][j];
							
						}
						
						caminoMasCorto[j] = caminoMasCorto[i] + "   " + j;
					}					
				}	
				
			}
		}
		return caminoMasCorto;
	}




}
