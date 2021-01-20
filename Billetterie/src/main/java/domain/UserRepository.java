package domain;

import domain.models.User;
import domain.models.UserNotFoundException;

public interface UserRepository {

    public User getUserById(int userId) throws UserNotFoundException;

}
