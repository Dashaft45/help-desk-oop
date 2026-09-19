package helpdesk;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        NotificationService notificationService = new ConsoleNotificationService();
        TicketService ticketService = new TicketService(notificationService);

        Ticket ticket = new Ticket(
            1,
            "Не работает интернет",
            "После перезагрузки компьютера пропало подключение"
        );

        System.out.println("Заявка #" + ticket.getId() + ": " + ticket.getTitle() + " | " + ticket.getStatus());

        ticketService.startTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());

        ticketService.resolveTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());

        ticketService.closeTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());

        System.out.println("\n=== Репозиторий заявок ===");

        TicketRepository repository = new TicketRepository();

        Ticket t1 = new Ticket(1, "Не работает интернет", "После перезагрузки пропало подключение");
        Ticket t2 = new Ticket(2, "Ошикбка приложения", "прогрмма пропадает при запуске");
        Ticket t3 = new Ticket(3, "Не печатает принтер", "Принтер не отвечает на закпросы");

        repository.add(t1);
        repository.add(t2);
        repository.add(t3);

        for (Ticket t : repository.findAll()) {
            System.out.println("#" + t.getId() + " " + t.getTitle() + " | " + t.getStatus());
        }

        // System.out.println("\n=== Проверка запретов ===");

        // Ticket brokenTicket = new Ticket(2, "Тестовая заявка", "Проверка недопустимых переходов");

        // brokenTicket.resolve();
        // System.out.println("После попытки resolve y NEW: " + brokenTicket.getStatus());

        // brokenTicket.close();
        // System.out.println("После попытки close y NEW: " + brokenTicket.getStatus());

        // System.out.println("\n=== Проверка наследования ===");

        // Customer customer = new Customer(1, "Анна", "anna@mail.ru");
        // SupportAgent agent = new SupportAgent(2, "Сергей", "sergey@helpdesk.ru");
        // Administrator admin = new Administrator(3, "Олег", "admin@helpdesk.ru");

        // System.out.println("Клиент: " + customer.getName() + " (" + customer.getEmail() + ")");
        // System.out.println("Специалист: " + agent.getName() + " (" + agent.getEmail() + " )");
        // System.out.println("Администратор: "  + admin.getName() + " (" + admin.getEmail() + " )");

        // System.out.println("\n=== Полиморфизм ===");

        // List<User> users = new ArrayList<>();
        // users.add(new Customer(1, "Анна", "anna@mail.ru"));
        // users.add(new SupportAgent(2, "Сергей", "sergey@helpdesk.ru"));
        // users.add(new Administrator(3, "Олег", "admin@helpdesk.ru"));

        // for (User user : users) {
        //     user.performAction();
        // }

    }

}