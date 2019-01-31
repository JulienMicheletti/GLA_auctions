/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Date;
import java.util.List;
import javax.ejb.Local;
import model.Users;

/**
 *
 * @author lionnet5u
 */
@Local
public interface UsersManagerBeanLocal {
        public Boolean addUser(String last, String first, String login,String password );
        public Users firstCustomer();
        public Users getCustommer(int id);
        public Users getCustommerLogin(String login);
        public void deleteUser(int id);
        public void deleteUserLogin(String login);
        public Users addAddress(int id, String address);
        public Users addAddressLogin(String login, String address);
        public Users addCB(int id, int cb);
        public Users addCBLogin(String login, int cb);
        public Users find(String champs, String valeur);
}
