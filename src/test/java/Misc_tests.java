
import com.x.dao.GenericDao;
import com.x.dao.UserDao;
import com.x.helpers.Helper;
import com.x.model.Product;
import com.x.model.User;
import com.x.types.Measure;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author X
 */
public class Misc_tests {
    public static void main(String[] args) {
        GenericDao dao = new GenericDao(User.class);
        User user =(User) dao.findbyID("asifiwe@gmail.com");
        System.out.println(user.getLastName());
//          User user = new User();
//          user.setEmail("asifiwemanzi@gmail.com");
//          user.setFirstName("Manzi");
//          user.setLastName("Asifiwe");
//          user.setPassword("Test");
//          user.setCreationDate(new Date());
//          
//          UserDao dao = new UserDao(User.class);
//          dao.createUser("asifiwemanzi@gmail.com", "Manzi", "Asifiwe", "Test");
    }
}
