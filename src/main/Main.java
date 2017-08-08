 package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
	
	
	
	private static void check(String repositoryUrl) throws Exception {
		
		String dir  = "C:\\Users\\Jaziel Moreira\\Dropbox\\UFCG\\Projeto\\Dados\\CSVs\\refatoramentos"; //windows
		String aux=repositoryUrl.substring(repositoryUrl.lastIndexOf("/")+1);
		int refactoring;
		
		Purity p=new Purity(repositoryUrl);
		Scanner in = new Scanner(new FileReader(dir+"\\1Part\\"+aux+" - refatoramentos.csv")).useDelimiter(";");
		FileWriter fw= new FileWriter(new File(dir+"\\2Part\\"+aux+" - refatoramentos1.csv"));
		
		fw.write("Commit;isRefactoring\n");
		fw.flush();
		String commit="";
		
		in.nextLine();
		while(in.hasNext()) {
			in.next();
			aux=in.next();
			if(!aux.equals(commit)) {
				commit=aux;
				refactoring=p.check(commit, in.next());
				System.out.println("Is refactoring? "+refactoring);
				fw.write(commit+";"+refactoring+"\n");
				fw.flush();
			}
			
			in.nextLine();
		}
		fw.close();
		in.close();
	}

	public static void main(String[] args) throws Exception {
		
		int len=args.length;
		
		for(int i=0;i<len;i++) {
			check(args[i]);
		}
	}
}
