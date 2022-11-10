package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable{
    public String plateNB;
    int modelYear;
    String manufacturer;
    int estimatedValue;
    int carDamage;

    public Vehicle(String plateNB,int modelYear, String manufacturer, int estimatedValue, int carDamage){
        this.plateNB = plateNB;
        this.modelYear = modelYear;
        this.manufacturer = manufacturer;
        this.estimatedValue = estimatedValue;
        this.carDamage = carDamage;
    }

    public String getPlateNB() {
        return plateNB;
    }

    public void setPlateNB(String plateNB) {
        this.plateNB = plateNB;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(int estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public int getCarDamage() {
        return carDamage;
    }

    public void setCarDamage(int carDamage) {
        this.carDamage = carDamage;
    }

    @Override
    public String toString() {
        return "Plate Number: " + plateNB +
                "\nModel Year: " + modelYear +
                "\nManufacturer: " + manufacturer +
                "\nEstimated Value: " + estimatedValue +
                "\nCar Damage Level:" + carDamage;
    }
}
