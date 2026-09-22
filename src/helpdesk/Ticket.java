package helpdesk;

import java.time.LocalDateTime;

public class Ticket {
    private long id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;
    private LocalDateTime createdAt;

    public Ticket(long id, String title, String description, TicketPriority priority) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название заявки не может быть пустым");
        }
        this.id = id;
        this.title = title.trim();
        this.description = description;
        this.priority = priority;
        this.status = TicketStatus.NEW;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description;}
    public TicketStatus getStatus() { return status; }
    public TicketPriority getPriority() { return priority; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void startProcessing() {
        if (!status.equals(TicketStatus.NEW)) {
            System.out.println("Ошибка: в работу можно взять только новую заявку (текущий статус: " + status + ")");
            return;
        }
        status = TicketStatus.IN_PROGRESS;
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

    @Override
    public String toString() {
        return "#" + id + " " + title + " | Приоритет: " + priority + " | Статус: " + status + " | Создана: " + createdAt;
    }

}