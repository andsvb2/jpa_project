package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "compra_detalhamento", schema = "public")
@IdClass(CompraDetalhamentoEntityPK.class)
public class CompraDetalhamento {
    @Basic
    @Column(name = "id")
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "compra_id")
    private Integer compraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "produto_id")
    private Integer produtoId;
    @Basic
    @Column(name = "quantidade")
    private Integer quantidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompraDetalhamento that = (CompraDetalhamento) o;

        if (id != that.id) return false;
        if (compraId != that.compraId) return false;
        if (produtoId != that.produtoId) return false;
        if (quantidade != that.quantidade) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + compraId;
        result = 31 * result + produtoId;
        result = 31 * result + (int) quantidade;
        return result;
    }
}
