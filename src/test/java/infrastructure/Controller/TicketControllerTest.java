package infrastructure.Controller;

import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.mockito.Mock;
import use_case.Client.SendConfirmTicket;
import use_case.Client.UpdateTicketAnswer;
import use_case.Initialise.SetTicketsList;

import java.util.ArrayList;
import java.util.List;

public class TicketControllerTest {

    private TicketController ticketController;

    @Mock
    UpdateTicketAnswer updateTicketAnswer;

    @Mock
    SendConfirmTicket sendConfirmTicket;

    @Mock
    SetTicketsList setTicketsList;

    @BeforeEach
    void setUp() {
        ticketController = new TicketController(updateTicketAnswer,sendConfirmTicket);
    }

    @Nested
    class updateTicketShould{


        /*@Test
        void call_updateTicketAnswer() throws InvalidAnswerException {

            List<Ticket> tickets = new ArrayList<Ticket>();
            for(int x = 0 ; x < 5 ; x++){
                tickets.add(new Ticket(x,1,1,"1","UNDEFINED"));
            }

            ticketController.

            List<Ticket> ticketsUpdate = new ArrayList<Ticket>();
            for(int x = 0 ; x < 5 ; x++){
                ticketsUpdate.add(new Ticket(x,1,1,"1","KEEP"));
            }

            ticketController.updateTicketChoice(ticketsUpdate);


        }*/


    }


}
