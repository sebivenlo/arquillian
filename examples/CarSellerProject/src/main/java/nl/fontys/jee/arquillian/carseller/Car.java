/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.jee.arquillian.carseller;

import java.awt.Color;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author techlogic
 */
@Entity
public class Car implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Color color;
    
    @ManyToOne(optional=false)
    private CarBrand brand;
    
    private String name;
    
    public Car(String color, CarBrand brand, String name) {
        this.color = Color.decode("#"+color);
        this.brand = brand;
        this.name = name;
    }
    
    public Car() {
        this.brand = new CarBrand();
        this.color = Color.BLACK;
        this.name = "";
    }
    
    public String getName() {
        return name;
    }
    
    public CarBrand getBrand() {
        return brand;
    }
    
    public String getColor() {
        return color.toString();
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }
    
    public void setColor(String color) {
        this.color = Color.decode("#"+color);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "nl.fontys.jee.arquillian.carseller.Car[ id=" + id + " ]";
    }
    
}
