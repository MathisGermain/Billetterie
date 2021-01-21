package infrastructure.DAO;

import domain.UserRepository;
import domain.models.User;
import domain.models.UserNotFoundException;

import java.util.HashMap;
import java.util.List;

public class InMemoryUser implements UserRepository {

    private List<User> users = null;


    public User getUserById(int userId) throws UserNotFoundException{
        for(int x = 0 ; x < this.users.size() ; x++){
            if(this.users.get(x).getId() == userId){
                return this.users.get(x);
            }
        }
        throw new UserNotFoundException();
    }
}
