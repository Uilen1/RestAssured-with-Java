package steps;

import bean.ExampleBean;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.Dado;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseStep {
    protected static ExampleBean getExampleBean = new ExampleBean();

    @Dado("que todas as massas estão iniciadas")
    public void queTodasAsMassasEstãoIniciadas() throws Exception{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File users = new File("src/main/resources/users.json");
            getExampleBean = objectMapper.readValue(users, new TypeReference<ExampleBean>(){});
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Não foi possível iniciar as massas");
        }
    }
}
