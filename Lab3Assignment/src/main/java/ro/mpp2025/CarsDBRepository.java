package ro.mpp2025;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class CarsDBRepository implements CarRepository{

    private JdbcUtils dbUtils;

    private static final Logger logger= LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ",props);
        dbUtils=new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
        logger.traceEntry("find by manufacturer task {}", manufacturerN);
        Connection con = dbUtils.getConnection();
        List<Car> cars= Lists.newArrayList();
        try(PreparedStatement preSmt=con.prepareStatement("select * from cars where manufacturer=?")){
            preSmt.setString(1,manufacturerN);
            try(ResultSet result=preSmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        }catch (SQLException ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();
        return cars;
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
        logger.traceEntry("find between years task {}", min, max);
        Connection con = dbUtils.getConnection();
        List<Car> cars= Lists.newArrayList();
        try(PreparedStatement preSmt=con.prepareStatement("select * from cars where year between ? and ?")){
            preSmt.setInt(1,min);
            preSmt.setInt(2,max);
            try(ResultSet result=preSmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        }catch (SQLException ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();
        return cars;
    }

    @Override
    public void add(Car elem) {
        logger.traceEntry("saving task {}", elem);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preSmt=con.prepareStatement("insert into cars(manufacturer,model,year) values (?,?,?)")){
            preSmt.setString(1,elem.getManufacturer());
            preSmt.setString(2,elem.getModel());
            preSmt.setInt(3,elem.getYear());
            int result=preSmt.executeUpdate();
            logger.trace("Saved {} instances",result);
        }catch (SQLException ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();
    }

    @Override
    public void update(Integer integer, Car elem) {
        logger.traceEntry("updating task {}", elem);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preSmt=con.prepareStatement("update cars set manufacturer=?, model=?, year=? where id=?")){
            preSmt.setString(1,elem.getManufacturer());
            preSmt.setString(2,elem.getModel());
            preSmt.setInt(3,elem.getYear());
            preSmt.setInt(4,integer);
            int result=preSmt.executeUpdate();
            logger.trace("Updated {} instances",result);
        }catch (SQLException ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();
    }

    @Override
    public Iterable<Car> findAll() {
        logger.traceEntry();
        Connection con=dbUtils.getConnection();
        List<Car> cars= Lists.newArrayList();

        try(PreparedStatement preSmt=con.prepareStatement("select * from cars")){
            try(ResultSet result=preSmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        }catch (SQLException ex){
            logger.error(ex);
            System.out.println("Error DB "+ex);
        }
        logger.traceExit();
        return cars;
    }
}
