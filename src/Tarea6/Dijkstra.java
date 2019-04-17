package Tarea6;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra implements Algoritmo{


	public int[][] calcularCaminoDeCostoMinimo(int[][] matrix) {

		

		int[][] distancias = new int[matrix.length][matrix.length];
		int nodoInic = 0;
		while(nodoInic<matrix.length)
		{
			ArrayList<Integer> e = new ArrayList<Integer>();//marcados
			ArrayList<Integer> q = new ArrayList<Integer>();//cola
			int[] temp = distancias[nodoInic];
			q.add(nodoInic);
			e.add(nodoInic);


			temp[nodoInic] = 0;
			for(int z=1;z<temp.length;z++) 
			{
				//Llena temp con infinito
				temp[z] = Integer.MAX_VALUE;
			}
			while ( !q.isEmpty())
			{
				
				//Encontrar el siguiente a elegir(Costo minimo local)
				int minimo  = 0;
				for (int i = 1; i < q.size(); i++){

					if (temp[q.get(i)]<temp[minimo])
						minimo = i;

				}
				int min = q.get(minimo);
				q.remove(minimo);


				for(int j=0;j<temp.length;j++) 
				{
					if(!(matrix[min][j] == -1))
					{
						if(!(matrix[min][j] == 0 ) && !(e.contains(j)))
						{
							e.add(j);
							q.add(j);
						}


						if(temp[min] + matrix[min][j] <  temp[j])
						{
							if( temp[min] == Integer.MAX_VALUE)
							{
								temp[j] =  matrix[min][j];
							}
							else
							{
								temp[j] = temp[min] + matrix[min][j];
							}
						}					
					}	

				}
			}
			temp[nodoInic] = 0;
			nodoInic++;
		}

		return distancias;
	}




}
