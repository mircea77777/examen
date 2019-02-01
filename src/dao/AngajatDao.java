/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Angajat;

/**
 *
 * @author Lenovo
 */
public class AngajatDao {

    private Connection con;
    public AngajatDao(Connection con) {
        this.con=con;
        
    }
    
    


public List<Angajat> getAllAngajat()throws SQLException{
    String sql =  "SELECT * FROM angajati";
    List<Angajat> angajati = null;
    try(PreparedStatement stmt = con.prepareStatement(sql)){
        angajati = new ArrayList<>();
        ResultSet rs =stmt.executeQuery();
        while(rs.next()){
            String nume = rs.getString("nume");
            String adresa = rs.getString("adresa");
            Double salariu = rs.getDouble("salariu");
            Angajat angajat = new Angajat(nume,adresa,salariu);
            angajati.add(angajat);
        }
    }
    return angajati;

}

public void adaugaAngajat(Angajat a)throws SQLException{
    String sql = "INSERT INTO angajati VALUES (?,?,?)";
    try(PreparedStatement stmt = con.prepareStatement(sql)){
    stmt.setString(1,a.getNume());
    stmt.setString(2,a.getAdresa());
    stmt.setDouble(3,a.getSalariu());
    stmt.executeUpdate();

    
    

}

}

public void stergeAngajat(String nume)throws SQLException{
    String sql = "DELETE FROM angajati WHERE nume=?";
    try(PreparedStatement stmt = con.prepareStatement(sql)){

    stmt.setString(1,nume);
    stmt.executeUpdate();
}

}

public List<Double> getSalariiBucuresti() throws SQLException{
    String sql =  "SELECT salariu FROM angajati WHERE adresa = 'Bucuresti';";
    List<Double> salarii = null;
    try(PreparedStatement stmt = con.prepareStatement(sql)){
        salarii = new ArrayList<>();
        ResultSet rs =stmt.executeQuery();
        while(rs.next()){   
            Double salariu = rs.getDouble("salariu");
            salarii.add(salariu);
        }
    }
    return salarii;
}

}

