package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class GetStep {

    @Dado("que todas as massas estão iniciadas")
    public void queTodasAsMassasEstãoIniciadas() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Dado("que acesso a rota {string} para o projeto {string}")
    public void queAcessoARotaParaOProjeto(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Quando("realizo a requisição pelo {string} informando mes e ano o status deve ser {string}")
    public void realizoARequisiçãoPeloInformandoMesEAnoOStatusDeveSer(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Então("é retornado para a requisição o status code {string}")
    public void éRetornadoParaARequisiçãoOStatusCode(String string) {
        // Write code here that turns the phrase above into concrete actions
    }




}
