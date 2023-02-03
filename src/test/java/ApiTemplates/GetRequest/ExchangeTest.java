package ApiTemplates.GetRequest;



import ApiTemplates.BaseTest;
import ApiTemplates.GetRequest.GetModel.ExchangeModel;
import api.service.Service;
import com.skynet.testrail.hooks.TestrailPublisher;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import routes.OpenEnAirRoutes;

import java.util.HashMap;

@TestrailPublisher
@Epic("Backend API templates")
@Feature("Get HTTP method")
public class ExchangeTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Get EUR Exchange")
    @Story("Get Request")
    @DisplayName("1563813 - This is my first test")

    public void getEURExchange() throws Exception {
        Service service=Service.init().get(OpenEnAirRoutes.OPEN_ER_AIR_EUR, new HashMap<>());
        ExchangeModel exchangeModel=service.responseToPojo(ExchangeModel.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
      Assertions.assertThat(exchangeModel.getRates().get("EUR"))
            .as("Exchange model EUR rate for EUR should be 1,and we have %s ", exchangeModel.getRates().get("EUR"))
            .isEqualTo("1");
        }


    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Get USD Exchange")
    @Story("Get Request")
    @DisplayName ("1563812 - This is my first test")
    public void getUSDExchange() throws Exception {
        ExchangeModel exchangeModel=Service.init().get(OpenEnAirRoutes.OPEN_ER_AIR_USD, new HashMap<>()).responseToPojo(ExchangeModel.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(exchangeModel.getRates().get("USD"))
                .as("Exchange model USD rate for USD should be 1,and we have %s ", exchangeModel.getRates().get("USD"))
                .isEqualTo("1");
    }
    }
