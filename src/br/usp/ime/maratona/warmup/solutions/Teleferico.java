package br.usp.ime.maratona.warmup.solutions;

import br.usp.ime.maratona.warmup.Desafio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Teleferico implements Desafio<Integer> {
    
    @Override
    public Integer executar(File input) {
           try {
                Scanner scan = new Scanner(input);

                int qtdcabine = scan.nextInt();
                int pessoas = scan.nextInt();
                int resposta = 1;
                scan.close();

                if(pessoas==qtdcabine){
                    resposta= 2;

                }else{
                    if(pessoas<qtdcabine){
                    resposta=1;
                }else{
                    if(pessoas>qtdcabine){
                        for(int i = pessoas;  i>=qtdcabine;){
                            resposta+=1;
                            //soma= i-QTDcabine-1;
                            i-=qtdcabine-1;
                        }
                    }
                }   
                }
                return resposta;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }
            
        return null;
    }
}
