package Actions;

import WebElements.SimpleElements;
import org.openqa.selenium.WebDriver;

public class SimpleActions {
    //trb sa legam cele 2 clase,trb facut o instanta aici
    private SimpleElements elements;

//trb facut si aici un constructor pt clasa action
    public SimpleActions(WebDriver driver) {
        this.elements= new SimpleElements(driver);
    }

    //metoda ce extrage textul apeland metoda de dincolo
    public String getLoginText(){
        return elements.loginText().getText();


    }

    }

