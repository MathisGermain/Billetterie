package infrastructure.DAO;

import domain.UserRepository;
import domain.models.User;
import domain.models.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

public class InMemoryUser implements UserRepository {

    private List<User> users = null;


    public User getUserById(int userId) throws UserNotFoundException{
        for(User user : users){
            if(user.getId() == userId){
                return user;
            }
        }
        throw new UserNotFoundException();
    }
}
