import java.util.Objects;

public class Clientes extends Pessoas {

    private Endereco adress;

    public Clientes(String nome, String cpf, String email, String telefone, Endereco adress) {
        super(nome, cpf, email, telefone);
        this.adress = adress;
    }

    public Clientes() {
    }

    public Endereco getAdress() {
        return this.adress;
    }

    public void setAdress(Endereco adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Clientes)) {
            return false;
        }
        Clientes clientes = (Clientes) o;
        return Objects.equals(adress, clientes.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(adress);
    }

    @Override
    public String toString() {
        return "{" + "Dados pessoais :" + " nome='" + getNome() + "'" + ", cpf='" + getCpf() + "'" + ", email='"
                + getEmail() + "'" + ", telefone='" + getTelefone() + "'" + " Endereco: '" + getAdress() + "'" + "}";

    }
}