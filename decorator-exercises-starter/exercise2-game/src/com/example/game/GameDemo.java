package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();


    Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
    System.out.println("--- Buffed (Speed+3, Damage+15) ---");
    buffed.move();
    buffed.attack();


    Character shiny = new GoldenAura(buffed);
    System.out.println("--- Shiny (GoldenAura) ---");
    shiny.move();
    shiny.attack();

    Character withoutAura = buffed; 
    System.out.println("--- Without Aura (Buffed only) ---");
    withoutAura.move();
    withoutAura.attack();
    }
}
