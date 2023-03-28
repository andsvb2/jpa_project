package entities;

import enums.TipoFuncionario;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "funcionario")
public class Funcionario {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    private String nome;

    private String sobrenome;

    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_end_func")
    private EnderecoFuncionario endereco;

    public void setId(Integer id) {
        this.id = id;
    }

    public EnderecoFuncionario getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoFuncionario endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(sobrenome, that.sobrenome)) return false;
        if (!Objects.equals(tipo, that.tipo)) return false;
        if (!Objects.equals(endereco, that.endereco)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }
}
