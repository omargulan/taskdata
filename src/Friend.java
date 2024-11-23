import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Friend {
    private String name;
    private LocalDate birthDate;

    public Friend(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    // Метод для вычисления количества дней до дня рождения друга
    public long daysUntilBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthDate.withYear(today.getYear());

        // Если день рождения уже прошел в этом году, то вычисляем на следующий год
        if (today.isAfter(nextBirthday)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        return ChronoUnit.DAYS.between(today, nextBirthday);
    }

    public String toString() {
        return name + " - " + birthDate.getDayOfMonth() + " " + birthDate.getMonth() + " " + birthDate.getYear();
    }
}