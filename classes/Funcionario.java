import java.util.Objects;

public class Funcionario extends Pessoas {

    private String id;

    public Funcionario() {

    }

    public Funcionario(String nome, String cpf, String email, String telefone, String id) {
        super(nome, cpf, email, telefone);
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Funcionario id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Funcionario)) {
            return false;
        }
        Funcionario funcionario = (Funcionario) o;
        return Objects.equals(id, funcionario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + "}";
    }

}