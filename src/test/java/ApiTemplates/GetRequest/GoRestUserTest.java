package ApiTemplates.GetRequest;


import ApiTemplates.BaseTest;
import ApiTemplates.GetRequest.GetModel.GoRestUserModel;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import routes.GoRestRoutes;

import java.util.HashMap;

public class GoRestUserTest extends BaseTest {
    @Test
    public void getGoRestUsers() throws Exception {
        GoRestUserModel[] goRestUserModels=Service.init().get(GoRestRoutes.GO_REST_USERS, new HashMap<>()).responseToPojo(GoRestUserModel[].class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(goRestUserModels[0].getId())
                .as("First user id is 5434")
                .isEqualTo(3323);

        for (GoRestUserModel model: goRestUserModels
             ) {
            System.out.println(model);
            }
    }
}
