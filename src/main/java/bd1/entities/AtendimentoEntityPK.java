package bd1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Timestamp;

public class AtendimentoEntityPK implements Serializable {
    @Column(name = "data_atendimento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Timestamp dataAtendimento;
    @Column(name = "cliente_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;
    @Column(name = "funcionario_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int funcionarioId;

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

        AtendimentoEntityPK that = (AtendimentoEntityPK) o;

        if (clienteId != that.clienteId) return false;
        if (funcionarioId != that.funcionarioId) return false;
        if (dataAtendimento != null ? !dataAtendimento.equals(that.dataAtendimento) : that.dataAtendimento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataAtendimento != null ? dataAtendimento.hashCode() : 0;
        result = 31 * result + clienteId;
        result = 31 * result + funcionarioId;
        return result;
    }
}
