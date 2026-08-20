package org.example.modelo;

public class Alumno extends PersonaUt {
private int numExpediente;
private String grupo;
private double promedio;

public Alumno(){}

    public Alumno(String nombre, String curp, int numExpediente, String grupo, double promedio) {
        super(nombre, curp);
      setNumExpediente(numExpediente);
      setGrupo(grupo);
      setPromedio(promedio);
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
  if(numExpediente > 2000000000 && numExpediente < 2140000000){
      this.numExpediente = numExpediente;
  }else{
      System.out.println("Numero de Expediente invalido");
  }
    }

    public String getGrupo() {
        if(grupo.isEmpty() || grupo.isBlank()){
            System.out.println("El grupo es requeridp");
            return "";
        }else {
            return grupo;
        }
    }

    public void setGrupo(String grupo) {
        if(!grupo.trim().isEmpty() && !grupo.isBlank()){

            this.grupo = grupo;
        }else {
            System.out.println("El grupo es requeridp");
        }

    }

    public double getPromedio() {
    String promedioFormato = String.format("%.1f",this.promedio);
        return Double.parseDouble(promedioFormato);
    }

    public void setPromedio(double promedio) {
        if(promedio >= 0 && promedio <=10){
            this.promedio = promedio;
        }else{
            System.out.println("Promedio Invalido");
        }

        }
    @Override
    public String toString(){
        return "Numero de Expediente: "+getNumExpediente()+"\n"+
                super.toString()+"\n"+
                "Grupo: "+getGrupo()+"\n"+
                "Promedio: "+getPromedio()+"\n"+
                "=====================================";

    }
}
