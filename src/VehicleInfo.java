public class VehicleInfo {
    public int VIN;
    public double odometer;
    public double consumption;
    public double oilChange;
    public double engineSize;

    public VehicleInfo() {
        this.VIN = VIN;
        this.odometer = odometer;
        this.consumption = consumption;
        this.oilChange = oilChange;
        this.engineSize = engineSize;
    }

//    getters for variables
    public int getVIN() {
        return VIN;
    }

    public double getOdometer() {
        return odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getOilChange() {
        return oilChange;
    }

    public double getEngineSize() {
        return engineSize;
    }

//    setters for variables
    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setOilChange(double oilChange) {
        this.oilChange = oilChange;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
