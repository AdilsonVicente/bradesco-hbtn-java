public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        System.out.printf("Procurando o nome: \"%s\"\n", nome);
        int begin = 0;
        int end = nomes.length - 1;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            System.out.println("Passando pelo indice: "+middle);
            if (nome == nomes[middle]) {
                System.out.printf("Nome %s encontrado na posição %d\n", nome, middle);
                encontrado = true;
                break;
            } else if (nome.charAt(0) > nomes[middle].charAt(0)) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (!encontrado)
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
    }
}
