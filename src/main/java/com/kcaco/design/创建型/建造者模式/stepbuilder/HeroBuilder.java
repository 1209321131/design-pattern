package com.kcaco.design.创建型.建造者模式.stepbuilder;



import java.util.ArrayList;
import java.util.List;

/**
 * Description: 电脑构造器
 *
 * @author kcaco
 * @since 2023-05-03 15:30
 */
public class HeroBuilder {

    private HeroBuilder() {
    }

    public static NameStep builder() {
        return new HeroSteps();
    }

    /**
     * 第1步是起名称，下一步是ClassStep
     */
    public interface NameStep {
        ClassStep name(String name);
    }

    /**
     * 此步骤负责设置角色类别(战士或巫师)。战士选择：下一步可用：WeaponStep  战士选择：下一步可用：SpellStep
     */
    public interface ClassStep {
        WeaponStep fighterClass(String fighterClass);

        SpellStep wizardClass(String wizardClass);
    }

    /**
     * 这一步是武器的掌控者。武器选择：下一步可用：能力步骤无武器选择：下一步可用：建立步骤
     */
    public interface WeaponStep {
        AbilityStep withWeapon(String weapon);

        BuildStep noWeapon();
    }

    /**
     * 这一步是咒语的掌控者。拼写选择：下一步可用：能力步骤无拼写选择：下一步可用：BuildStep
     */
    public interface SpellStep {
        AbilityStep withSpell(String spell);

        BuildStep noSpell();
    }

    /**
     * 这一步是负责能力的。下一步可用： BuildStep
     */
    public interface AbilityStep {
        AbilityStep withAbility(String ability);

        BuildStep noMoreAbilities();

        BuildStep noAbilities();
    }

    /**
     * 这是负责构建角色对象的最后一步。验证应该在这里。
     */
    public interface BuildStep {
        Hero build();
    }

    /**
     * 具体builder实现
     */
    private static class HeroSteps implements NameStep, ClassStep, WeaponStep, SpellStep, AbilityStep, BuildStep {
        private String name;
        private String fighterClass;
        private String wizardClass;
        private String weapon;
        private String spell;
        private final List<String> abilities = new ArrayList<>();

        @Override
        public ClassStep name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public WeaponStep fighterClass(String fighterClass) {
            this.fighterClass = fighterClass;
            return this;
        }

        @Override
        public SpellStep wizardClass(String wizardClass) {
            this.wizardClass = wizardClass;
            return this;
        }

        @Override
        public AbilityStep withWeapon(String weapon) {
            this.weapon = weapon;
            return this;
        }

        @Override
        public BuildStep noWeapon() {
            return this;
        }

        @Override
        public AbilityStep withSpell(String spell) {
            this.spell = spell;
            return this;
        }

        @Override
        public BuildStep noSpell() {
            return this;
        }

        @Override
        public AbilityStep withAbility(String ability) {
            this.abilities.add(ability);
            return this;
        }

        @Override
        public BuildStep noMoreAbilities() {
            return this;
        }

        @Override
        public BuildStep noAbilities() {
            return this;
        }

        @Override
        public Hero build() {
            Hero hero = new Hero();
            hero.setName(name);

            if (fighterClass != null) {
                hero.setFighterClass(fighterClass);
            } else {
                hero.setWizardClass(wizardClass);
            }

            if (weapon != null) {
                hero.setWeapon(weapon);
            } else {
                hero.setSpell(spell);
            }

            if (!abilities.isEmpty()) {
                hero.setAbilities(abilities);
            }

            return hero;
        }
    }

}
