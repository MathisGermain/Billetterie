package infrastructure.DAO;

import domain.MailRepository;
import domain.UserRepository;
import domain.models.User;
import domain.models.UserNotFoundException;
import infrastructure.DAO.InMemoryUser;

public class ConsoleMail implements MailRepository {

    private UserRepository userRepository;

    public ConsoleMail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void sendConfirm(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        String email = user.getEmail();

        System.out.println("Votre choix a bien été enregistré");
    }
}
