package helpdesk;

public class Ticket {
    private long id;
    private String title;
    private String description;
    private TicketStatus status;

    public Ticket(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TicketStatus.NEW;
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description;}
    public TicketStatus getStatus() { return status; }

    public void startProcessing() {
        if (!status.equals(TicketStatus.NEW)) {
            System.out.println("Ошибка: в работу можно взять только новую заявку (текущий статус: " + status + ")");
            return;
        }
        status = TicketStatus.IN_PROGRES;
    }

    public void resolve() {
        if (!status.equals(TicketStatus.IN_PROGRESS)) {
            System.out.println("Ошибка: решить можно только заявку, которая в работе (текущий статус: " + status + ")");
            return;
        }
        status = TicketStatus.RESOLVED;
    }

    public void close() {
        if (!status.equals(TicketStatus.RESOLVED)) {
            System.out.println("Ошибка: закрыть можно только решённую заявку (текущий статус: " + status + ")");
            return;
        }
        status = TicketStatus.CLOSED;
    }

}