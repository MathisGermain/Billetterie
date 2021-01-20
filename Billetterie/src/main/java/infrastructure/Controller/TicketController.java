package infrastructure.Controller;

import domain.models.InvalidAnswerException;
import domain.models.TicketNotFoundException;
import domain.models.UserNotFoundException;
import use_case.Client.SendConfirmTicket;
import use_case.Client.UpdateTicketAnswer;

public class TicketController {


    private final UpdateTicketAnswer updateTicketAnswer;
    private final SendConfirmTicket sendConfirmTicket;

    public TicketController(UpdateTicketAnswer updateTicketAnswer, SendConfirmTicket sendConfirmTicket) {
        this.updateTicketAnswer = updateTicketAnswer;
        this.sendConfirmTicket = sendConfirmTicket;
    }

    public void updateTicketChoice(String answer,int ticketId){
        try{
            updateTicketAnswer.update(answer,ticketId);
            sendConfirmTicket.sendEmail(ticketId);
        }catch(InvalidAnswerException e){
            //LOGGER.LOG(e)
        }catch (TicketNotFoundException e){
            //LOGGER.LOG(e)
        }catch(UserNotFoundException e){
            //LOGGER.LOG(e)
        }
    }
}
