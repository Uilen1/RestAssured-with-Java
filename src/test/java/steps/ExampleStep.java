package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.ValidatableResponse;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ExampleStep {

/**
 * É criado os metódos de validações das APIS conforme descrito na feature
 */

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

    @Quando("busco a lista de usuários por queryParam")
    public void buscoAListaDeUsuáriosPorPathParam() throws Exception {
        try {
            validatableResponse = given()
                    .queryParam("page",2)
                    .when()
                    .get(rota)
                    .then()
                    .log().all()
            ;

        } catch (Exception e){
            throw new Exception("Não foi possível acessar a lista de usuários por pathParam");
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

    @E("valido as informações para o usuário {string} com o id {string}")
    public void validoAsInformaçõesParaOUsuárioComOId(String user, String id) throws Exception{
        try {
            validatableResponse
                    .body("data.findAll{it.id == "+id+"}.first_name",is(Arrays.asList(user)));

        }catch (Exception e){
            throw new Exception("Não foi possível encontrar o usuário " + user );
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
