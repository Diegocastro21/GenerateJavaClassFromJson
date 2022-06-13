package org.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<Demo> ref = new TypeReference<Demo>() {};
            // Se pone la ruta correcta del arhivo json para que pueda funcionar
            InputStream in = new FileInputStream("Json/src/main/resources/schema/demo.json");
            Demo demo = mapper.readValue(in, ref);
            System.out.println("Nombre Persona: "+demo.getPerson().getName());
            List<Car> cars = demo.getPerson().getCars().getCar();
            for (Car c : cars) {
                System.out.println("Marca de carro: "+c.getBrand());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
