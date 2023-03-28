package entities;

import enums.TipoFuncionario;
import jakarta.persistence.*;

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

    @ManyToOne
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

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(that.sobrenome) : that.sobrenome != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (endereco != null ? !endereco.equals(that.endereco) : that.endereco != null) return false;

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
