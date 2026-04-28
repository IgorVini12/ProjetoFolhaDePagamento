package view;

import javax.swing.*; 

public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> menuPrincipal());
    }

    public static void menuPrincipal() {
        JFrame tela = new JFrame("Menu Principal");
        tela.setSize(300, 200);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        JButton incluir = new JButton("Incluir Funcionário");
        JButton listar = new JButton("Listar Funcionários");
        JButton folha = new JButton("Folha de Pagamento");
        JButton excluir = new JButton("Excluir Funcionário"); //coloquei esse botao pra caso precise tirar alguem da lista

        painel.add(incluir);
        painel.add(listar);
        painel.add(folha);
        painel.add(excluir);

        tela.add(painel);
        tela.setVisible(true);

        // BOTÃO INCLUIR
        incluir.addActionListener(e -> {
            tela.setVisible(false); // esconde menu
            telaIncluir();
        });

        // BOTÃO LISTAR
        listar.addActionListener(e -> {
            tela.setVisible(false);
            telaListar();
        });

        // BOTÃO FOLHA
        folha.addActionListener(e -> {
            tela.setVisible(false);
            telaFolha();
        });

        // BOTÃO EXCLUIR
        excluir.addActionListener(e -> {
            tela.setVisible(false);
            telaExcluir();
        });
    }

    /*================= Telas chamadas pelos botões ========================*/
      //Ps: Igor
    public static void telaIncluir() {
        JFrame tela = new JFrame("Incluir Funcionário");
        tela.setSize(300, 200);
        //isso vai fechar tudo quando sai
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // isso centralizar 
        tela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.add(new JLabel("Aqui você incluirá funcionários."));

        // Botão Voltar
        JButton voltar = new JButton("Voltar ao Menu");
        voltar.addActionListener(e -> {
            tela.setVisible(false);
            menuPrincipal();
        });
        painel.add(voltar);

        tela.add(painel);
        tela.setVisible(true);
    }

    public static void telaListar() {
        JFrame tela = new JFrame("Listar Funcionários");
        tela.setSize(300, 200);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.add(new JLabel("Aqui você listará os funcionários."));

        JButton voltar = new JButton("Voltar ao Menu");
        voltar.addActionListener(e -> {
            tela.setVisible(false);
            menuPrincipal();
        });
        painel.add(voltar);

        tela.add(painel);
        tela.setVisible(true);
    }

    public static void telaFolha() {
        JFrame tela = new JFrame("Folha de Pagamento");
        tela.setSize(300, 200);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.add(new JLabel("Aqui você verá a folha de pagamento."));

        JButton voltar = new JButton("Voltar ao Menu");
        voltar.addActionListener(e -> {
            tela.setVisible(false);
            menuPrincipal();
        });
        painel.add(voltar);

        tela.add(painel);
        tela.setVisible(true);
    }

    public static void telaExcluir() {
        JFrame tela = new JFrame("Excluir Funcionário");
        tela.setSize(300, 200);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.add(new JLabel("Aqui você excluirá funcionários."));

        JButton voltar = new JButton("Voltar ao Menu");
        voltar.addActionListener(e -> {
            tela.setVisible(false);
            menuPrincipal();
        });
        painel.add(voltar);

        tela.add(painel);
        tela.setVisible(true);
    }
}
