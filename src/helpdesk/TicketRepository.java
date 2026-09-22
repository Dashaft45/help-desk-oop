package helpdesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>();

    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }

    public Optional<Ticket> findById(long id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return Optional.of(ticket);
            }
        }
        return Optional.empty();

    }

    public List<Ticket> findByStatus(TicketStatus status) {
        List<Ticket> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getStatus() == status) {
                result.add(ticket);
            }
        }
        return result;
    }

}