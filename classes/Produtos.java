import java.util.Objects;

public class Produtos {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produtos() {
    }

    public Produtos(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produtos codigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public Produtos nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Produtos preco(double preco) {
        this.preco = preco;
        return this;
    }

    public Produtos quantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produtos)) {
            return false;
        }
        Produtos produtos = (Produtos) o;
        return codigo == produtos.codigo && Objects.equals(nome, produtos.nome) && preco == produtos.preco
                && quantidade == produtos.quantidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, preco, quantidade);
    }

    @Override
    public String toString() {
        return "{" + " codigo='" + getCodigo() + "'" + ", nome='" + getNome() + "'" + ", preco='" + getPreco() + "'"
                + ", quantidade='" + getQuantidade() + "'" + "}";
    }

}