package Tarea6;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ss {
	public static void main(String[] args) throws IOException{
		String p ="./data/distances5.txt";
		BufferedReader bf = new BufferedReader(new FileReader(p));
		String [][] matrixGrafo = new String[5][5];
		
		for(int i=0;i<5;i++) 
		{
			String[] s = bf.readLine().split("	");
			for(int j=0;j<5;j++) 
			{
			matrixGrafo[i][j] = s[j];
			}
			
		}
		System.out.println("");
		
	}
}
