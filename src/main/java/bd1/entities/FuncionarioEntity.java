package bd1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario", schema = "public", catalog = "bd1")
public class FuncionarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "tipo")
    private String tipo;
    @Basic
    @Column(name = "id_end")
    private Integer idEnd;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuncionarioEntity that = (FuncionarioEntity) o;

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(that.sobrenome) : that.sobrenome != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (idEnd != null ? !idEnd.equals(that.idEnd) : that.idEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (idEnd != null ? idEnd.hashCode() : 0);
        return result;
    }
}
