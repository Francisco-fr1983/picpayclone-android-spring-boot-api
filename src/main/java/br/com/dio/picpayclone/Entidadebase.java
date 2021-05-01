
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadeBase {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id; 
    }
}
