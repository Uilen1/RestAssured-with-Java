package core;

import io.restassured.http.ContentType;

public interface Constants {
     /*Configurações de alguns comportamentos básicos para o restAssured*/

    String APP_BASE_URL = "https://reqres.in/";
    String APP_BASE_PATH = "api/";
    Integer APP_PORT = 443;
    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 10000L;

}
