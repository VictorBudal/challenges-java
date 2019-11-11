package br.usp.ime.maratona.warmup.solutions;

import br.usp.ime.maratona.warmup.Desafio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutomatedCheckingMachine implements Desafio<String> {
       
    @Override
    public String executar(File input) {
        
        try{
            Scanner scan = new Scanner(input);

            int  entrada1[]= new int [5];
            int  entrada2[]= new int [5];
            String resposta= "Y";
           
            String input1 = scan.nextLine();
            String input2 = scan.nextLine();

            for(int i = 0; i<5; i++){
               entrada1[i]=input1.charAt(i)-'0';
               entrada2[i]=input2.charAt(i)-'0';
               if(entrada1[i]==1 && entrada2[i]==1||entrada1[i]==0 && entrada2[i]==0){
                   resposta = "N";
               }
            }
            
            return resposta;
         } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }
        return null;
    }
}
