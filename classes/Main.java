import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;



public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String nomeCliente, cpf, email, telefone, rua, bairro, cidade, uf, cep, complemento;
        double soma = 0, saldo = 0;
        int numeroCasa = 0;

        ArrayList<Caixa> caixa = new ArrayList<Caixa>();
        ArrayList<Estoque> estoque = new ArrayList<Estoque>();
        ArrayList<Produtos> p = new ArrayList<Produtos>();
        ArrayList<Clientes> c = new ArrayList<Clientes>();
        ArrayList<Endereco> endereco = new ArrayList<Endereco>();
        Clientes newCliente = new Clientes();

        Gerente gerente = new Gerente();

        boolean yes = true;
        boolean continua = true;

        while (yes) {

            System.out.println("\nStudio EncanARTE" + "\n1. Realizar Vendas " + "\n2. Cadastrar Clientes "

                    + "\n3. Acessar Estoque " + "\n4. Cancelar Venda" + "\n5. Listar Clientes"
                    + "\n6. Buscar cliente(pelo cpf)" + "\n7. Aquisição de Produtos" + "\n8. Excluir Clientes"
                    + "\n9. Ver Saldo Caixa" + "\n0. Sair");

            int op = scan.nextInt();

            switch (op) {

                case 1:

                    if (p.isEmpty()) {

                        System.out.println("Precisa ter o produto cadastrado");
                        break;

                    }

                    try {

                        System.out.println("Digite o código do produto: ");
                        int codigo1 = scan.nextInt();

                        for (Produtos p1 : p) {

                            if (p1.getCodigo() == codigo1) {

                                int i = (p1.getQuantidade() - 1);
                                p1.setQuantidade(i);
                                soma += 1;
                                saldo += p1.getPreco();

                                caixa.add(new Caixa(soma, saldo));
                                System.out.println("Venda realizada com sucesso: " + p1.getNome());

                            }
                        }

                    } catch (NullPointerException nullPointerException) {

                        System.err.println("\nException : %s\n" + nullPointerException);
                        scan.nextLine();
                        System.out.println("Operação inválida");
                    }

                    System.out.println("Relacionar 1 sim 2 não ?");
                    int opcao = scan.nextInt();

                    if (opcao == 1) {

                        System.out.println("Digite o cpf: ");
                        String cpf_cli = scan.next();

                        if (newCliente.getCpf().equals(cpf_cli)) {

                            int q = (newCliente.getQuantidade_de_produtos_comprados() + 1);
                            newCliente.setQuantidade_de_produtos_comprados(q);
                            System.out.println("compra relacionada ao cliente" + newCliente.getNome());

                        }

                    } else {

                        System.out.println("Opção inválido;");
                    }

                    break;

                case 2:

                    do {

                        try {

                            Clientes client = new Clientes();

                            System.out.println("Cadastrar clientes");
                            System.out.println("Dados pessoais");
                            System.out.println("*** *** ***");
                            System.out.println("Digite o nome do cliente : ");
                            nomeCliente = scan.next();
                            System.out.println("Digite o cpf do cliente : ");
                            cpf = scan.next();
                            System.out.println("Digite o email do cliente : ");
                            email = scan.next();
                            System.out.println("Digite o telefone do cliente : ");
                            telefone = scan.next();
                            System.out.println("*** *** ***");
                            System.out.println("Endereço");
                            Endereco adress = new Endereco();

                            System.out.println("Digite o nome da rua : ");
                            rua = scan.next();
                            // e.setRua(rua);
                            System.out.println("Digite o nome do bairro : ");
                            bairro = scan.next();
                            System.out.println("Digite o número da residencia : ");
                            numeroCasa = scan.nextInt();

                            System.out.println("Digite a cidade : ");
                            cidade = scan.next();
                            System.out.println("Digite o estado : ");
                            uf = scan.next();
                            System.out.println("Digite o cep : ");
                            cep = scan.next();
                            System.out.println("Digite o complemento : ");
                            complemento = scan.next();

                            newCliente.cadastrarCliente(client, adress, nomeCliente, cpf, email, telefone, rua, bairro,
                                    numeroCasa, cidade, uf, cep, complemento);

                            System.out.println("Cliente cadastrado com sucesso!");

                            continua = false;

                        } catch (InputMismatchException inputMismatchException) {

                            System.err.println("\nException : %s\n" + inputMismatchException);
                            scan.nextLine();
                            System.out.println("Digite apenas números inteiros para o n° da casa");

                        }

                    } while (continua);

                    break;

                case 3:
                    // Acesso ao estoque
                    System.out.println("Digite o usuário: ");
                    String login = scan.next();
                    System.out.println("Digite a senha: ");
                    String senha = scan.next();

                    if (gerente.getLOGIN().equals(login) & gerente.getSENHA().equals(senha)) {
                        System.out
                                .println("Acessar estoque: 1-Ver todos os produtos 2-pesquisar por código do produto");

                        int o = scan.nextInt();
                        if (o == 1) {
                            System.out.println(estoque.toString());

                        } else if (o == 2) {
                            System.out.println("Digite o Código");
                            int testar = scan.nextInt();
                            for (Produtos pro : p) {
                                if (pro.getCodigo() == testar) {
                                    System.out.println("Está na lista");
                                    System.out.println(pro.toString());
                                } else if (pro.getQuantidade() == 0) {
                                    System.out.println("Operação inválida");
                                }

                            }
                        }

                    } else {
                        System.out.println("Login ou senha inválidos");
                    }

                    break;
                case 4:

                    System.out.println("Digite o código: ");
                    int cod4 = scan.nextInt();
                    for (Produtos produtos4 : p) {
                        if (produtos4.getCodigo() == cod4) {
                            int i = (produtos4.getQuantidade() + 1);
                            produtos4.setQuantidade(i);
                            soma -= 1;
                            saldo -= produtos4.getPreco();

                            caixa.add(new Caixa(soma, saldo));
                            System.out.println("Saldo atual: " + caixa.get(caixa.size() - 1));
                            break;
                        } else if (cod4 != produtos4.getCodigo()) {
                            System.out.println("Operação inválida !");
                            break;

                        }

                    }
                    if (p.isEmpty()) {
                        System.out.println("Precisa cadastrar um produto(Fazer Aquisição). ");

                    }
                    break;

                case 5:

                    newCliente.listarClientes();

                    break;

                case 6:

                    System.out.println("Digite o numero do cpf o qual deseja consultar : ");
                    cpf = scan.next();
                    newCliente.buscarCliente(cpf);

                    break;

                case 7:
                    System.out.println(" Aquisição de produtos" + "\nDigite o código do produto");
                    int cod = scan.nextInt();
                    System.out.println("Nome do produto:");
                    String nome = scan.next();
                    System.out.println("Preço do produto:");
                    double preco = scan.nextDouble();
                    System.out.println("Quantidade de produtos:");
                    int quantidade = scan.nextInt();
                    p.add(new Produtos(cod, nome, preco, quantidade));
                    estoque.add(new Estoque(p));
                    System.out.println("Compra efetuada com sucesso!");
                    break;
                case 8:

                    System.out.println("Digite o cpf do cliente : ");
                    cpf = scan.next();
                    newCliente.removerClientes(cpf);

                    break;

                case 9:

                    if (caixa.isEmpty()) {
                        System.out.println("Seu saldo está zerado, precisa realizar vendas");
                        break;

                    } else {
                        System.out.println("Total de vendas e saldo: " + caixa.get(caixa.size() - 1));

                    }

                    break;
                case 0:
                    System.out.println("Saiu!");
                    yes = false;
                default:
                    break;
            }

        }

        scan.close();

    }
}