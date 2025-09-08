package com.example.game;

/**
 * Adds a damage boost to a character.
 */
public class DamageBoost extends CharacterDecorator {
    private int boost;

    public DamageBoost(Character inner, int boost) {
        super(inner);
        this.boost = boost;
    }

    @Override
    public int getDamage() {
        return inner.getDamage() + boost;
    }

    @Override
    public void attack() {
        System.out.println("[DamageBoost] Attacking with boosted damage " + getDamage() + " using sprite " + getSprite());
    }
}
