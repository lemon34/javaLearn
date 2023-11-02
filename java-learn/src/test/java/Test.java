/**
 * @author fuhailong
 * @Description TODO fhl
 * @Date 2023/8/26 16:20
 **/
public class Test {

    public static void main(String[] args) {

        String s = "a#b#";
        String[] strings = s.split("#");
        String[] strings1 = s.split("#", -1);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println("==================");
        for (String s1 : strings1) {
            System.out.println(s1);
        }
        System.out.println("=================");
    }
}
