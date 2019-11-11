package br.usp.ime.maratona.warmup.solutions;

import br.usp.ime.maratona.warmup.Desafio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class MorseArithmetic implements Desafio<Integer> {

   
    @Override
    public Integer executar(File input) {
        
        try{
        Scanner scan = new Scanner(input);

        int qtdDeMultiplicadores = scan.nextInt();
        qtdDeMultiplicadores+=1;
        String morse = scan.nextLine();
        morse = scan.nextLine();
        scan.close();
        boolean valor=false;
        int morseTamanho = morse.length();
        int controlador = 0;
        int soma=0,somaFinal=0;
        
        String [] separaMorse = new String[morseTamanho];
        String [] sequenciaMultiplicadores = new String[qtdDeMultiplicadores];
        int []traduzindoMorse = new int [qtdDeMultiplicadores];
        char recebeString[] = new char [morseTamanho];
        String stop = "Stop";
        

        Stack<Integer> pilha = new Stack<Integer>();
    
        
        //Separa o codigo morse
        for(int i =0 ; i<morseTamanho;i++){
            recebeString[i] =morse.charAt(i);
            
            if(recebeString[i]=='*'|| recebeString[i]== '+' ){
                sequenciaMultiplicadores[controlador] =String.valueOf(recebeString[i]) ;
                
                separaMorse[i]="0";
                controlador+=1;
            }else{
                separaMorse[i]= String.valueOf(recebeString[i]);
            }
        }
        sequenciaMultiplicadores[controlador]=stop;

        //Transforma de morse para numero
        controlador=0;
        for(int i  = 0 ; i<morseTamanho;i++){
            
            
            switch(separaMorse[i]){
                case ".":
                    traduzindoMorse[controlador]+=1;
                    break;
                case ":":
                    traduzindoMorse[controlador]+=2;
                    break;
                case "-":
                    traduzindoMorse[controlador]+=5;
                    break;
                case "=":
                    traduzindoMorse[controlador]+=10;
                    
                    break;
                case "0":
                    controlador++;
                  
                    break;

            }
        }
        //Mexendo com a pilha
        for(int i = 0 ; i<qtdDeMultiplicadores;i++){
            pilha.push(traduzindoMorse[i]);
            if(valor){
                    pilha.pop();
                }

            if(stop.equals(sequenciaMultiplicadores[i])){
              
                

            }else{
                
                if("*".equals(sequenciaMultiplicadores[i])){
                    soma= 0;
                    soma=pilha.pop();
                    soma=soma*traduzindoMorse[i+1];
                   
                    pilha.push(soma);
                  
                    
                    valor= true;
                 }else{   

                    valor =false;
                 }
            }
        }

        while(!pilha.empty()){
            somaFinal+=pilha.pop();

        }
         return somaFinal;
    
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        
        return null;
    }
}
