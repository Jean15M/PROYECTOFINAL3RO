/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Joseline
 */
public class Autos {
    private String placa;
    private String modelo;
    private String marca;

    public Autos() {
    }
    
    public Autos(String placa, String modelo, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca =  marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Autos{" + "placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + '}';
    }
    
}
