package bd1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario_telefone", schema = "public", catalog = "bd1")
public class FuncionarioTelefoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Basic
    @Column(name = "tipo")
    private Object tipo;
    @Basic
    @Column(name = "ddd")
    private int ddd;
    @Basic
    @Column(name = "telefone")
    private int telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuncionarioTelefoneEntity that = (FuncionarioTelefoneEntity) o;

        if (id != that.id) return false;
        if (ddd != that.ddd) return false;
        if (telefone != that.telefone) return false;
        if (idFuncionario != null ? !idFuncionario.equals(that.idFuncionario) : that.idFuncionario != null)
            return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idFuncionario != null ? idFuncionario.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + ddd;
        result = 31 * result + telefone;
        return result;
    }
}
