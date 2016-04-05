package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        User user = userDao.findByName(username);
        if (user == null) return false;
        
        return user.getPassword().equals(password);
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        return usernameInvalid(username) || passwordInvalid(password);
    }
    
    private boolean usernameInvalid(String username) {
        return tooShortUsername(username) || usernameIsNotLetters(username);
    }
    
    private boolean passwordInvalid(String password) {
        return tooShortPassword(password) || containsOnlyLetters(password);
    }
    
    private boolean tooShortPassword(String password) {
        return password.length() < 8;
    }
    
    private boolean tooShortUsername(String username) {
        return username.length() <= 3;
    }
    
    private boolean usernameIsNotLetters(String username) {
        return !username.matches("[a-z]*");
    }
    
    private boolean containsOnlyLetters(String password) {
        return password.matches("[a-zA-Z]*");
    }
}
