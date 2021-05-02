package domain.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("차 2개 경주 잘 되는지")
    void two_car_play() {
        // given
        Cars cars = new Cars(Arrays.asList(new Car("santa"), new Car("tesla")));

        // when
        cars.playAll();

        // then
        assertThat(outContent.toString()).isIn(
                "santa: \n" +
                        "tesla: \n",
                "santa: -\n" +
                        "tesla: \n",
                "santa: \n" +
                        "tesla: -\n",
                "santa: -\n" +
                        "tesla: -\n"
        );
    }

    @Test
    @DisplayName("승리한 volt 이름 출력")
    void print_winner() {
        //given
        Car santa = new Car("santa");
        Car tesla = new Car("tesla");
        Car volt = new Car("volt");
        try {
            Field santaGoCount = santa.getClass().getDeclaredField("goCount");
            santaGoCount.setAccessible(true);
            santaGoCount.setInt(santa, 9);
            Field teslaGoCount = tesla.getClass().getDeclaredField("goCount");
            teslaGoCount.setAccessible(true);
            teslaGoCount.setInt(tesla, 13);
            Field voltGoCount = volt.getClass().getDeclaredField("goCount");
            voltGoCount.setAccessible(true);
            voltGoCount.setInt(volt, 14);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Cars cars = new Cars(Arrays.asList(santa, tesla, volt));

        //when
        cars.printWinner();

        //then
        assertThat(outContent.toString()).isEqualTo("volt 승리하였습니다.\n");
    }

    @Test
    @DisplayName("공동 승리한 santa, volt 이름 출력")
    void print_co_winner() {
        //given
        Car santa = new Car("santa");
        Car tesla = new Car("tesla");
        Car volt = new Car("volt");
        try {
            Field santaGoCount = santa.getClass().getDeclaredField("goCount");
            santaGoCount.setAccessible(true);
            santaGoCount.setInt(santa, 14);
            Field teslaGoCount = tesla.getClass().getDeclaredField("goCount");
            teslaGoCount.setAccessible(true);
            teslaGoCount.setInt(tesla, 13);
            Field voltGoCount = volt.getClass().getDeclaredField("goCount");
            voltGoCount.setAccessible(true);
            voltGoCount.setInt(volt, 14);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Cars cars = new Cars(Arrays.asList(santa, tesla, volt));

        //when
        cars.printWinner();

        //then
        assertThat(outContent.toString()).isEqualTo("santa volt 승리하였습니다.\n");
    }

}
