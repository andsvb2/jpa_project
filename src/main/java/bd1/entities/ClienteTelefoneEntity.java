package bd1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente_telefone", schema = "public", catalog = "bd1")
public class ClienteTelefoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_cliente")
    private Integer idCliente;
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

        ClienteTelefoneEntity that = (ClienteTelefoneEntity) o;

        if (id != that.id) return false;
        if (ddd != that.ddd) return false;
        if (telefone != that.telefone) return false;
        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + ddd;
        result = 31 * result + telefone;
        return result;
    }
}
