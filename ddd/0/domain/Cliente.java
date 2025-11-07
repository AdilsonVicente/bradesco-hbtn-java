package domain;


public class Cliente {


    private final String id;
    private final String nome;


    public Cliente(final String id, final String nome) {
        this.id = id;
        this.nome = nome;
    }


    public String getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

}