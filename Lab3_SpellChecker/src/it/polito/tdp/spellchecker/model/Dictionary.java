package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;


public class Dictionary {
	
	private List<String> dizionario = new LinkedList<String>();


	public void loadDictionary (String language){
		if (language.equals("English")){
			try {
				FileReader fr = new FileReader("rsc/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				
				while ((word = br.readLine()) != null) {
					dizionario.add(word);
				}
			
				br.close();
			} catch (IOException e){
				System.out.println("Errore nella lettura del file");
			}
		}
		if(language.equals("Italian")){
			try {
				FileReader fr = new FileReader("rsc/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				
				while ((word = br.readLine()) != null) {
					dizionario.add(word);
				}
			
				br.close();
			} catch (IOException e){
				System.out.println("Errore nella lettura del file");
			}
		}
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){ 
		List<RichWord> inputText = new LinkedList<RichWord>();

		int numErrori = 0;
		
		for(int i= 0; i<inputTextList.size(); i++){
			
			inputTextList.get(i).replaceAll("[ \\p{Punct}]", "");
			if(dizionario.contains(inputTextList.get(i))==false){
				numErrori++;
				RichWord e = new RichWord(false, inputTextList.get(i));
				inputText.add(e);
			}else{
				RichWord e = new RichWord(true, inputTextList.get(i));
				inputText.add(e);
			}
		}
		
		
		return null;
	}
	
}
