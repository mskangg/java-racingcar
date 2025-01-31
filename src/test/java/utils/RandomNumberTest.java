package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    @DisplayName("0-9까지 숫자 랜덤 생성")
    void generate_random_number_0_to_9() {
        //given
        //when
        int number1 = RandomNumber.generateNumber(0, 9);
        int number2 = RandomNumber.generateNumber(0, 9);

        //then
        assertThat(number1).isBetween(0, 9);
        assertThat(number2).isBetween(0, 9);
    }
}
