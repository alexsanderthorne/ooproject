import java.util.Objects;

public abstract class Pessoas {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public Pessoas() {
    }

    public Pessoas(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoas nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Pessoas cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Pessoas email(String email) {
        this.email = email;
        return this;
    }

    public Pessoas telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoas)) {
            return false;
        }
        Pessoas pessoas = (Pessoas) o;
        return Objects.equals(nome, pessoas.nome) && Objects.equals(cpf, pessoas.cpf)
                && Objects.equals(email, pessoas.email) && Objects.equals(telefone, pessoas.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, email, telefone);
    }

    @Override
    public String toString() {
        return "{" + " nome='" + getNome() + "'" + ", cpf='" + getCpf() + "'" + ", email='" + getEmail() + "'"
                + ", telefone='" + getTelefone() + "'" + "}";
    }
}