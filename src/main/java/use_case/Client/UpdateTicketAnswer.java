package use_case.Client;

import domain.MailRepository;
import domain.TicketRepository;
import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import domain.models.UserNotFoundException;

import java.util.List;

public class UpdateTicketAnswer {

    private final TicketRepository ticketRepository;
    private final MailRepository mailRepository;

    public UpdateTicketAnswer(TicketRepository ticketRepository, MailRepository mailRepository) {
        this.ticketRepository = ticketRepository;
        this.mailRepository = mailRepository;
    }

    public void execute(List<Ticket> tickets) throws InvalidAnswerException, UserNotFoundException {
        for(Ticket ticket : tickets){
            this.ticketRepository.updateTicket(ticket.getId(),ticket.getAnswer());
        }
        mailRepository.sendConfirm(tickets.get(0).getUser_id());

    }

}
