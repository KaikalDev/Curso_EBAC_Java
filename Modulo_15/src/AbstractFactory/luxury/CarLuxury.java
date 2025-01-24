package AbstractFactory.luxury;

import AbstractFactory.Car;

public class CarLuxury extends Car{
    public CarLuxury(Car car) {
        super(car.getRodas(), car.getProtas(), car.getMotor(), car.getFreio(), car.getCambio());
    }
}
