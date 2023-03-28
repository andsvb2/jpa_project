package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco_cliente")
public class EnderecoCliente extends Endereco {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id_end_cliente")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_enderecos_cliente")
    private Integer id;

}
