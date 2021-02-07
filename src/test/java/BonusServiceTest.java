import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldcalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateRegisteredAndOverLimit() {
         BonusService service = new BonusService();

         // подготавливаем данные:
         long amount = 100_000_60;
         boolean registered = true;
         long expected = 450;

         // вызываем целевой метод:
         long actual = service.calculate(amount, registered);

         assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 90_000_60;
        boolean registered = false;
        long expected = 393;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = false;
        long expected = 20;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateRegisteredAndBoundaryLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1300;
        boolean registered = true;
        long expected = 0;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}