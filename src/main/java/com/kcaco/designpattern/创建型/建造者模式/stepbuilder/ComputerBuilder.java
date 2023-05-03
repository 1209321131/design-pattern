package com.kcaco.designpattern.创建型.建造者模式.stepbuilder;


/**
 * Description: 电脑构造器
 *
 * @author kcaco
 * @since 2023-05-03 15:30
 */
public class ComputerBuilder {

    public ComputerBuilder() {
    }

    public static CpuStep getBuilder() {
        return new ComputerSteps();
    }

    interface CpuStep {
        MemoryStp withCpu(String cpu);
    }

    interface MemoryStp {
        ScreenStep withMemory(String memory);
    }

    interface ScreenStep {
        BuildStep withScreen(String screen);
    }

    interface BuildStep {
        Computer build();
    }

    private static class ComputerSteps implements CpuStep, MemoryStp, ScreenStep, BuildStep {
        private Computer computer;

        public ComputerSteps() {
            this.computer = new Computer();
        }

        @Override
        public MemoryStp withCpu(String cpu) {
            computer.setCpu(cpu);
            return this;
        }

        @Override
        public ScreenStep withMemory(String memory) {
            computer.setMemory(memory);
            return this;
        }

        @Override
        public BuildStep withScreen(String screen) {
            computer.setScreen(screen);
            return this;
        }

        @Override
        public Computer build() {
            return this.computer;
        }
    }


}
