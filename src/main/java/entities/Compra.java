package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "compra", schema = "public")
public class Compra {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_atendimento")
    private Integer idAtendimento;
    @Basic
    @Column(name = "total")
    private Double total;

    public Integer getId() {
        return id;
    }

    public Integer getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Integer idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Compra that = (Compra) o;

        if (id != that.id) return false;
        if (idAtendimento != null ? !idAtendimento.equals(that.idAtendimento) : that.idAtendimento != null)
            return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idAtendimento != null ? idAtendimento.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
