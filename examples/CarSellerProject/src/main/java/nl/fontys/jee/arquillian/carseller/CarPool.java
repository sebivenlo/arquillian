/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.jee.arquillian.carseller;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author techlogic
 */
public class CarPool {

    private List<Car> availableCars;

    public CarPool() {
        availableCars = new ArrayList<>();
    }
        
    /**
     * Check if a car of the specified brand , type and color is available.
     * @param car The car that should be search for
     * @return true if a car with this spacification is available and false if not.
     */
    public boolean checkIfCarIsAvailable(Car car){
           throw  new UnsupportedOperationException();
    }
    
    public void addCar(Car car){
        availableCars.add(car);
    }
        
    public void remove(Car car){
        availableCars.remove(car);
    }
    
    
    
    

}
