package AbstractFactory.luxury;

import AbstractFactory.Motorcycle;

public class MotorcycleLuxury extends Motorcycle {
    public MotorcycleLuxury(Motorcycle motorcycle) {
        super(motorcycle.getRodas(), motorcycle.getMotor(), motorcycle.getFreio());
    }
}
