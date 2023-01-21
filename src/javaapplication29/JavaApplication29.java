
package javaapplication29;

import javax.swing.JOptionPane;


public class JavaApplication29 {

    public static void main(String[] args) {
        int mant,op;
        mant=op=0;
        
        mant=Integer.parseInt(JOptionPane.showInputDialog(null,"\n Cantidad de mantenimientos a realizar: "));
          Mantenimiento [] v = new Mantenimiento[mant];
            for(int i=0;i<v.length;i++){
               v[i]=null;
            }
            //REGISTRO LOS MANTENIMIENTOS
            for(int i=0;i<v.length;i++){
              Mantenimiento m = new Mantenimiento();
              m.registrar_Mantenimiento();
              v[i]=m;
            }
            //MUESTRO LOS DATOS
            for(int i=0;i<v.length;i++){
              v[i].mostrar_Mantenimiento();
            }
        do{
            JOptionPane.showMessageDialog(null,"\t MENU DE OPCIONES");
            op=Integer.parseInt(JOptionPane.showInputDialog("\n 1.Listado de técnicos" +
            "\n 2. Listado de mantenimientos" +
            "\n 3. Listar las distintas marcas de PC que ingresaron en mantenimiento " +
            "\n 4. Listar los datos de los clientes que registraron más de 2 PC en un solo mantenimiento" +
            "\n 5. Cantidad de mantenimientos asignados a cada técnico" +
            "\n 6. Promedio de mantenimientos realizados por técnicos" +
            "\n 7. Mostrar los datos del mantenimiento de mayor importe" +
            "\n 8. Realizar una matriz de conteo en la que cada fila represente un técnico y cada columna un microprocesador" +
            "\n 9. Ingresar un número de técnico e informar los datos de todas las reparaciones en las que intervino" +
            "\n 10. Ingresar un nombre y apellido de cliente e informar los datos de los mantenimientos solicitados por el mismo" +
            "\n 11. Buscar y modificar un mantenimiento" +
            "\n 12. Buscar y eliminar un mantenimiento" +
            "\n 13. Salir "));        
     
        switch(op){
            case 1: listado_Tecnicos(v);
                break;
                
            case 2: listado_Mant(v);
                break;
            case 3: marcas_Pcs(v);
                break;
                
            case 4: listado_Pcs(v);
                break;
                
            case 5: cantidad_mant_Xtec(v);
                break;
                
            case 6: promedio(v);
                break;
                
            case 7: mayor_Importe(v);
                break;
                
            case 8: matriz(v);
                break;
                
            case 9: buscar_Tecnico(v);
                break;
                
            case 10: buscar_Cliente(v);
                break;
                
            case 11:int p= buscar_Mant(v);
                        if(p != -1){
                           v[p].registrar_Mantenimiento();
                           JOptionPane.showMessageDialog(null,"\n Mantenimiento modificado!");
                        }
                break;
                
            case 12: int pos=  buscar_Mant(v);
                         if(pos != -1){
                         v[pos].eliminar_Mantenimiento();
                         }
                break;
                
            case 13: JOptionPane.showMessageDialog(null,"\n Gracias por utlizar el programa");
                break;
         
            default: JOptionPane.showMessageDialog(null,"\n Opcion no valida");
         }
        }while(op!=13);     
    }
public static void listado_Tecnicos(Mantenimiento v[]){
 String mensaje="";
   for(int i=0;i<v.length;i++){
       if(v[i] != null){
         mensaje+= "\n Tecnico: " + v[i].getTec().toString();
         mensaje+="\n-------";
       }
   }
   JOptionPane.showMessageDialog(null, mensaje);
}

public static void listado_Mant(Mantenimiento v[]){
  String mensaje="";
    for(int i=0;i<v.length;i++){
      if(v[i] != null){
        mensaje+= "\n Mantenimientos: " + v[i].toString();
        mensaje+="\n---------";
      }
    }
    JOptionPane.showMessageDialog(null, mensaje);
}
public static void marcas_Pcs(Mantenimiento v[]){
   String aux="";
     String mensaje="";
       for(int i=0;i<v.length;i++){
         for(int j=0;j<v[i].longitud();j++){
           aux= v[i].getMantenimiento(j).getMarca();
         }
             while(aux.compareToIgnoreCase(mensaje) != 0){
               mensaje+=aux; 
             }
      }
      JOptionPane.showMessageDialog(null, mensaje);
   
}

public static void listado_Pcs(Mantenimiento v[]){
  String mensaje,frase;
  mensaje=frase="";
  
    for(int i=0;i<v.length;i++){
      for(int j=0;j<v[i].longitud();j++){
        if(v[i].longitud() > 2){
         mensaje+=  v[i].getCli().toString();
        }     
      }  
    }
    frase+=mensaje;
    JOptionPane.showMessageDialog(null, frase);       
}

public static void cantidad_mant_Xtec(Mantenimiento v[]){
    int c,cc,ccc;
    c=cc=ccc=0;
      for(int i=0;i<v.length;i++){
        if(v[i].getTec().getNum_tec() == 1){
          c++;
        }
        else{
          if(v[i].getTec().getNum_tec() == 2){
            cc++;
          }
        else{
            ccc++;
          } 
        }
      }
      JOptionPane.showMessageDialog(null,"\n Cantidad de MANT asignados al tecnico 1: " + "es" + c);
      JOptionPane.showMessageDialog(null,"\n Cantidad de MANT asignados al tecnico 2: " + "es" + cc);
      JOptionPane.showMessageDialog(null,"\n Cantidad de MANT asignados al tecnico 3: " + "es" + ccc);
}

public static void promedio(Mantenimiento v[]){
    int c,cc,ccc,acu,p,pp,ppp;
    c=cc=ccc=acu=p=pp=ppp=0;
      for(int i=0;i<v.length;i++){
        if(v[i].getTec().getNum_tec() == 1){
          c++;
          acu+=c;
          p= acu/c;
        }
        else{
          if(v[i].getTec().getNum_tec() == 2){
            cc++;
            acu+=c;
            pp= acu/c;
          }
        else{
            ccc++;
            acu+=c;
            ppp= acu/c;
          } 
        }
      }
      JOptionPane.showMessageDialog(null,"\n Promedio de MANT del tecnico 1: " + "es" + p);
      JOptionPane.showMessageDialog(null,"\n Promedio de MANT del tecnico 2: " + "es" + pp);
      JOptionPane.showMessageDialog(null,"\n Promedio de MANT del tecnico 3: " + "es" + ppp);
}

public static void mayor_Importe(Mantenimiento v[]){
  int max,pmax;
    max=pmax=0;
      for(int i=0;i<v.length;i++){
        if(i == 0){
          max=v[i].getImporte();
          pmax=i;
        }
        else{
          if(v[i].getImporte() > max){
            max=v[i].getImporte();
            pmax=i;
          }
        }
      }
      JOptionPane.showMessageDialog(null,"\n Datos del mantenimiento de mayor importe: " + v[pmax].toString());
}

public static void matriz(Mantenimiento v[]){
    int f,c;
    f=c=0;
    int[][] mc = new int[3][3]; //DECLARO LA MATRIZ
      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
           mc[f][c]=0;
        }
      }
      
    for(int i=0;i<v.length;i++){
        f=v[i].getTec().getNum_tec() -1; //ASIGNO AL NUM DE TECNICO EN LA FILA DE LA MATRIZ
        for(int j=0;j<v[i].longitud();j++){
          if(v[i].getMantenimiento(j).getMicroprocesador().compareToIgnoreCase("intel") == 0){ //ASIGNO A LA COLUMNA EL MICROP
            c=0;
          }
          if(v[i].getMantenimiento(j).getMicroprocesador().compareToIgnoreCase("amd") == 0){
            c=1;
          }
          if(v[i].getMantenimiento(j).getMicroprocesador().compareToIgnoreCase("celeron") == 0 ){
           c=2;
          }    
      }
        mc[f][c] = mc[f][c]+1;
    }
    
    JOptionPane.showMessageDialog(null, "                    | INTEL | AMD | CELERON |\n" +
    "Tecnico 1:     " + mc[0][0] + "            " + mc[0][1] + "            " + mc[0][2] + "\n" +
    "Tecnico 2:     " + mc[1][0] + "            " + mc[1][1] + "            " + mc[1][2] + "\n" +
    "Tecnico 3:     " + mc[2][0] + "            " + mc[2][1] + "            " + mc[2][2] + "\n" );     
}
public static void buscar_Tecnico(Mantenimiento v[]){
  String mensaje="";
    boolean ban=false;
    int t=0;
      t=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el numero de tecnico que busca: "));
        for(int i=0;i<v.length;i++){
          if(v[i].getTec().getNum_tec() == t){
            ban=true;
            mensaje+= "\n Reparaciones que realizo: " + v[i].toString(); //INFORMO LA REPARACION
            mensaje+="\n---------";
          }
        }
        if(ban == false){
          JOptionPane.showMessageDialog(null,"\n El tecnico no registra reparaciones");
        }
        JOptionPane.showMessageDialog(null, mensaje);
}

public static void buscar_Cliente(Mantenimiento v[]){
  String mensaje,nom;
    mensaje=nom="";
    boolean ban=false;
    nom=JOptionPane.showInputDialog("\n Ingrese el nombre del cliente que busca: ");
      for(int i=0;i<v.length;i++){
        if(v[i].getCli().getNomyape().compareToIgnoreCase(nom) == 0){
            ban=true;
            mensaje+= "\n Mantenimientos que solicito: " + v[i].toString();
            mensaje+= "\n---------";
        }
      }
      if(ban == false){
           JOptionPane.showMessageDialog(null,"\n Cliente no encontrado"); 
      }
       JOptionPane.showMessageDialog(null, mensaje);
}
public static int buscar_Mant(Mantenimiento v[]){
  int n=0;
   int pos = -1;
    boolean ban=false;
      n=Integer.parseInt(JOptionPane.showInputDialog("\n Ingrese el numero de mantenimiento que busca: "));
      for(int i=0;i<v.length;i++){
        if(v[i].getNum_m() == n){
           pos=i;
           ban=true;
        }    
     }
      if(ban==false){
        JOptionPane.showMessageDialog(null,"\n Numero de mantenimiento no encontrado"); 
      }
      return pos;
}


}
