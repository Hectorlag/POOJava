
package javaapplication29;

import javax.swing.JOptionPane;


public class Tecnico {
    private int num_tec;
    private String nomyape;
    
Tecnico(){
  num_tec=0;
  nomyape="";
} 
Tecnico(int nt, String nya){
   this.num_tec=nt;
   this.nomyape=nya;
}

    /**
     * @return the num_tec
     */
    public int getNum_tec() {
        return num_tec;
    }

    /**
     * @param num_tec the num_tec to set
     */
    public void setNum_tec(int num_tec) {
        this.num_tec = num_tec;
    }

    /**
     * @return the nomyape
     */
    public String getNomyape() {
        return nomyape;
    }

    /**
     * @param nomyape the nomyape to set
     */
    public void setNomyape(String nomyape) {
        this.nomyape = nomyape;
    }

public void registrar_Tecnico(){
   
    do{
       this.num_tec=Integer.parseInt(JOptionPane.showInputDialog("\n Numero de tecnico: "));
          if(this.getNum_tec() < 1 || this.getNum_tec() > 3){
             JOptionPane.showMessageDialog(null,"\n Las opciones validas son 1-2-3");
          }
    }while(this.getNum_tec() < 1 || this.getNum_tec() > 3);
    
    do{
      this.nomyape=JOptionPane.showInputDialog("\n Ingrese el nombre y apellido del tecnico: ");
         if(this.getNomyape().compareToIgnoreCase("") == 0){
           JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
         }
    }while(this.getNomyape().compareToIgnoreCase("") == 0);
}
    @Override
    public String toString(){
  String mensaje="";
    mensaje= "\n Numero de tecnico: " + this.num_tec +
              "\n Nombre y apellido del tecnico: " + this.nomyape;
      return mensaje;
}
public void mostrar_Tecnico(){
  JOptionPane.showMessageDialog(null, toString());
}
    
    
    
    
    
}
