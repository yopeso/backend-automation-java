package ApiTemplates;


import io.qameta.allure.Allure;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;

import org.junit.jupiter.api.BeforeAll;
import utils.Logger;


import java.util.function.Consumer;


public class BaseTest {
    @BeforeAll
    public static void before(){
        Consumer<Description> descriptionConsumer = desc -> Logger.info("Assertions : "+desc.toString());
        Assertions.setDescriptionConsumer(descriptionConsumer);
    }
}
