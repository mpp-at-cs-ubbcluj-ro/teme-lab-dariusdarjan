package ro.mpp2025;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainBD {
    public static void main(String[] args) {
        Properties props=new Properties();
        try {
            props.load(new FileReader("bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }

        CarRepository carRepo=new CarsDBRepository(props);
        carRepo.add(new Car("Tesla","Model S", 2019));
        System.out.println("Toate masinile din db");
        for(Car car:carRepo.findAll())
            System.out.println(car);
       String manufacturer="Tesla";
        System.out.println("Masinile produse de "+manufacturer);
        for(Car car:carRepo.findByManufacturer(manufacturer))
            System.out.println(car);
        carRepo.update(4,new Car("Tesla","Roadster", 2026));
        carRepo.add(new Car("Tesla","Model 3", 2020));
        carRepo.add(new Car("Tesla","Model X", 2021));
        carRepo.add(new Car("Tesla","Model Y", 2022));
        System.out.println("Toate masinile din anul 2019 pana in 2022");
        for(Car car:carRepo.findBetweenYears(2019,2022))
            System.out.println(car);
    }
}
