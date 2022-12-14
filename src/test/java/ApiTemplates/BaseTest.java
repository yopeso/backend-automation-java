package ApiTemplates;


import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;
import org.testng.annotations.BeforeTest;
import utils.Logger;


import java.util.function.Consumer;


public class BaseTest {
    @BeforeTest
    public void before(){
        Consumer<Description> descriptionConsumer = desc -> Logger.info("Assertions : "+desc.toString());
        Assertions.setDescriptionConsumer(descriptionConsumer);
    }
}
