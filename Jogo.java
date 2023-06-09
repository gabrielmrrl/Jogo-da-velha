package jogovelha;

public class Jogo {
    
private String simbolo = " ";
private Boolean error;


public String getSimbolo(){ 
    
    return  this.simbolo;       
}

public void setSimbolo(String simbolo){
   if(this.simbolo == " "){
         if(simbolo == "x"){ simbolo = "\u001B[32mx\u001B[0m"; }else{ simbolo = "\u001B[33mo\u001B[0m";}
       this.simbolo = simbolo;
       this.error = false;
   }else{
       this.error = true;
   }
    
}

public Boolean getError(){ return this.error; }




}
