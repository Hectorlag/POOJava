
package javaapplication29;

import javax.swing.JOptionPane;


public class Pc {
    private String marca;
    private String microprocesador;
    private int memoria;
    private int disco;
 
    Pc(){
    marca="";
    microprocesador="";
    memoria=0;
    disco=0;
    }
    Pc( String m, String mic, int mem, int dis){
      this.marca=m;
      this.microprocesador=mic;
      this.memoria=mem;
      this.disco=dis;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the microprocesador
     */
    public String getMicroprocesador() {
        return microprocesador;
    }

    /**
     * @param microprocesador the microprocesador to set
     */
    public void setMicroprocesador(String microprocesador) {
        this.microprocesador = microprocesador;
    }

    /**
     * @return the memoria
     */
    public int getMemoria() {
        return memoria;
    }

    /**
     * @param memoria the memoria to set
     */
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    /**
     * @return the disco
     */
    public int getDisco() {
        return disco;
    }

    /**
     * @param disco the disco to set
     */
    public void setDisco(int disco) {
        this.disco = disco;
    }
public void registrar_Pc(){
   
    do{
      this.marca=JOptionPane.showInputDialog(null,"\n Ingrese la marca: ");
         if(this.getMarca().compareToIgnoreCase("") == 0){
           JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
         }
    }while(this.getMarca().compareToIgnoreCase("") == 0);
    
    do{
       this.microprocesador=JOptionPane.showInputDialog("\n Ingrese el microprocesador: ");
          if(this.getMicroprocesador().compareToIgnoreCase("intel") != 0 &&
                  this.getMicroprocesador().compareToIgnoreCase("celeron") !=0 &&
                     this.getMicroprocesador().compareToIgnoreCase("amd") != 0){
           JOptionPane.showMessageDialog(null,"\n Opciones validas: (Intel-Celeron-Amd");
           }
    }while(this.getMicroprocesador().compareToIgnoreCase("intel") != 0 &&
            this.getMicroprocesador().compareToIgnoreCase("celeron") != 0 &&
               this.getMicroprocesador().compareToIgnoreCase("amd") != 0);
    
    do{
       this.memoria=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese la cantidad de memoria: "));
          if(this.getMemoria() < 1){
             JOptionPane.showMessageDialog(null,"\n Debe ingresar un valor mayor a cero");
          }
    }while(this.getMemoria() < 1);
    
    do{
       this.disco=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el tamnio del disco: "));
          if(this.getDisco() < 1){
          JOptionPane.showMessageDialog(null,"\n Debe ser mayor a cero");
          }
    }while(this.getDisco() < 1);  
}

    @Override
    public String toString(){
        String mensaje="";
        mensaje= "\n Marca: " + this.marca +
                 "\n Microprocesador: " + this.microprocesador +
                 "\n Memoria: " + this.memoria +
                 "\n Disco: " + this.disco;
     return mensaje;
}
    public void mostrar_Pc(){
      JOptionPane.showMessageDialog(null, toString());
    }
    
    public void eliminar_Pc(){
    this.setMarca("");
    this.setMicroprocesador("");
    this.setMemoria(0);
    this.setDisco(0);
    }
    
    
    
    
    
    
    
    
    
    
}
