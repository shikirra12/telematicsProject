import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        TelematicsService telematicsService = new TelematicsService();
        VehicleInfo vehicleInfo = new VehicleInfo();
        Scanner scanner = new Scanner(System.in);

//        creates the userinputs and converts them to their variable types
        System.out.println("Enter the VIN number(Must be whole number)");
        String vinInput = scanner.nextLine();
        vehicleInfo.setVIN(Integer.parseInt(vinInput));

        System.out.println("Enter the Odometer number");
        String odometerInput = scanner.nextLine();
        vehicleInfo.setOdometer(Double.parseDouble(odometerInput));

        System.out.println("Enter Gallons of Gas Consumed");
        String consumptionInput = scanner.nextLine();
        vehicleInfo.setConsumption(Double.parseDouble(consumptionInput));

        System.out.println("Enter Odometer Reading for last Oil Change");
        String oilChangeInput = scanner.nextLine();
        vehicleInfo.setOilChange(Double.parseDouble(oilChangeInput));

        System.out.println("Enter Engine size in Liters");
        String engineSizeInput = scanner.nextLine();
        vehicleInfo.setEngineSize(Double.parseDouble(engineSizeInput));

    telematicsService.report(vehicleInfo);
    }
}
