package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente_endereco", schema = "public")
public class ClienteEndereco {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cep")
    private String cep;
    @Basic
    @Column(name = "bairro")
    private String bairro;
    @Basic
    @Column(name = "logradouro")
    private String logradouro;
    @Basic
    @Column(name = "numero")
    private String numero;
    @Basic
    @Column(name = "complemento")
    private String complemento;

    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEndereco that = (ClienteEndereco) o;

        if (id != that.id) return false;
        if (cep != null ? !cep.equals(that.cep) : that.cep != null) return false;
        if (bairro != null ? !bairro.equals(that.bairro) : that.bairro != null) return false;
        if (logradouro != null ? !logradouro.equals(that.logradouro) : that.logradouro != null) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        if (complemento != null ? !complemento.equals(that.complemento) : that.complemento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (logradouro != null ? logradouro.hashCode() : 0);
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (complemento != null ? complemento.hashCode() : 0);
        return result;
    }
}
