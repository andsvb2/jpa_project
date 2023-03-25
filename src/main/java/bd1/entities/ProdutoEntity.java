package bd1.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto", schema = "public", catalog = "bd1")
public class ProdutoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "preco")
    private BigDecimal preco;
    @Basic
    @Column(name = "tipo")
    private Object tipo;
    @Basic
    @Column(name = "quantidade_unitaria")
    private float quantidadeUnitaria;
    @Basic
    @Column(name = "unidade_medida")
    private Object unidadeMedida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public float getQuantidadeUnitaria() {
        return quantidadeUnitaria;
    }

    public void setQuantidadeUnitaria(float quantidadeUnitaria) {
        this.quantidadeUnitaria = quantidadeUnitaria;
    }

    public Object getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(Object unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoEntity that = (ProdutoEntity) o;

        if (id != that.id) return false;
        if (Float.compare(that.quantidadeUnitaria, quantidadeUnitaria) != 0) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (preco != null ? !preco.equals(that.preco) : that.preco != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (unidadeMedida != null ? !unidadeMedida.equals(that.unidadeMedida) : that.unidadeMedida != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (quantidadeUnitaria != +0.0f ? Float.floatToIntBits(quantidadeUnitaria) : 0);
        result = 31 * result + (unidadeMedida != null ? unidadeMedida.hashCode() : 0);
        return result;
    }
}
