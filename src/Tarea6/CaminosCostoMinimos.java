package Tarea6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class CaminosCostoMinimos {

	
	/**
	 * Main method for the coin change example. It requires three parameters:
	 * args[0]: Algorithm to run. It can be Dijkstra, BellmanFord or FloydWarschall 
	 * args[1]: File path.
	 * @param args Array with the arguments described above
	 * throws Exception If any denomination appears twice
	 * @throws Exception If the algorithm class can not be loaded 
	 */
	public static void main(String[] args) throws Exception {
		
		//Load algorithm class
		String algorithmClassName = CaminosCostoMinimos.class.getPackage().getName()+"."+args[0];
		Algoritmo algoritmo = (Algoritmo)Class.forName(algorithmClassName).newInstance();
		//Load graph
		BufferedReader bf = new BufferedReader(new FileReader(args[1]));
		String x = args[1].replace("./data/distances", " ").replaceAll("\\s+", " ");
		int size = Integer.parseInt(x.replace(".txt", " ").replaceAll("\\s+", ""));
		int[][] matrixGrafo = new int[size][size];
		
		for(int i=0;i<size;i++) 
		{
			String[] s = bf.readLine().split("	");
			for(int j=0;j<size;j++) 
			{
			matrixGrafo[i][j] = Integer.parseInt(s[j]);
			}
			
		}

		long startTime = System.currentTimeMillis();
		int[][] solucion = algoritmo.calcularCaminoDeCostoMinimo(matrixGrafo);
		long endTime = System.currentTimeMillis();
		
		//Output results
		
		for(int c=0;c<size;c++) 
		{
			for(int f=0;f<size;f++) 
			{
					System.out.print(solucion[c][f] + "    ");
					if(f == size-1)
					{
						System.out.println("\n");
					}
			}
		}
		
		System.out.println("Total time spent (milliseconds): "+(endTime-startTime));
		
		}
}
