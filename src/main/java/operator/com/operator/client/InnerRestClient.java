package operator.com.operator.client;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import operator.com.operator.models.dto.ItemsDto;

public interface InnerRestClient {
    ResponseEntity<Void> doRequest(HttpMethod method, URI url, ItemsDto body);

}

@Service
@RequiredArgsConstructor
class RestClient implements InnerRestClient {

    private final RestTemplate client = new RestTemplate();

    @Override
    public ResponseEntity<Void> doRequest(HttpMethod method, URI url, ItemsDto body) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<ItemsDto> requestEntity = new HttpEntity<>(body, headers);

            return this.client.exchange(
                    url,
                    method,
                    requestEntity,
                    Void.class);

        } catch (RestClientException e) {
            System.out.printf("\nOutput: {} {} {}\n", method, url, body);
            throw new RuntimeException(String.format("Connection error during"), e);
        }
    }
}