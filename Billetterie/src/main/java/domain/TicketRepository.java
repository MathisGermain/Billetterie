package domain;

import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import domain.models.TicketNotFoundException;
import domain.models.User;

import java.util.List;

public interface TicketRepository {

    List<Ticket> getTickets(User user);

    List<Ticket> getAllChosenTickets();

    Ticket getTicketById(int ticketId)throws TicketNotFoundException;

    void updateTicket(int ticketId,String answer) throws InvalidAnswerException;



}
