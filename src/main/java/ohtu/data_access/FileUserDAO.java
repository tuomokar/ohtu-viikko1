package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

public class FileUserDAO implements UserDao {

    private String fileName;

    public FileUserDAO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> listAll() {
        return read();
    }

    @Override
    public User findByName(String name) {
        List<User> users = read();
        for (User user : users) {
            if (user.getUsername().equals(name)) 
                return user;
        }
        return null;
    }

    @Override
    public void add(User user) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(user.toString() + "\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<User> read() {
        List<User> users = new ArrayList<User>();
        
        try {
            Scanner reader = new Scanner(new File(fileName));
            
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] userInfo = line.split(" ");
                User user = new User(userInfo[0], userInfo[1]);
                users.add(user);
            }
        } catch (FileNotFoundException ex) {
            
        }
                    
        return users;
    }

}
