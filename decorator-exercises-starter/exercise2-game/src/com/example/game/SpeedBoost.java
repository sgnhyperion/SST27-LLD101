package com.example.game;

/**
 * Adds a speed boost to a character.
 */
public class SpeedBoost extends CharacterDecorator {
    private int boost;

    public SpeedBoost(Character inner, int boost) {
        super(inner);
        this.boost = boost;
    }

    @Override
    public int getSpeed() {
        return inner.getSpeed() + boost;
    }

    @Override
    public void move() {
        System.out.println("[SpeedBoost] Moving at boosted speed " + getSpeed() + " with sprite " + getSprite());
    }
}
