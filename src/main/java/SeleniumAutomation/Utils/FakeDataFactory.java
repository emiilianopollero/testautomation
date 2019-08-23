package SeleniumAutomation.Utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.time.Month;
import java.util.Locale;

public class FakeDataFactory {
    private static Faker faker = new Faker();
    private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("nl-NL"), new RandomService());

    public static String getRandomEmail() {
        return fakeValuesService.bothify("?????####@?????.com");
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomFullName() {
        return faker.name().fullName();
    }

    public static String getRandomUsername() {
        return faker.funnyName().name();
    }

    public static int getRandomNumber() {
        return faker.number().numberBetween(1, 1000000);
    }

    public static String getRandomStringNumber() {
        return String.valueOf(getRandomNumber());
    }

    public static String getRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static Month getRandomMonth() {
        return Month.of(faker.number().numberBetween(1, 12));
    }

    public static String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1920, 2001));
    }
}
