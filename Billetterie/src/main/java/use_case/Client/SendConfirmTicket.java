package use_case.Client;

import domain.TicketRepository;
import domain.UserRepository;
import domain.models.Ticket;
import domain.models.TicketNotFoundException;
import domain.models.User;
import domain.models.UserNotFoundException;

public class SendConfirmTicket {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public SendConfirmTicket(TicketRepository ticketRepository,UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public void sendEmail(int ticketId) throws TicketNotFoundException, UserNotFoundException {
        Ticket ticket = this.ticketRepository.getTicketById(ticketId);
        int userId = ticket.getUser_id();
        User user = this.userRepository.getUserById(userId);
        String email = user.getEmail();

        //PRINT / ENVOIE DU MAIL

    }


}
