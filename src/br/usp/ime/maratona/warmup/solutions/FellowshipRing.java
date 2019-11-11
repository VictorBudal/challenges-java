package br.usp.ime.maratona.warmup.solutions;

import br.usp.ime.maratona.warmup.Desafio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FellowshipRing implements Desafio<Integer> {
    
    @Override
    public Integer executar(File input) {
        
       try {
            Scanner scan = new Scanner(input);
           
            int cintura = scan.nextInt();
            int pescoco = scan.nextInt();
            int socos = scan.nextInt();
            int alturaSocos=0;
            int socosValidos=0;

            for(int i  = 0 ; i<socos;i++){
                alturaSocos=scan.nextInt();
                if(alturaSocos>=cintura && alturaSocos<=pescoco){
                    socosValidos++;
                }

            }

            return socosValidos;


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            
            }

        return null;
    }    
}
