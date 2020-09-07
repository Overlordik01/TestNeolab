package neolab.handler.handlerAnimal;

import neolab.handler.Rules;
import neolab.handler.workWithData.FileTXT;

import java.io.IOException;

public class AnimalHandler implements IAnimalHandler {

    private Rules rules;

    public AnimalHandler(final Rules rules) throws IOException {
        this.rules = rules;
    }

    public int toCountAnimals(){
        int count = 0;
        FileTXT fileTXT = new FileTXT();
        boolean isResult = false;
        for (final String animal:fileTXT.getFileData(rules)) {
            for (Object property:rules.getRules()) {
                if(!property.equals("file.URL") && !rules.getAnimalProperty((String)property).equals("")) {
                    isResult = isSearchAnimal(animal, rules.getAnimalProperty((String) property).split(","));
                    if(!isResult){
                        break;
                    }
                }
            }
            if(isResult){
                count++;
            }
        }
        return count;
    }

    private boolean isSearchAnimal(final String animal,final String[] parameterRules){
        boolean isResult = false;
        for (String parameterRule: parameterRules) {
            if (parameterRule.contains("!")) {
                parameterRule = parameterRule.replace("!", "");
                if (!animal.contains(parameterRule)) {
                    isResult = true;
                }
            }
            else if(parameterRule.equals("")){
                isResult = true;
            }
            else {
                if (animal.contains(parameterRule)) {
                    isResult = true;
                }
            }
        }
        return isResult;
    }
}