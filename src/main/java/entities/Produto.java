package entities;

import enums.TipoProduto;
import enums.UnidadeMedida;
import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private int id;

    private String nome;

    private Double preco;
    @Column(name = "tipo_produto")
    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;

    @Column(name = "quantidade_unitaria")
    private float quantidadeUnitaria;

    @Column(name = "unidade_medida")
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
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

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto that = (Produto) o;

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
