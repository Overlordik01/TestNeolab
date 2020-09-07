package neolab.handler.handlerAnimal;

import neolab.handler.Rules;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class AnimalHandlerTest {

    @Test
    public void toCountAnimalsExampleFirst() throws IOException {
        Rules rules = new Rules("src/test/java/TestResources/rulesTestExample1.properties");
        AnimalHandler animalHandler = new AnimalHandler(rules);

        int result = animalHandler.toCountAnimals();

        Assert.assertEquals(result,4);
    }

    @Test
    public void toCountAnimalsExampleSecond() throws IOException {
        Rules rules = new Rules("src/test/java/TestResources/rulesTestExample2.properties");
        AnimalHandler animalHandler = new AnimalHandler(rules);

        int result = animalHandler.toCountAnimals();

        Assert.assertEquals(result,4);
    }

    @Test
    public void toCountAnimalsExampleThird() throws IOException {
        Rules rules = new Rules("src/test/java/TestResources/rulesTestExample3.properties");
        AnimalHandler animalHandler = new AnimalHandler(rules);

        int result = animalHandler.toCountAnimals();

        Assert.assertEquals(result,2);
    }
}