package entities;

import enums.TipoTelefone;
import jakarta.persistence.*;

@Entity
@Table(name = "funcionario_telefone")
public class FuncionarioTelefone {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TipoTelefone tipo;
    @Basic
    @Column(name = "ddd")
    private Integer ddd;
    @Basic
    @Column(name = "telefone")
    private Integer telefone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FuncionarioTelefone that = (FuncionarioTelefone) o;

        if (id != that.id) return false;
        if (ddd != that.ddd) return false;
        if (telefone != that.telefone) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + ddd;
        result = 31 * result + telefone;
        return result;
    }
}
