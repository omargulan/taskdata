import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    private static ArrayList<Friend> friends = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Добавить друга");
            System.out.println("2. Узнать сколько дней осталось до дня рождения друга");
            System.out.println("3. Вывести всех друзей");
            System.out.println("0. Завершить");
            System.out.print("Выберите действие: ");
            int action = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (action) {
                case 1:
                    addFriend();
                    break;
                case 2:
                    checkDaysUntilBirthday();
                    break;
                case 3:
                    printAllFriends();
                    break;
                case 0:
                    System.out.println("Завершение работы программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static void addFriend() {
        System.out.print("Введите имя друга: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату (год месяц день): ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        LocalDate birthDate = LocalDate.of(year, month, day);
        friends.add(new Friend(name, birthDate));
    }

    private static void checkDaysUntilBirthday() {
        System.out.print("Введите имя друга: ");
        String name = scanner.nextLine();

        Friend friend = findFriendByName(name);
        if (friend != null) {
            long daysRemaining = friend.daysUntilBirthday();
            int age = LocalDate.now().getYear() - friend.getBirthDate().getYear();
            System.out.println("Осталось дней: " + daysRemaining + ", исполнится: " + age);
        } else {
            System.out.println("Друг с таким именем не найден.");
        }
    }

    private static void printAllFriends() {
        if (friends.isEmpty()) {
            System.out.println("Нет друзей для отображения.");
        } else {
            for (Friend friend : friends) {
                System.out.println(friend);
            }
        }
    }

    private static Friend findFriendByName(String name) {
        for (Friend friend : friends) {
            if (friend.getName().equalsIgnoreCase(name)) {
                return friend;
            }
        }
        return null;
    }
}
