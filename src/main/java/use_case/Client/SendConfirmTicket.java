package use_case.Client;

import domain.UserRepository;
import domain.models.User;
import domain.models.UserNotFoundException;

public class SendConfirmTicket {

    private final UserRepository userRepository;

    public SendConfirmTicket(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void sendEmail(int userId) throws UserNotFoundException {
        User user = this.userRepository.getUserById(userId);
        String email = user.getEmail();

        //PRINT / ENVOIE DU MAIL

    }


}
