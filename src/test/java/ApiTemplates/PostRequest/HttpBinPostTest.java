package ApiTemplates.PostRequest;


import ApiTemplates.BaseTest;
import ApiTemplates.PostRequest.model.HttpBinPostModel;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import routes.OpenHttpRoutes;

import java.util.HashMap;

public class HttpBinPostTest extends BaseTest {
    @Test
    public void doPostRequest() throws Exception {
        Service service = Service.init().queryParam("aa", "bb").post(OpenHttpRoutes.OPEN_HTTP_BIN_POST, new HashMap<>());
        HttpBinPostModel postModel = service.responseToPojo(HttpBinPostModel.class);


        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(postModel.getArgs().get("aa"))
                        .as("Post response have query param aa=bb")
                                .isEqualTo("bb");
    }
}
