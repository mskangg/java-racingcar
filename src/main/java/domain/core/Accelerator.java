package domain.core;

import static domain.core.GameOptions.MIN_POWER;

/**
 * 전진 할 수 있는 Power 원시값 포장
 */
public class Accelerator implements MoveStrategy {
    private final int power;

    public Accelerator(int power) {
        this.power = power;
    }

    @Override
    public boolean movable() {
        return power >= MIN_POWER;
    }
}
