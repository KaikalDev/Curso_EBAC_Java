package AbstractFactory;

import AbstractFactory.economy.CarEconomy;
import AbstractFactory.economy.MotorcycleEconomy;

public class EconomyVehicleFactory implements VehicleFactory {

    @Override
    public Car createCar(Car car) {
        return new CarEconomy(car);
    }

    @Override
    public Motorcycle createMotorcycle(Motorcycle motorcycle) {
        return new MotorcycleEconomy(motorcycle);
    }
}
