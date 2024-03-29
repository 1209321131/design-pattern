package com.kcaco.design.创建型.建造者模式.stepbuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * Description:
 *
 * @author kcaco
 * @since 2023-05-03 15:35
 */
@Slf4j
public class StepBuilderTest {

    public static void main(String[] args) {
        Hero warrior = HeroBuilder
                .builder()
                .name("Amberjill")
                .fighterClass("Paladin")
                .withWeapon("Sword")
                .noAbilities()
                .build();

        log.info(warrior.toString());

        Hero mage = HeroBuilder
                .builder()
                .name("Riobard")
                .wizardClass("Sorcerer")
                .withSpell("Fireball")
                .withAbility("Fire Aura")
                .withAbility("Teleport")
                .noMoreAbilities()
                .build();

        log.info(mage.toString());

        Hero thief = HeroBuilder
                .builder()
                .name("Desmond")
                .fighterClass("Rogue")
                .noWeapon()
                .build();

        log.info(thief.toString());
    }

}
