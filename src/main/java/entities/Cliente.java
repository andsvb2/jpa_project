package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic
    @Column(name = "debitos")
    private Double debitos;

    @Basic
    @Column(name = "id_telefone")
    private Integer idTelefone;

    @OneToMany
    @Column(name = "enderecos_cliente")
    private List<EnderecoCliente> enderecosCliente;

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

    public Double getDebitos() {
        return debitos;
    }

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public void setDebitos(Double debitos) {
        this.debitos = debitos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EnderecoCliente> getEnderecosCliente() {
        return enderecosCliente;
    }

    public void setEnderecosCliente(List<EnderecoCliente> enderecosCliente) {
        this.enderecosCliente = enderecosCliente;
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
        if (enderecosCliente != null ? !enderecosCliente.equals(that.enderecosCliente) : that.enderecosCliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (debitos != null ? debitos.hashCode() : 0);
        result = 31 * result + (enderecosCliente != null ? enderecosCliente.hashCode() : 0);
        return result;
    }
}
