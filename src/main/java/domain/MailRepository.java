package domain;

import domain.models.UserNotFoundException;

public interface MailRepository {

    public void sendConfirm(int userId) throws UserNotFoundException;

}
