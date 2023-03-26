package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "compra_detalhamento", schema = "public")
@IdClass(CompraDetalhamentoEntityPK.class)
public class CompraDetalhamentoEntity {
    @Basic
    @Column(name = "id")
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "compra_id")
    private int compraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "produto_id")
    private int produtoId;
    @Basic
    @Column(name = "quantidade")
    private short quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompraDetalhamentoEntity that = (CompraDetalhamentoEntity) o;

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
