package infrastructure.Controller;

import domain.models.InvalidAnswerException;
import domain.models.Ticket;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.mockito.Mock;
import use_case.Service_client.DeleteUserChoice;
import use_case.Service_client.GetUserChoice;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerTest {

    @Mock
    private DeleteUserChoice deleteUserChoice;

    @Mock
    private GetUserChoice getUserChoice;

    private UserController userController;

    @BeforeEach
    void setUp() {
        userController = new UserController(deleteUserChoice,getUserChoice);
    }

    @Nested
    class DeleteUserShould{

        @Test
        void call_deleteUserChoice() throws InvalidAnswerException{

            List<Ticket> tickets = new ArrayList<Ticket>();

            for(int x = 0 ; x < 5 ; x++){
                tickets.add(new Ticket(x,1,1,"1","KEEP"));
            }

            userController.deleteAllUserChoice();

            for(Ticket ticket : tickets){
                assertThat(ticket.getAnswer()).isEqualTo("UNDEFINED");
            }

        }
    }

}
