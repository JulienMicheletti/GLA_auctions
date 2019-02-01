/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Users;

/**
 *
 * @author schnabel2u
 */
@Stateless(name = "UserManager")
public class UsersManagerBean implements UsersManagerBeanLocal {
    
    @PersistenceContext(unitName = "GLAPU")
    private EntityManager em;
    
    
    public Boolean addUser(){
        Users user = new Users();
        em.persist(user);
        return true;
    }
    
    public Users firstCustomer() {
        Users users = em.find(Users.class, 1L);
        return users;
    }

    @Override
    public Boolean addUser(String last, String first, String login, String password) {
        Users user = new Users(login,password,last,first,false);
        em.persist(user);
        return true;
    }

    @Override
    public Users getCustommer(int id) {
        Users users = em.find(Users.class, id);
        return users;
    }

    @Override
    public Users getCustommerLogin(String login) {
        Query q = em.createNamedQuery("Users.findAll");
        System.out.println(q.getResultList());
        Query query = em.createNamedQuery("Users.findByLogin");
        query.setParameter("login",login);
        return (Users)query.getSingleResult();
    }

    @Override
    public void deleteUser(int id) {
        Users users = this.getCustommer(id);
        em.remove(users);
    }

    @Override
    public void deleteUserLogin(String login) {
        Users users = this.getCustommerLogin(login);
        em.remove(users);
    }

    @Override
    public Users addAddress(int id, String address) {
        Query query = em.createNamedQuery("Users.updateAddress");
        query.setParameter("id",id);
        query.setParameter("address", address);
        return (Users)query.getSingleResult();
    }

    @Override
    public Users addAddressLogin(String login, String address) {
        Query query = em.createNamedQuery("Users.updateAddressLogin");
        query.setParameter("login",login);
        query.setParameter("address", address);
        return (Users)query.getSingleResult();
    }

    @Override
    public Users addCB(int id, int cb) {
        Query query = em.createNamedQuery("Users.updateCB");
        query.setParameter("id",id);
        query.setParameter("cb", cb);
        return (Users)query.getSingleResult();
    }

    @Override
    public Users addCBLogin(String login, int cb) {
        Query query = em.createNamedQuery("Users.updateCBLogin");
        query.setParameter("login",login);
        query.setParameter("cb", cb);
        return (Users)query.getSingleResult();
    }

    public Users find(String champ, String valeur){
        /*Users res = new Users();
        try{
            /*Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT u FROM USERS WHERE "+champ+"="+valeur);
            while(rs.next()){
                res.setLogin(rs.getString("login"));
                res.setPassword(rs.getString("password"));
                res.setFirstname(rs.getString("firstname"));
                res.setLastname(rs.getString("lastname"));
                res.setId(rs.getInt("id"));
                res.setAddress(rs.getString("address"));
                res.setCb(rs.getInt("cb"));
            }
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return res;*/


        return null;
    }
    

        
    
}
