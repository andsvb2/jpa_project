package bd1.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "compra", schema = "public", catalog = "bd1")
public class CompraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_atendimento")
    private Integer idAtendimento;
    @Basic
    @Column(name = "total")
    private BigDecimal total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(Integer idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompraEntity that = (CompraEntity) o;

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
