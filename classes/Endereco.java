import java.util.Objects;

public class Endereco {

    private String rua;
    private String bairro;
    private int numero;
    private String cidade;
    private String UF;
    private String cep;
    private String complemento;

    public Endereco() {
    }

    public Endereco(String rua, String bairro, int numero, String cidade, String UF, String cep, String complemento) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.UF = UF;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return this.UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco rua(String rua) {
        this.rua = rua;
        return this;
    }

    public Endereco bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public Endereco numero(int numero) {
        this.numero = numero;
        return this;
    }

    public Endereco cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public Endereco UF(String UF) {
        this.UF = UF;
        return this;
    }

    public Endereco cep(String cep) {
        this.cep = cep;
        return this;
    }

    public Endereco complemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) o;
        return Objects.equals(rua, endereco.rua) && Objects.equals(bairro, endereco.bairro) && numero == endereco.numero
                && Objects.equals(cidade, endereco.cidade) && Objects.equals(UF, endereco.UF)
                && Objects.equals(cep, endereco.cep) && Objects.equals(complemento, endereco.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, bairro, numero, cidade, UF, cep, complemento);
    }

    @Override
    public String toString() {
        return "{" + " rua='" + getRua() + "'" + ", bairro='" + getBairro() + "'" + ", numero='" + getNumero() + "'"
                + ", cidade='" + getCidade() + "'" + ", UF='" + getUF() + "'" + ", cep='" + getCep() + "'"
                + ", complemento='" + getComplemento() + "'" + "}";
    }

}