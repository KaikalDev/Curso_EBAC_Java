package AbstractFactory;

public interface VehicleFactory {
    Car createCar(Car car);

    Motorcycle createMotorcycle(Motorcycle motorcycle);
}
