import java.util.ArrayList;
import java.util.Objects;

public class Clientes extends Pessoas {

    private Endereco adress;
    private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
    private ArrayList<Clientes> clientes = new ArrayList<Clientes>();

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

        clientes.add(new Clientes(nomeCliente, cpf, email, telefone, adress));
        enderecos.add(new Endereco(rua, bairro, numero, cidade, uf, cep, complemento));

        if (c.getCpf() == null || c.getEmail() == null) {

            throw new Exception("Nenhum dos campos obrigatórios podem ficar vazios.");

        }
    }

    public void listarClientes() {

        if (clientes.size() > 0) {

            for (int j = 0; j < clientes.size(); j++) {

                System.out.println(clientes.get(j).toString());

            }

        } else {

            System.out.println("Não possui clientes cadastrados!");
        }

    }

    public void buscarCliente(String cpf) {

        if (clientes.size() > 0) {

            for (int j = 0; j < clientes.size(); j++) {

                if (clientes.get(j).getCpf().equals(cpf)) {

                    System.out.println(clientes.get(j).toString());

                    break;
                }

                if (clientes.get(j).getCpf() != cpf) {

                    System.out.println("Cliente não encontrado!");

                }
            }

        } else {

            System.out.println("Não possui clientes cadastrados!");
        }

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