package br.usp.ime.maratona.warmup.solutions;

import br.usp.ime.maratona.warmup.Desafio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Fatorial implements Desafio<Integer> {
   
    @Override
    public Integer executar(File input) {
        try {
            Scanner scan = new Scanner(input);
            int entrada = scan.nextInt();
            int []fatoriais = {0,1,2,6,24,120,720,5040,40320};
            boolean verifica  = false;
            int qtdfatoriais= 0;

            while(!verifica){
                verifica = true;
                for(int i = 8 ; i>0;i--){
                    if(fatoriais[i]<=entrada){
                        entrada-=fatoriais[i];
                        i++;
                        qtdfatoriais+=1;
                        verifica = false;
                    }
                }
            }
            
            return qtdfatoriais;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }
        return null;
    }
}
