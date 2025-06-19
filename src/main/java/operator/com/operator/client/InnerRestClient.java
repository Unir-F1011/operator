package operator.com.operator.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;
import operator.com.operator.models.dto.ItemsDto;

public interface InnerRestClient {
    ResponseEntity<Void> postRequest(@NonNull ItemsDto item, URI url);
    
    ResponseEntity<Void> deleteRequest(URI url);
    
    ResponseEntity<Void> patchRequest(@NonNull ItemsDto itemsDto, URI url);

}

@Service
@RequiredArgsConstructor
class RestClient implements InnerRestClient {

    private final RestTemplate client = new RestTemplate();

    @Override
    public ResponseEntity<Void> postRequest(@NonNull ItemsDto item, URI url) {
        try {
            return this.client.postForEntity(url, item, Void.class);
        }catch (RestClientException e) {
            throw new RuntimeException("Connection error ",e);
        }
        
    }

    @Override
    public ResponseEntity<Void> patchRequest(@NonNull ItemsDto itemsDto, URI url) {
        try {
            
            HttpEntity<ItemsDto> entity = new HttpEntity<>(itemsDto);
            return client.exchange(url, HttpMethod.PATCH, entity, Void.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Connection error", e);
        }

    }

    @Override
    public ResponseEntity<Void> deleteRequest(URI url) {
        try {
            return client.exchange(url, HttpMethod.DELETE, null, Void.class);
        } catch (RestClientException e) {
            throw new RuntimeException("Connection error", e);
        }

    }
}