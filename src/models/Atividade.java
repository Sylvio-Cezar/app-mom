package models;

public class Atividade {
    private String titulo;
    private String descricao;

    public Atividade() {

    }

    public void atividadesRecomendadas(int idade){
        if(idade == 3 || idade == 4){
            titulo = "Atividades Lúdicas";
            descricao = "Jogos e brincadeiras que visão desenvolver habilidades como \n" +
                    "Coordenção motora, Ritmo, equilibrio, além do desenvolvimento da linguagem ";

        }
        else if(idade == 5){
            titulo = "Modalidades esportivas";
            descricao = "Modalidades como natação, futebol e ballet favorecem um crescimento normal e saudavel para a criança,\n" +
                    "alem de desenvolver suas habilidades motoras";

        }
        else if(idade == 6){
            titulo = "Atividades de escrita e leitura";
            descricao = "Incentive-o a praticar a escrita de letras e palavras, utilizando lápis e papel. Além disso,\n" +
                    "leia livros infantis com ele, incentivando-o a identificar letras, palavras e compreender a história";

        }
        else if(idade == 7){
            titulo = "Matemática e raciocínio lógico";
            descricao = "Explore conceitos matemáticos como adição, subtração, multiplicação, divisão e resolução de problemas.\n" +
                    "Utilize jogos, quebra-cabeças e atividades práticas para tornar o aprendizado matemático mais divertido";

        }
        else if(idade == 8){
            titulo = "Educação física e esportes";
            descricao = "Proporcione atividades esportivas e de movimento, como jogos ao ar livre,\n" +
                    "esportes em equipe ou dança. Isso contribui para o desenvolvimento físico, habilidades motoras e trabalho em equipe";

        }
        else if(idade == 9){
            titulo = "Exploração da natureza";
            descricao = "Leve-o para explorar a natureza em trilhas, parques ou reservas naturais.\n" +
                    "Incentive-o a observar plantas, animais, ecossistemas e a desenvolver uma apreciação pela biodiversidade";

        }
        else if(idade == 10){
            titulo = "Aulas de idiomas";
            descricao = "Matricule-o em aulas de idiomas, como inglês, espanhol ou qualquer outro idioma de interesse.\n" +
                    "Isso ajuda a desenvolver habilidades de comunicação, amplia seu conhecimento cultural e abre portas para oportunidades futuras";

        }
        else if(idade == 11){
            titulo = "Música e instrumentos";
            descricao = " Incentive-a a explorar a música através do aprendizado de um instrumento, como\n" +
                    "teclado, violão ou bateria. Estimule sua criatividade ao compor suas próprias músicas ou participar de grupos musicais";

        }
        else if(idade == 12){
            titulo = "Clubes de interesse";
            descricao = "Incentive-a a participar de clubes ou grupos de interesse, como um clube de leitura, clube de ciências ou clube de astronomia.\n" +
                    "Isso permite que ela se envolva com outros jovens que compartilham dos mesmos interesses e promove a troca de conhecimentos";

        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}