
import javax.persistence.cascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USUARIOS")
public class cartaocredito extends EntidadeBase {

    @Column(name = "CC_NUMERO", nullable = false)
    private String numero;

    @Enumerated(EnumType.String)
    @Column(name = "CC_BANDEIRA", nullable = false)
    private BanderiaCartao Bandeira;

    @Column(name = "CC_TOKEN")
    private String numeroToken;

    @ManyToOne(cascade = { cascadeType.MERGE})
    @JoinColumn(name = "CC_USUARIO_ID", nullable = false)
    private Usuario usuario;
    
}
