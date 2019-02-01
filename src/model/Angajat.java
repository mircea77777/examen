/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public class Angajat {
    private String nume;
    private String adresa;
    private Double salariu;

    public Angajat(){}
    
    public Angajat(String nume, String adresa, Double salariu) {
        this.nume = nume;
        this.adresa = adresa;
        this.salariu = salariu;
    }
    
   

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Double getSalariu() {
        return salariu;
    }

    public void setSalariu(Double salariu) {
        this.salariu = salariu;
    }
    
    
}
