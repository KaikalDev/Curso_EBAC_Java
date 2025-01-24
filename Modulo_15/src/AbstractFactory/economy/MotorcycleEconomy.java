package AbstractFactory.economy;

import AbstractFactory.Motorcycle;

public class MotorcycleEconomy extends Motorcycle {
    public MotorcycleEconomy(Motorcycle motorcycle) {
        super(motorcycle.getRodas(), motorcycle.getMotor(), motorcycle.getFreio());
    }
}
