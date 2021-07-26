
import com.x.dao.GenericDao;
import com.x.model.User;
import com.x.types.AccessLevel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author X
 */
public class Tests {
    public static void main(String[] args) {
        GenericDao dao = new GenericDao(User.class);
        User user = (User) dao.findbyID("asifiwe@gmail.com");
//        User user = new User("Manzi", "Asifiwe", "asifiwe@gmail.com", "Pass", AccessLevel.superuser);
//        dao.create(user);
        if(user != null){
        System.out.println(user.getFirstName());}
        else {
            System.out.println("There is no user with that email");
        }
    }
}
