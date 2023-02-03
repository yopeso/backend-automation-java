package ApiTemplates.PutRequest;

import ApiTemplates.BaseTest;
import ApiTemplates.PutRequest.model.HttpBinPutModel;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import routes.OpenHttpRoutes;

import java.util.HashMap;

public class HttpBinPutTest extends BaseTest {
    @Test
    public void doPutRequest() throws Exception {
        Service service = Service.init().queryParam("aa", "bb");
        service.put(OpenHttpRoutes.OPEN_HTTP_BIN_PUT, new HashMap<>());
        HttpBinPutModel putModel = service.responseToPojo(HttpBinPutModel.class);


        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(putModel.getArgs().get("aa"))
                .as("Put response have query param aa=bb")
                .isEqualTo("bb");
    }
}
