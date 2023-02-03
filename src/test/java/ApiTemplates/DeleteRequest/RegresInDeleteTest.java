package ApiTemplates.DeleteRequest;


import ApiTemplates.BaseTest;
import api.service.Service;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import routes.RegresInRoutes;

import java.util.HashMap;
@Epic("Backend API templates")
@Feature("Delete HTTP method")
public class RegresInDeleteTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Test Description : Verify deleting user works properly")
    @Story("Delete Request")
    public void deleteUser() throws Exception {
            Response response=Service.init().delete(RegresInRoutes.REGRESS_IN_API_USER, new HashMap<>()).getResponse();
            Assertions.assertThat(response.getStatusCode())
                    .as("Response status code for delete request is 204,and we have %d ", response.getStatusCode())
                    .isEqualTo(204);
        }
    }
