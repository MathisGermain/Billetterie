package use_case.Initialise;

import domain.TicketRepository;
import domain.models.Ticket;

import java.util.List;

public class InitialiseTicketsList {

    TicketRepository ticketRepository;

    public void SetTicketsList(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void setAllTickets(List<Ticket> ticketList){
        ticketRepository.setTickets(ticketList);
    }


}
