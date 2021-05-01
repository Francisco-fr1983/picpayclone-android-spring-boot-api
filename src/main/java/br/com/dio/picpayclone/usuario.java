
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USUARIOS")

public class usuario extends EntidadeBase {

    @Column(name = "USU_LOGIN", nullable = false)
    private String login;

    @Column(name = "USU_SENHA", nullable = false)
    private String senha;

    @Column(name = "USU_EMAIL", nullable = false)
    private String email;

    @Column(name = "USU_NOME_COMPLETO", nullable = false)
    private String nomeCompleto;

    @Column(name = "USU_CPF", nullable = false)
    private String cpf;

    @Column(name = "USU_DATA_NASCIMENTO", nullable = false)
    private LocalData dataNascimento;

    @Column(name = "USU_NUMERO_TELEFONE", nullable = false)
    private String numeroTelefone;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = cascadeType.MERGE, orphanRemoval = true)
    private List<CartaoCredito> cartaoCredito;

    @Column(name = "USU_SALDO", nullable = false)
    private Double saldo;

    @Column(name = "USU_ATIVO", nullable = false)
    private Boolean ativo;


    
}
