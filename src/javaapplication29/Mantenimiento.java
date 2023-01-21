/*
número de 
mantenimiento, un técnico, un cliente y la/s computadoras a reparar, diagnóstico general e importe del 
mantenimiento
 */
package javaapplication29;

import javax.swing.JOptionPane;

public class Mantenimiento {
    private int num_m;
    private Tecnico tec;
    private Cliente cli;
    private Pc [] vec;
    private String diagnostico;
    private int importe;
    
Mantenimiento(){
    num_m=0;
    tec=null;
    cli=null;
    vec=null;
    diagnostico="";
    importe=0;
}
Mantenimiento(int nm, Tecnico t, Cliente c, int cmant, String diag, int imp){
    this.num_m=nm;
    this.tec=t;
    this.cli=c;
    this.vec= new Pc[cmant];
}

  public void setMantenimeinto(int pos, Pc p){
    if(pos >= 0 && pos <= vec.length){
       this.vec[pos] = p;
    }
  }
  
  public Pc getMantenimiento(int pos){
     if(pos >= 0 && pos <= vec.length){
       return vec[pos];
     }
     else{
       JOptionPane.showMessageDialog(null,"\n Posicion no valida");
     }
     return null;
  }
  
  public int longitud(){
    return vec.length;
  }

    /**
     * @return the num_m
     */
    public int getNum_m() {
        return num_m;
    }

    /**
     * @param num_m the num_m to set
     */
    public void setNum_m(int num_m) {
        this.num_m = num_m;
    }

    /**
     * @return the tec
     */
    public Tecnico getTec() {
        return tec;
    }

    /**
     * @param tec the tec to set
     */
    public void setTec(Tecnico tec) {
        this.tec = tec;
    }

    /**
     * @return the cli
     */
    public Cliente getCli() {
        return cli;
    }

    /**
     * @param cli the cli to set
     */
    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the importe
     */
    public int getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(int importe) {
        this.importe = importe;
    }
 public void registrar_Mantenimiento(){
   do{
     this.num_m=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el numero de mantenimiento: "));
        if(this.getNum_m() < 1){
          JOptionPane.showMessageDialog(null,"\n Ingrese un numeor mayor a cero");
        }
   }while(this.getNum_m() < 1);
   
     Tecnico t = new Tecnico();
     t.registrar_Tecnico();
     this.setTec(t);
   
     Cliente c = new Cliente();
     c.registrar_Cliente();
     this.setCli(c);
     
     int compus=0;
     do{
       compus=Integer.parseInt(JOptionPane.showInputDialog("\n Cantidad de pc a reparar: "));
          if(compus < 1){
             JOptionPane.showMessageDialog(null,"\n Debe ingresar un valor mayor a cero");
          }
     }while(compus < 1 );
     
     //LE DOY UN VALOR AL VECTOR DE PCS
     vec=new Pc[compus];
     
     //SE REGISTRA LA PC
     for(int i=0;i<vec.length;i++){
       Pc p = new Pc();
       p.registrar_Pc();
       vec[i]=p;
     }
     
     do{
         this.diagnostico=JOptionPane.showInputDialog("\n Ingrese el diagnostico: ");
            if(this.getDiagnostico().compareToIgnoreCase("") == 0){
              JOptionPane.showMessageDialog(null,"\n Debe ingresar algun caracter");
            }
     }while(this.getDiagnostico().compareToIgnoreCase("") == 0);
   
     do{
         this.importe=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el importe: "));
            if(this.getImporte() < 1){
               JOptionPane.showMessageDialog(null,"\n El importe debe ser mayor que cero");
            }
     }while(this.getImporte() < 1); 
 }
 
    @Override
 public String toString(){
    String mensaje="";
       mensaje=  "\n Numero de mantenimiento: " + this.num_m +
                    this.cli.toString() +
                    this.tec.toString();
       
                   mensaje+= "\n Pcs"; 
                     for(int i=0;i<vec.length;i++){
                       mensaje+=vec[i].toString();
                    }
               mensaje+="\n Diagnostico: " + this.diagnostico +
                         "\n Importe: " + this.importe;
               return mensaje;
 }
 
 public void mostrar_Mantenimiento(){
    JOptionPane.showMessageDialog(null, toString());
 }
 
 public void eliminar_Mantenimiento(){
   this.setNum_m(0);
   this.setTec(null);
   this.setCli(null);
   this.setMantenimeinto(0, null);
   this.setDiagnostico("");
   this.setImporte(0);
   JOptionPane.showMessageDialog(null,"\n Mantenimiento eliminado");
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
