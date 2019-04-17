package Tarea6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord implements Algoritmo {

	public int[][] calcularCaminoDeCostoMinimo(int[][] matrix) {

		int[][] distancias = new int[matrix.length][matrix.length];
		int nodoInic = 0;

		while(nodoInic<matrix.length)
		{
			int[] temp = distancias[nodoInic];

			
			for(int z=0;z<temp.length;z++) 
			{
				//Llena temp con infinito
				temp[z] = 500000;
			}
			temp[nodoInic] = 0;
			int k = 0;
			while(k<matrix.length-1)
			{
				for(int i=nodoInic;i<matrix.length;i++) 
				{
					for(int j=0;j<matrix.length;j++) 
					{
						if(!(matrix[i][j] == -1) && !(matrix[i][j] == 0 ))
						{
							if(temp[i] + matrix[i][j]<temp[j])
							{
								temp[j] = temp[i] + matrix[i][j];

							}

						}
					}
					k++;
				}
				
				
			}
			
			nodoInic++;
		}
		return distancias;
	}
}
