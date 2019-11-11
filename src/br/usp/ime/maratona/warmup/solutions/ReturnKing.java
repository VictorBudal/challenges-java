package br.usp.ime.maratona.warmup.solutions;

import br.usp.ime.maratona.warmup.Desafio;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class ReturnKing implements Desafio<String> {
    
   
    @Override
    public String executar(File input) {
        try{
            Scanner scan = new Scanner(input);

            DecimalFormat formato = new DecimalFormat("0,00");

            String entrada = scan.next();

            int tamanho = entrada.length();

            double soma= 0;

            int multiplicador=0;

            int tabela[]= new int [tamanho];

            //separa numeros
            for(int i = 0;i<tamanho;i++){
                tabela[i]=entrada.charAt(i) - '0';
            }
            
            //Quantos numeros existem
            for(int i = 0 ; i<tamanho;i++){
                if(tabela[i]==0){
                    multiplicador-=1;
                }
                multiplicador+=1;
            }
            
            //Soma dos numeros
            for(int i =0 ; i<tamanho;i++){
                if(tabela[i]==1){
                        soma+=1;
                    }
                if(tabela[i]==0){
                    soma+=9;
                }
                if(tabela[i]>1){
                    soma+=tabela[i];
                }
            }
            
            soma/=multiplicador;
            soma*=100;
            String resposta=formato.format(soma);
            return resposta;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            
        }
        return null;
    }
}
