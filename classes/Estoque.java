import java.util.ArrayList;
import java.util.Objects;

public class Estoque {

    private ArrayList<Produtos> produtos = new ArrayList<Produtos>();

    public Estoque() {
    }

    public Estoque(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Produtos> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public Estoque produtos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estoque)) {
            return false;
        }
        Estoque estoque = (Estoque) o;
        return Objects.equals(produtos, estoque.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(produtos);
    }

    @Override
    public String toString() {
        return "{" + " produtos='" + getProdutos() + "'" + "}";
    }

}