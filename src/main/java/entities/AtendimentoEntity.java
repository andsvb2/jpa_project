package entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "atendimento", schema = "public")
@IdClass(AtendimentoEntityPK.class)
public class AtendimentoEntity {
    @Basic
    @Column(name = "id")
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "data_atendimento")
    private Timestamp dataAtendimento;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cliente_id")
    private int clienteId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "funcionario_id")
    private int funcionarioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Timestamp dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtendimentoEntity that = (AtendimentoEntity) o;

        if (id != that.id) return false;
        if (clienteId != that.clienteId) return false;
        if (funcionarioId != that.funcionarioId) return false;
        if (dataAtendimento != null ? !dataAtendimento.equals(that.dataAtendimento) : that.dataAtendimento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dataAtendimento != null ? dataAtendimento.hashCode() : 0);
        result = 31 * result + clienteId;
        result = 31 * result + funcionarioId;
        return result;
    }
}
