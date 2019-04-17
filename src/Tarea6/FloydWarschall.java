package Tarea6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FloydWarschall implements Algoritmo {


	public int[][] calcularCaminoDeCostoMinimo(int[][] matrix) {
	
		
		int[][] distancias = arreglarMatriz(matrix);//Pone infinitos en vez de -1
	
		for(int i=0;i<distancias.length;i++) 
		{
			for(int j=0;j<distancias.length;j++) 
			{
				for(int k=0;k<distancias.length;k++) 
				{
					int inic = distancias[i][j];
					int p= distancias[i][k];
					int q =   distancias[k][j];
					int h = p + q;
					if( p +q < inic)
					{
						distancias[i][j]  = distancias[i][k] +  distancias[k][j];
					}
						
				}
			}
		}
		return distancias;
	}
	
	
	public int[][] arreglarMatriz(int[][] matrix)
	{
		for(int i=0;i<matrix.length;i++) 
		{
			for(int j=0;j<matrix.length;j++) 
			{
				if(matrix[i][j] == -1)
				{
					matrix[i][j] = 500000;//Representa infinito
				}						
			}
		}
		return matrix;
	}
}


