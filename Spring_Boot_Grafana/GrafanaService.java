import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GrafanaService {

    private final RestTemplate restTemplate;
    private final String grafanaBaseUrl;

    public GrafanaService(RestTemplate restTemplate, String grafanaBaseUrl) {
        this.restTemplate = restTemplate;
        this.grafanaBaseUrl = grafanaBaseUrl;
    }

    public void createDataSource(String jsonDataSourceConfig) {
        String url = grafanaBaseUrl + "/datasources";
        restTemplate.postForObject(url, jsonDataSourceConfig, String.class);
    }
}
