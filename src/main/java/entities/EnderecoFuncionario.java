package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco_funcionario")
public class EnderecoFuncionario extends Endereco {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id_end_func")
    private Integer id;

}
