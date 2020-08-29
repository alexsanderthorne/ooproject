import java.util.Objects;

public class Caixa {
    private double vendas = 0;
    private double saldo = 0;

    public Caixa() {
    }

    public Caixa(double vendas, double saldo) {
        this.vendas = vendas;
        this.saldo = saldo;
    }

    public double getVendas() {
        return this.vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Caixa vendas(double vendas) {
        this.vendas = vendas;
        return this;
    }

    public Caixa saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Caixa)) {
            return false;
        }
        Caixa caixa = (Caixa) o;
        return vendas == caixa.vendas && saldo == caixa.saldo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendas, saldo);
    }

    @Override
    public String toString() {
        return "{" +
            " vendas='" + getVendas() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }

  
}