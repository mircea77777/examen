/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AngajatDao;
import dao.UserDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import model.Angajat;
import model.User;

/**
 *
 * @author Lenovo
 */
public class MainService {
  private String user = "root";
  private String pass = "";
  private String url = "jdbc:mysql://localhost/java1curs15";
  private Connection con;
  private MainService(){
      try{
          con = DriverManager.getConnection(url,user,pass);
      
      }catch(SQLException e){
          e.printStackTrace();
      }
  
  
  }
  private static final class SingletonHolder{
      private static final MainService INSTANCE = new MainService();
  
  }
  
  public static MainService getInstance(){
      return SingletonHolder.INSTANCE;
  }

    
    
    
    public Optional<User> login(String username, String parola){
        UserDao userDao = new UserDao(con);
        try{
            Optional<User> optionalUser=
            userDao.findUser(username);
            if(optionalUser.isPresent()){
                if(optionalUser.get().getParola().equals(parola))                {
                    return optionalUser;
                }                
            }
        
        
        }catch(SQLException e){
            e.printStackTrace();
        
        }
        return Optional.empty();
        
        
    }
    
    public boolean inregistrare(User user){
        boolean rez=false;
        UserDao userDao= new UserDao(con);
        try{
            Optional<User> optionalUser = userDao.findUser(user.getNume());
            if(!optionalUser.isPresent()){
                userDao.adaugaUser(user);
                rez=true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rez;
    }
    
    public List<Angajat> getAllAngajat(){
        AngajatDao angajatDao = new AngajatDao(con);
        try{
            return angajatDao.getAllAngajat();
        }catch(SQLException e){}
        return Collections.emptyList();
        
    
    }
    
    public void adaugaAngajat(Angajat a){
        AngajatDao angajatDao = new AngajatDao(con);
        
        try{
            angajatDao.adaugaAngajat(a);
        }catch(SQLException e){
        
        }
    }
    
    public void stergeAngajat(String nume){
        AngajatDao angajatDao = new AngajatDao(con);
        try{
            angajatDao.stergeAngajat(nume);
        }catch(SQLException e){
        
        }
    }
    
   public List<Double> getSalariiBucuresti(){
       AngajatDao angajatDao = new AngajatDao(con);
        try{
            return angajatDao.getSalariiBucuresti();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
   }
    
    
    
}
