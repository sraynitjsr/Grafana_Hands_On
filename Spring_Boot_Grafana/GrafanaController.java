import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrafanaController {

    private final GrafanaService grafanaService;

    public GrafanaController(GrafanaService grafanaService) {
        this.grafanaService = grafanaService;
    }

    @PostMapping("/create-datasource")
    public void createDataSource(@RequestBody String jsonDataSourceConfig) {
        grafanaService.createDataSource(jsonDataSourceConfig);
    }
}
