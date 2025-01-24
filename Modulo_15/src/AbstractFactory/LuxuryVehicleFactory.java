package AbstractFactory;

import AbstractFactory.luxury.CarLuxury;
import AbstractFactory.luxury.MotorcycleLuxury;

public class LuxuryVehicleFactory implements VehicleFactory{

    @Override
    public Car createCar(Car car) {
        return new CarLuxury(car);
    }

    @Override
    public Motorcycle createMotorcycle(Motorcycle motorcycle) {
        return new MotorcycleLuxury(motorcycle);
    }
}
