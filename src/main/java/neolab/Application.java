package neolab;

import neolab.handler.Rules;
import neolab.handler.handlerAnimal.AnimalHandler;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        try {
            Rules rules = new Rules("src/main/resources/rules.properties");
            AnimalHandler animalHandler = new AnimalHandler(rules);
            System.out.println("Кол - во животных с заданными параметрами: -> " + animalHandler.toCountAnimals());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
