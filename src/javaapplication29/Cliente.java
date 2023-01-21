
package javaapplication29;

import javax.swing.JOptionPane;


public class Cliente {
    private int num_cli;
    private String nomyape;
    private String domicilio;
    
Cliente(){
  num_cli=0;
  nomyape="";
  domicilio="";
}
Cliente(int nc, String nya, String dom){
    this.num_cli=nc;
    this.nomyape=nya;
    this.domicilio=dom;
}

    /**
     * @return the num_cli
     */
    public int getNum_cli() {
        return num_cli;
    }

    /**
     * @param num_cli the num_cli to set
     */
    public void setNum_cli(int num_cli) {
        this.num_cli = num_cli;
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

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
public void registrar_Cliente(){
    
  do{
      this.num_cli=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el numero de cliente: "));
         if(this.getNum_cli() < 1){
            JOptionPane.showMessageDialog(null,"\n El numero debe ser mayor a cero!");
         }
  }while(this.getNum_cli() < 1);
  
  do{
     this.nomyape=JOptionPane.showInputDialog("\n Ingrese el nombre y apellido: ");
        if(this.getNomyape().compareToIgnoreCase("") == 0){
           JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
        }
  }while(this.getNomyape().compareToIgnoreCase("") == 0);
  
  do{
      this.domicilio=JOptionPane.showInputDialog("\n Ingrese el domicilio: ");
         if(this.getDomicilio().compareToIgnoreCase("") == 0){
           JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
         }
  }while(this.getDomicilio().compareToIgnoreCase("") == 0);  
}

    @Override
    public String toString(){
   String mensaje="";
      mensaje= "\n Numero de cliente: " + this.num_cli +
               "\n Nombre y apellido del cliente: " + this.nomyape +
               "\n Domicilio del cliente: " + this.domicilio;
      return mensaje;
}
    public void mostrar_Cliente(){
       JOptionPane.showMessageDialog(null, toString());
    }
    
    public void eliminar_Cliente(){
    this.setNum_cli(0);
    this.setNomyape("");
    this.setDomicilio("");
    JOptionPane.showMessageDialog(null,"\n Cliente eliminado!");
    }

    
}
