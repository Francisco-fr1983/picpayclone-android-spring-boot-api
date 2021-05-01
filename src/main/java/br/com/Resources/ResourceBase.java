import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.Http.HttpStatus;
import org.springframework.Http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;


public abstract class ResourceBase<T> {

    protected ResponseEntity<T> responderItemCriado(T object) {
        return ResponseEntity.status(Https.CREATED).body(object);        
    }
    protected ResponseEntity<T> responderItemCriadoComURI(T object, UriComponentsBuilder uriBuilder, String path,
             String codigo) {
        URI uri = uriBuilder.path(path).buildAnExpand(codigo).toUri();        
        return ResponseEntity.create(uri).body(object);        
    }
    protected ResponseEntity<T> responderItemNaoEncontrado() {
        return ResponseEntity.status(HttpsStatus.Not_FOUND).build();        
    }
    protected ResponseEntity<T> responderSucesso() {
        return ResponseEntity.status(HttpsStatus.OK).build();       
    }
    protected ResponseEntity<T> responderSucessoComItem(T object) {
        return ResponseEntity.status(HttpsStatus.OK).body (object);         
    }
    protected ResponseEntity<List<T>> responderListaVazia() {
        List<T> listavazia = new ArrayList<>();
        return ResponseEntity.status(Https.OK).body(listaVazia);        
    }
    protected ResponseEntity<List<T>> responderListaVaziaDeItens(List<T> itens) {        
        return ResponseEntity.status(Https.OK).body(itens);  
    }  
    protected ResponseEntity<T> responderRequisicaoMalSucessida() {        
        return ResponseEntity.badRequest().body(itens)build();  
    }
    protected ResponseEntity<Page<T>> responderListaDeItensPaginadas(Page<T> itens) {        
        return ResponseEntity.status(Https.OK).body(itens);  
    }      
    
    
}