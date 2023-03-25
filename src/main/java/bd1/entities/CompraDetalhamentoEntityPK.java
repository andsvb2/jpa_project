package bd1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class CompraDetalhamentoEntityPK implements Serializable {
    @Column(name = "compra_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compraId;
    @Column(name = "produto_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int produtoId;

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompraDetalhamentoEntityPK that = (CompraDetalhamentoEntityPK) o;

        if (compraId != that.compraId) return false;
        if (produtoId != that.produtoId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compraId;
        result = 31 * result + produtoId;
        return result;
    }
}
