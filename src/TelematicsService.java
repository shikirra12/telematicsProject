import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TelematicsService {

    public void report(VehicleInfo vehicleInfo) {
        createCar(vehicleInfo);
        createContent(vehicleInfo);
    }

    public void createCar(VehicleInfo vehicleInfo) {
        try {
            System.out.println(vehicleInfo);
            String fileName = vehicleInfo.getVIN() + ".json";
            File newFile = new File(fileName);
            FileWriter fileWriter = new FileWriter(newFile);
            System.out.println(fileName);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);

            fileWriter.write(json);
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }


//    fix the values in the HTML
    public void createContent(VehicleInfo vehicleInfo) {

        try {
           VehicleInfo vehicleStats = new VehicleInfo();
            String htmlFile = "";
            int amountOfCars = 0;

            ObjectMapper mapper = new ObjectMapper();
            File file = new File(".");
            for (File f : file.listFiles()) {
                if (f.getName().endsWith(".json")) {
                    amountOfCars++;
                    VehicleInfo vi = mapper.readValue(f, VehicleInfo.class);

                    vehicleStats.setOdometer((vehicleStats.getOdometer() + vehicleInfo.getOdometer()) / amountOfCars);
                    vehicleStats.setConsumption((vehicleStats.getConsumption() + vehicleInfo.getConsumption() / amountOfCars));
                    vehicleStats.setOilChange((vehicleStats.getOilChange() + vehicleInfo.getOilChange() / amountOfCars));
                    vehicleStats.setEngineSize((vehicleStats.getEngineSize() + vehicleInfo.getEngineSize() / amountOfCars));

                    htmlFile += "<h1 align=\"center\">History</h1>\n" +
                            "    <table align=\"center\" border=\"1\">\n" +
                            "        <tr>\n" +
                            "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "            <td align=\"center\">" + vehicleInfo.getVIN() + "</td><td align=\"center\">"+ vehicleInfo.getOdometer() +"</td><td align=\"center\">"+ vehicleInfo.getConsumption() +"</td><td align=\"center\">"+ vehicleInfo.getOilChange() +"</td align=\"center\"><td align=\"center\">"+ vehicleInfo.getEngineSize() +"</td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "            <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
                            "        </tr>\n";

                    // Now you have a File object named "f".
                    // You can use this to create a new instance of Scanner
                }
            }

            File dashboard = new File("dashboard.html");
            FileWriter dashboardInfo = new FileWriter(dashboard);
            String content = "<html>\n" +
                    "  <title>Vehicle Telematics Dashboard</title>\n" +
                    "  <body>\n" +
                    "    <h1 align=\"center\">Averages for "+ amountOfCars +" vehicles</h1>\n" +
                    "    <table align=\"center\">\n" +
                    "        <tr>\n" +
                    "            <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">"+ Math.round(vehicleStats.getOdometer()) +"</td><td align=\"center\">"+ Math.round(vehicleStats.getConsumption()) +"</td><td align=\"center\">"+ Math.round(vehicleStats.getOilChange()) +"</td align=\"center\"><td align=\"center\">"+ Math.round(vehicleStats.getEngineSize()) +"</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "    <h1 align=\"center\">History</h1>\n" +
                    "    <table align=\"center\" border=\"1\">\n" +
                    "        <tr>\n" +
                    "            <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">"+ vehicleInfo.getVIN() +"</td><td align=\"center\">"+ vehicleInfo.getOdometer() +"</td><td align=\"center\">"+ vehicleInfo.getConsumption() +"</td><td align=\"center\">"+ vehicleInfo.getOilChange() +"</td align=\"center\"><td align=\"center\">"+ vehicleInfo.getEngineSize() +"</td>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td align=\"center\">45435</td><td align=\"center\">123</td><td align=\"center\">234</td><td align=\"center\">345</td align=\"center\"><td align=\"center\">4.5</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "  </body>\n" +
                    "</html>\n";

            dashboardInfo.write(content);
            dashboardInfo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

