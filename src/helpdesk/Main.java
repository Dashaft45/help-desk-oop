package helpdesk;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        Ticket ticket = new Ticket(
            1,
            "Не работает интернет",
            "После перезагрузки компьютера пропало подключение"
        );

        System.out.println("Заявка #" + ticket.id + ": " + ticket.title + " | " + ticket.status);

        ticket.status = "БАНАН";
        System.out.println("Новый статус: " + ticket.status);
    }
}