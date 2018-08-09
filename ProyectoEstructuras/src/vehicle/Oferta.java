/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

/**
 *
 * @author EduardOrtiz
 */
public class Oferta {
    private String placa;
    private String correo;
    private int precioOfertado;
    
    public Oferta(String placa, String correo, int precioOfertado) {
        this.placa = placa;
        this.correo = correo;
        this.precioOfertado = precioOfertado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPrecioOfertado() {
        return precioOfertado;
    }

    public void setPrecioOfertado(int precioOfertado) {
        this.precioOfertado = precioOfertado;
    }

    @Override
    public String toString() {
        return placa + "|" + correo + "|" + precioOfertado ;
    }
    
    
    
    
}
