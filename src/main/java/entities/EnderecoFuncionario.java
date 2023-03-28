package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "endereco_funcionario")
public class EnderecoFuncionario extends Endereco {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id_end_func")
    private Integer id;

}
