package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic
    @Column(name = "debitos")
    private Double debitos;

//    @OneToOne
//    @JoinColumn(name = "funcionario_telefone_id")
//    private FuncionarioTelefone idTelefone;

    @OneToOne
    @JoinColumn(name = "id_end_cliente")
    private EnderecoCliente enderecoCliente;

    public Integer getId() {
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

    public Double getDebitos() {
        return debitos;
    }

//    public FuncionarioTelefone getIdTelefone() {
//        return idTelefone;
//    }

//    public void setIdTelefone(FuncionarioTelefone idTelefone) {
//        this.idTelefone = idTelefone;
//    }

    public void setDebitos(Double debitos) {
        this.debitos = debitos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnderecoCliente getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(EnderecoCliente enderecosCliente) {
        this.enderecoCliente = enderecosCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente that = (Cliente) o;

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(that.sobrenome) : that.sobrenome != null) return false;
        if (debitos != null ? !debitos.equals(that.debitos) : that.debitos != null) return false;
        if (enderecoCliente != null ? !enderecoCliente.equals(that.enderecoCliente) : that.enderecoCliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (debitos != null ? debitos.hashCode() : 0);
        result = 31 * result + (enderecoCliente != null ? enderecoCliente.hashCode() : 0);
        return result;
    }
}
