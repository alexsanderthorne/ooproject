import java.util.ArrayList;
import java.util.Objects;

public class Clientes extends Pessoas {

    private Endereco adress;
    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
    private ArrayList<Clientes> clientes = new ArrayList<Clientes>();
    private int quantidade_de_produtos_comprados;

    public Clientes(String nome, String cpf, String email, String telefone, Endereco adress,int quantidade_de_produtos_comprados) {
        super(nome, cpf, email, telefone);
        this.adress = adress;
        this.quantidade_de_produtos_comprados = quantidade_de_produtos_comprados;
    }

    public Clientes() {
    }

    public Clientes(Endereco adress, ArrayList<Endereco> enderecos, ArrayList<Clientes> clientes, int quantidade_de_produtos_comprados) {
        this.adress = adress;
        this.enderecos = enderecos;
        this.clientes = clientes;
        this.quantidade_de_produtos_comprados = quantidade_de_produtos_comprados;
    }

    public int getQuantidade_de_produtos_comprados() {
        return this.quantidade_de_produtos_comprados;
    }

    public void setQuantidade_de_produtos_comprados(int quantidade_de_produtos_comprados) {
        this.quantidade_de_produtos_comprados = quantidade_de_produtos_comprados;
    }

    public Clientes adress(Endereco adress) {
        this.adress = adress;
        return this;
    }

    public Clientes enderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public Clientes clientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
        return this;
    }

    public Clientes quantidade_de_produtos_comprados(int quantidade_de_produtos_comprados) {
        this.quantidade_de_produtos_comprados = quantidade_de_produtos_comprados;
        return this;
    }

    public Endereco getAdress() {
        return this.adress;
    }
    

    public void setAdress(Endereco adress) {
        this.adress = adress;
    }

    public ArrayList<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<Clientes> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }

    public void cadastrarCliente(Clientes c, Endereco adress, String nomeCliente, String cpf, String email,
            String telefone, String rua, String bairro, int numero, String cidade, String uf, String cep,
            String complemento) throws Exception {

        c.setCpf(cpf);
        c.setNome(nomeCliente);
        c.setEmail(email);
        c.setTelefone(telefone);
        adress.setRua(rua);
        adress.setBairro(bairro);
        adress.setNumero(numero);
        adress.setCidade(cidade);
        adress.setUF(uf);
        adress.setCep(cep);
        adress.setComplemento(complemento);

        clientes.add(new Clientes(nomeCliente, cpf, email, telefone, adress,quantidade_de_produtos_comprados));
        enderecos.add(new Endereco(rua, bairro, numero, cidade, uf, cep, complemento));

    }

    public void listarClientes() throws NullPointerException{

        try {

            for (int j = 0; j < clientes.size(); j++) {

                System.out.println(clientes.get(j).toString());

            }

        } catch (NullPointerException nullPointerException) {

            System.err.println(nullPointerException);
            System.out.println("Não há clientes cadastrados!");

        }

    }

    public void buscarCliente(String cpf) throws Exception {

        for (int j = 0; j < clientes.size(); j++) {

            // if (clientes.get(j).getCpf() != null) {

            if (clientes.get(j).getCpf().equals(cpf)) {

                System.out.println(clientes.get(j).toString());

                break;
            }

        }

        // } catch (Exception e) {

        // throw new Exception(e);
        // }

        // }else{

        // }

    }

    public void removerClientes(String cpf) {

        if (clientes.size() > 0) {

            for (int i = 0; i < clientes.size(); i++) {

                if (clientes.get(i).getCpf().equals(cpf)) {

                    clientes.remove(clientes.get(i));

                } else {

                    System.out.println("Cliente não encontrado!");
                }

            }

            System.out.println("Cliente apagado do banco de dados!");

        } else {

            System.out.println("Não possui clientes cadastrados!");

        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Clientes)) {
            return false;
        }
        Clientes clientes = (Clientes) o;
        return Objects.equals(adress, clientes.adress) && Objects.equals(enderecos, clientes.enderecos)
                && Objects.equals(clientes, clientes.clientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adress, enderecos, clientes);
    }

    @Override
    public String toString() {
        return "{" + "Dados pessoais :" + " nome='" + getNome() + "'" + ", cpf='" + getCpf() + "'" + ", email='"
                + getEmail() + "'" + ", telefone='" + getTelefone() + "'" + " Endereco: '" + getAdress() + "'" + "}";

    }
}