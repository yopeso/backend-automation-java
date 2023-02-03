package ApiTemplates.GetRequest;



import ApiTemplates.BaseTest;
import ApiTemplates.GetRequest.GetModel.RegresInUser;
import ApiTemplates.GetRequest.GetModel.RegresInUsers;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import routes.RegresInRoutes;

import java.util.HashMap;

public class RegresInUsersTest extends BaseTest {
    @Test
    public void getAllUsers() throws Exception {
        RegresInUsers regresInUsers=Service.init().get(RegresInRoutes.REGRESS_IN_API_ALL_USERS, new HashMap<>()).responseToPojo(RegresInUsers.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(regresInUsers.getPage())
                .as("Current page should be 1, and we have %d",regresInUsers.getPage())
                .isEqualTo(1);
        Assertions.assertThat(regresInUsers.getData().get(0).getId())
                .as("Id for first user should be 1, and we have %d",regresInUsers.getData().get(0).getId())
                .isEqualTo(1);
    }

    @Test
    public void getUser() throws Exception {
        RegresInUser regresInUser=Service.init().get(RegresInRoutes.REGRESS_IN_API_USER, new HashMap<>()).responseToPojo(RegresInUser.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(regresInUser.getData().getId())
                .as("Id for user number 2 should be 2, and we have %d",regresInUser.getData().getId())
                .isEqualTo(2);

    }
}
