package jogovelha;

import java.util.Scanner;

public class JogoDaVelha {    
 public static void main(String[] args) {
    
     Scanner scan = new Scanner(System.in);
    Jogo[][] jogo = new Jogo[3][3]; 
     String[] posicao =new String[2];  
     instanciando(jogo);
   

          limparTela(40);
          começarJogo(jogo,posicao,scan);
    
        }

public static void instanciando(Jogo[][] jogo){
    for(int l = 0; l<3;l++){
         for(int c=0; c<3;c++){
             jogo[l][c] = new Jogo();

         }

    }
}


public static void desenharJogo(Jogo[][] jogo){
 System.out.println("                         JOGO DA VELHA\n\n\n\n\n\n");
 System.out.println ("  \u001B[31m       0    1    2\u001B[0m");
  System.out.println("  \u001B[36mL\u001B[0m");
  System.out.printf("  \u001B[36mi  0\u001B[0m    %s | %s | %s   \n",jogo[0][0].getSimbolo(),jogo[0][1].getSimbolo(),jogo[0][2].getSimbolo());
  System.out.printf("  \u001B[36mn  1\u001B[0m    %s | %s | %s   \n",jogo[1][0].getSimbolo(),jogo[1][1].getSimbolo(),jogo[1][2].getSimbolo());
  System.out.printf("  \u001B[36mh  2\u001B[0m    %s | %s | %s   \n",jogo[2][0].getSimbolo(),jogo[2][1].getSimbolo(),jogo[2][2].getSimbolo());
  System.out.println("  \u001B[36ma\u001B[0m\n");
}



                        
                             // os simbolos  //o jogo em si //posicao     //scanner
public static void começarJogo(Jogo[][] jogo,String[] posicao,Scanner scan){
    String capturar; //vai capturar um caractere
    Boolean[] vitoria = {true};
    Boolean ativo = true;
    int[] posicao1 = new int [2];

while(ativo){

    for(int i = 1; i < 3 ; i++){ //quando  o i for igual a 1 vai ser a vez do jogador x jogar e quando for igual a 2  vai ser a vez do jogador o jogar
    if(i == 1){               //
        capturar = "x";      //esse if e else é para determinar o "x" e "o"
    }else{ capturar = "o";}  //

     desenharJogo(jogo);

 System.out.printf("Jogador %s, digite a posiçãoo onde deseja colocar\n\n\n",capturar);
 
 while(true){
 System.out.print(" Linha: ");
 posicao[0] = scan.next();
   if(posicao[0].matches("[0-2]")){break; }else{System.out.println("Erro, digite novamente a linha!!!\n");}
 } posicao1[0] = Integer.parseInt(posicao[0]);
 
 while(true){
 System.out.print(" Coluna: ");
  posicao[1] = scan.next();
  if(posicao[1].matches("[0-2]")){break;}else{System.out.println("Erro, digite novamente a coluna!!!\n");}
  
 } posicao1[1] = Integer.parseInt(posicao[1]);

  
 jogo[posicao1[0]][posicao1[1]].setSimbolo(capturar);
           
         if(jogo[posicao1[0]][posicao1[1]].getError() ){ //caso acontecer algum erro, o processo vai se repetir
            /*ifs de uma linha */ if(i == 1){ --i; }else{ --i;}//caso i for 1 ele vai da -- nele transformando em 0, e quando passar pelo for ele vai virar 1, entao assim fazendo com que volte tudo denovo
              limparTela(30);
            System.out.println("Erro, tente novamente!!!\n\n");   
       
     }
        limparTela(30);
            verificarVitoria(jogo,vitoria);   
            if(vitoria[0].equals(false)){
                    System.out.printf("\n\n\nJogador %s venceu a partida\n............................\n",capturar);     
                    ativo = false; 
                    break;
            }
      
    
        }//do for
           

}//while
            
}
 public static void verificarVitoria(Jogo[][] jogo,Boolean[] vitoria){
String simbolo ;

for(int s = 0; s<2;s++){
 
  if(s == 0){
      simbolo = "x";
  }else{simbolo = "o"; }

if(jogo[0][0].getSimbolo() == simbolo & jogo[1][0].getSimbolo() == simbolo & jogo[2][0].getSimbolo() == simbolo){ vitoria[0] = false; }
if(jogo[0][1].getSimbolo() == simbolo & jogo[1][1].getSimbolo() == simbolo & jogo[2][1].getSimbolo() == simbolo){ vitoria[0] = false; }
if(jogo[0][2].getSimbolo() == simbolo & jogo[1][2].getSimbolo() == simbolo & jogo[2][2].getSimbolo() == simbolo){ vitoria[0] = false; }


if(jogo[0][0].getSimbolo() == simbolo & jogo[0][1].getSimbolo() == simbolo & jogo[0][2].getSimbolo() == simbolo ){ vitoria[0] = false; } 
if(jogo[1][0].getSimbolo() == simbolo & jogo[1][1].getSimbolo() == simbolo & jogo[1][2].getSimbolo() == simbolo ){ vitoria[0] = false;}
if(jogo[2][0].getSimbolo() == simbolo & jogo[2][1].getSimbolo() == simbolo & jogo[2][2].getSimbolo() == simbolo ){ vitoria[0] = false;}


if(jogo[0][0].getSimbolo() == simbolo & jogo[1][1].getSimbolo() == simbolo & jogo[2][2].getSimbolo() == simbolo ){ vitoria[0] = false;} 
if(jogo[0][2].getSimbolo() == simbolo & jogo[1][1].getSimbolo() == simbolo & jogo[2][0].getSimbolo() == simbolo ){ vitoria[0] = false;}  
}

}

public static void limparTela(int a){

    for(int i = 0 ; i < a; i++){ System.out.println();}
}


}

