package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ExampleStep {

    protected ValidatableResponse validatableResponse;
    protected String rota;
    protected BaseStep baseStep = new BaseStep();

    @Dado("que acesso a rota {string}")
    public void queAcessoARota(String url) throws Exception {
        try {
            rota = url;

        } catch (Exception e){
            throw new Exception("Não foi possível acessar a rota");
        }
    }

    @Quando("busco a lista de usuários na rota")
    public void buscoAListaDeUsuáriosNaRota() throws Exception {
        try {
            validatableResponse = given()
                    .when()
                    .get(rota)
                    .then()
                    .log().all()
            ;

        } catch (Exception e){
            throw new Exception("Não foi possível acessar a lista de usuários");
        }
    }

    @Quando("insiro um usuário")
    public void insiroUmUsuário() throws Exception {
        try {
            validatableResponse = given()
                        .body(baseStep.getExampleBean)
                    .when()
                        .post(rota)
                    .then()
                        .log().all()
                    ;

        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Não foi possível inserir o usuário");
        }
    }


    @Então("é retornado para a requisição o status code {string}")
    public void éRetornadoParaARequisiçãoOStatusCode(String statusCode) throws Exception {
        try {
            validatableResponse.statusCode(Integer.parseInt(statusCode));

        } catch (Exception e){
            throw new Exception("Não foi retornado o status code: " + statusCode);
        }
    }
}
