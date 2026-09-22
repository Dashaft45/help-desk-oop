package helpdesk;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");


        NotificationService notificationService = new ConsoleNotificationService();
        TicketService ticketService = new TicketService(notificationService);
        TicketRepository repository = new TicketRepository();


        Customer customer = new Customer(1, "Анна Петрова", "anna@mail.ru");
        SupportAgent agent = new SupportAgent(2, "Сергей Иванов", "sergey@helpdesk.ru");
        // Administrator admin = new Administrator(3, "Олег Сидоров", "admin@helpdesk.ru");

        System.out.println("Клиент: " + customer.getName());
        System.out.println("Специалист: " + agent.getName());
        // System.out.println("Администратор: "  + admin.getName() + " (" + admin.getEmail() + " )");


        Ticket ticket = new Ticket(
            1,
            "Не работает Wi-Fi",
            "После обновления роутера пропало подключение к беспроводной сети",
            TicketPriority.HIGH
        );

        System.out.println(ticket);

        ticketService.startTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());

        ticketService.resolveTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());

        ticketService.closeTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());

        // System.out.println("\n=== Репозиторий заявок ===");

        // TicketRepository repository = new TicketRepository();

        // Ticket t1 = new Ticket(1, "Не работает интернет", "После перезагрузки пропало подключение");
        // Ticket t2 = new Ticket(2, "Ошикбка приложения", "прогрмма пропадает при запуске");
        // Ticket t3 = new Ticket(3, "Не печатает принтер", "Принтер не отвечает на закпросы");

        repository.add(ticket);
        repository.add(new Ticket(2, "Ошикбка приложения", "прогрмма пропадает при запуске", TicketPriority.CRITICAL));
        repository.add(new Ticket(3, "Не печатает принтер", "Принтер не отвечает на закпросы", TicketPriority.MEDIUM));

        // for (Ticket t : repository.findAll()) {
        //     System.out.println("#" + t.getId() + " " + t.getTitle() + " | " + t.getStatus());
        // }
        System.out.println("\n=== Все заявки ===");


        for (Ticket t : repository.findAll()) {
            System.out.println(t);
        }

        // System.out.println("\n=== Проверка запретов ===");

        // Ticket brokenTicket = new Ticket(2, "Тестовая заявка", "Проверка недопустимых переходов");

        // brokenTicket.resolve();
        // System.out.println("После попытки resolve y NEW: " + brokenTicket.getStatus());

        // brokenTicket.close();
        // System.out.println("После попытки close y NEW: " + brokenTicket.getStatus());

        // System.out.println("\n=== Проверка наследования ===");

        // Customer customer = new Customer(1, "Анна Петрова", "anna@mail.ru");
        // SupportAgent agent = new SupportAgent(2, "Сергей Иванов", "sergey@helpdesk.ru");
        // // Administrator admin = new Administrator(3, "Олег Сидоров", "admin@helpdesk.ru");

        // System.out.println("Клиент: " + customer.getName());
        // System.out.println("Специалист: " + agent.getName());
        // // System.out.println("Администратор: "  + admin.getName() + " (" + admin.getEmail() + " )");

        System.out.println("\n=== Полиморфизм ===");

        List<User> users = new ArrayList<>();
        users.add(customer);
        users.add(agent);
        users.add(new Administrator(3, "Олег Смирнов", "admin@helpdesk.ru"));

        for (User user : users) {
            user.performAction();
        }

        // System.out.println("\n=== Все заявки ===");

        // for (Ticket t : repository.findAll()) {
        //     System.out.println("#" + t.getId() + " " + t.getTitle() + " | " + t.getStatus());
        // }

        // System.out.println("\n=== Проверка валидации ===");

        // try {
        //     Ticket invalidTicket = new Ticket(99, "  ", "Пустое название", TicketPriority.LOW);
        //     System.out.println("Этого не должно было случиться!");
        // } catch (IllegalArgumentException e) {
        //     System.out.println("Поймали ошибку: " + e.getMessage());
        // }

        System.out.println("\n=== Проверка отмены ===");

        Ticket cancelable = new Ticket(10, "Отменяемая заявка", "Проверка cancel()", TicketPriority.LOW);
        System.out.println("До отмены: " + cancelable);
        cancelable.cancel();
        System.out.println("После отмены " + cancelable);

        cancelable.cancel();

        Ticket closedTicket = new Ticket(11, "Закрытая заявка", "Проверка cancel() на CLOSED", TicketPriority.LOW);
        closedTicket.startProcessing();
        closedTicket.resolve();
        closedTicket.close();
        closedTicket.cancel();
        System.out.println("После попытки отмены закрытой: " + closedTicket);

    }

}