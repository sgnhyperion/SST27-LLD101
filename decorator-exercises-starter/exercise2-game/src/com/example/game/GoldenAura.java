package com.example.game;

/**
 * GoldenAura decorator: changes sprite, adds buffs, logs aura.
 */
public class GoldenAura extends CharacterDecorator {
    private String auraSprite = "golden_aura.png";
    private int speedBuff = 2;
    private int damageBuff = 5;

    public GoldenAura(Character inner) {
        super(inner);
    }

    @Override
    public int getSpeed() {
        return inner.getSpeed() + speedBuff;
    }

    @Override
    public int getDamage() {
        return inner.getDamage() + damageBuff;
    }

    @Override
    public String getSprite() {
        return auraSprite;
    }

    @Override
    public void move() {
        System.out.println("[GoldenAura] Aura shines! Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[GoldenAura] Aura shines! Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }
}
