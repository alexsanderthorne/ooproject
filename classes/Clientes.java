import java.util.ArrayList;
import java.util.Objects;

public class Clientes extends Pessoas {

    private ArrayList<Endereco> e;

    public Clientes(String nome, String cpf, String email, String telefone, ArrayList<Endereco> e) {
        super(nome, cpf, email, telefone);
        this.e = e;
    }

    public Clientes() {
    }

    public Clientes(ArrayList<Endereco> e) {
        this.e = e;
    }

    public ArrayList<Endereco> getE() {
        return this.e;
    }

    public void setE(ArrayList<Endereco> e) {
        this.e = e;
    }

    public Clientes e(ArrayList<Endereco> e) {
        this.e = e;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Clientes)) {
            return false;
        }
        Clientes clientes = (Clientes) o;
        return Objects.equals(e, clientes.e);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(e);
    }

    @Override
    public String toString() {
        return "{" + " nome='" + getNome() + "'" + ", cpf='" + getCpf() + "'" + ", email='" + getEmail() + "'"
                + ", telefone='" + getTelefone() + "'" + " e='" + getE() + "'" + "}";

    }
}