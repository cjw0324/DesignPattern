package midterm.factory.mycode;

public abstract class Factory{
    abstract Car production(String option);

    private void prepareToRelease(Car car){
        car.prepare();
        car.engine();
        car.test();
    }

    public Car orderCar(String option){
        Car car = production(option);
        prepareToRelease(car);
        return car;
    }

}
