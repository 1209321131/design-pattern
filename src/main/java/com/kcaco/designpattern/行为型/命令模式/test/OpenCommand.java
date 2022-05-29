package com.kcaco.designpattern.行为型.命令模式.test;

import com.kcaco.designpattern.行为型.命令模式.Command;

public class OpenCommand extends Command {
    
    public OpenCommand(AirConditioner airConditioner) {
        super(airConditioner);
    }
    
}