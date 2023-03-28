package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "endereco_funcionario")
public class EnderecoFuncionario extends Endereco implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @OneToMany(mappedBy = "id_end")
    private Integer id;

}
