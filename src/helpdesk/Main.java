package helpdesk;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        Ticket ticket = new Ticket(
            1,
            "Не работает интернет",
            "После перезагрузки компьютера пропало подключение"
        );

        System.out.println("Заявка #" + ticket.getId() + ": " + ticket.getTitle() + " | " + ticket.getStatus());

        ticket.startProcessing();
        System.out.println("Статус: " + ticket.getStatus());

        ticket.resolve();
        System.out.println("Статус: " + ticket.getStatus());

        ticket.close();
        System.out.println("Статус: " + ticket.getStatus());

        System.out.println("\n=== Проверка запретов ===");

        Ticket brokenTicket = new Ticket(2, "Тестовая заявка", "Проверка недопустимых переходов");

        brokenTicket.resolve();
        System.out.println("После попытки resolve y NEW: " + brokenTicket.getStatus());

        brokenTicket.close();
        System.out.println("После попытки close y NEW: " + brokenTicket.getStatus());

    }
}