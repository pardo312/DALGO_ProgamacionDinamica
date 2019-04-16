package Tarea6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord implements Algoritmo {

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
		int k = 0;
		while(k<matrix.length-1)
		{
			for(int i=0;i<matrix.length;i++) 
			{
				for(int j=0;j<matrix.length;j++) 
				{
					if(!(matrix[i][j] == -1) && !(matrix[i][j] == 0 ))
					{
						if(distancias[i] + matrix[i][j]<distancias[j])
						{
							distancias[j] = distancias[i] + matrix[i][j];
							caminoMasCorto[j] = caminoMasCorto[i] + "   " + j;
						}
						
					}
				}
				k++;
			}


		}
		return caminoMasCorto;
	}
}
