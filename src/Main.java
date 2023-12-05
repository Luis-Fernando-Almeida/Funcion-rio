import java.util.ArrayList;
import java.util.List;

// Arquivo para prática de alguns conceitos, o projeto está no outros arquivos


public class Main {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>();

        list.add("Lucas");
        list.add("Luis");
        list.add("Cesar");
        list.add("Gustavo");
        list.add(2, "Marco");

        System.out.println(list.size());

        for (String x : list){
            System.out.println(x);
        }

        System.out.println("------------");
        list.removeIf(x -> x.charAt(0) == 'C');

        for (String x : list){
            System.out.println(x);
        }
        System.out.println("------------");
        System.out.println("Index of Cesar " + list.indexOf("Cesar"));
        System.out.println("Index of Luis " + list.indexOf("Luis"));
        System.out.println("------------");
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'M').toList();
        for (String x : result){
            System.out.println(x);
        }
        System.out.println("------------");
        String name = list.stream().filter(x -> x.charAt(0) == 'L').findFirst().orElse(null);
        System.out.println(name);
    }
}