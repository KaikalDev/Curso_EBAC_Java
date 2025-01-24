package AbstractFactory.economy;

import AbstractFactory.Car;

public class CarEconomy extends Car {
    public CarEconomy(Car car) {
        super(car.getRodas(), car.getProtas(), car.getMotor(), car.getFreio(), car.getCambio());
    }
}
