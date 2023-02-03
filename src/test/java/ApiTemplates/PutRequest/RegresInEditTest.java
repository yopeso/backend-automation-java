package ApiTemplates.PutRequest;

import ApiTemplates.BaseTest;
import ApiTemplates.PutRequest.model.RegresInEditModel;
import api.service.Service;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import routes.RegresInRoutes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class RegresInEditTest extends BaseTest {
    @Test
    public void editUser() throws Exception {
        Service service=Service.init();
        Response response=service.put(RegresInRoutes.REGRESS_IN_API_USER, new HashMap<>()).getResponse();
        RegresInEditModel regresInEditModel=service.responseToPojo(RegresInEditModel.class);

        Assertions.assertThat(response.getStatusCode())
                .as("Response status code for request is 200,and we have %d ", response.getStatusCode())
                .isEqualTo(200);
        String today=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Assertions.assertThat(regresInEditModel.getUpdatedAt())
                .as("Put response should have today date in response")
                .contains(today);
    }
}
