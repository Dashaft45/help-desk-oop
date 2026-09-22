package helpdesk;

import java.util.ArrayList;
import java.util.List;

public class SupportAgent extends User {
    private final List<Ticket> assignedTickets = new ArrayList<>();

    public SupportAgent(long id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void performAction() {
        System.out.println(getName() + " обрабатывает заявку");
    }

    public void assignTicket(Ticket ticket) {
        TicketStatus statusBefore = ticket.getStatus();
        ticket.startProcessing();

        if (ticket.getStatus() == TicketStatus.IN_PROGRESS && statusBefore == TicketStatus.NEW) {
            assignedTickets.add(ticket);
            System.out.println(getName() + " принял заявку #" + ticket.getId() + " в работу");
        }
    }

    public List<Ticket> getAssignedTickets() {
        return new ArrayList<>(assignedTickets);
    }

    public int getAssignedCount() {
        return assignedTickets.size();
    }
}