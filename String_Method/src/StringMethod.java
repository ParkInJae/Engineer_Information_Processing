import java.util.Arrays;

public class StringMethod {
/*
    String_Method()  종류 
     char	charAt(int index)	특정 위치의 문자를 리턴합니다.
    boolean	equals(Object anObject)	두 문자열을 비교합니다.
    byte[]	getBytes()	byte[]로 리턴합니다.
    byte[]	getBytes(Charset charset)	주어진 문자셋으로 인코딩한 byte[]로 리턴합니다.
    int	indexOf(String str)	문자열 내에서 주어진 문자열의 위치를 리턴합니다.
    int	length()	총 문자의 수를 리턴합니다.
    String	replace(CharSequence target, CharSequence replacement)	target 부분을 replacement로 대치한 새로운 문자열을 리턴합니다.
    String	substring(int beginIndex)	beginIndex 위치에서 끝까지 잘라낸 새로운 문자열을 리턴합니다.
    String	substring(int beginIndex, int endIndex)	beginIndex 위치에서 endIndex 전까지 잘라낸 새로운 문자열을 리턴합니다.
    String	toLowerCase()	알파벳 소문자로 변환한 새로운 문자열을 리턴합니다.
    String	toUpperCase()	알파벳 대문자로 변환한 새로운 문자열을 리턴합니다.
    String	trim()	앞뒤 공백을 제거한 새로운 문자열을 리턴합니다.
    String	valueOf(int i)
    valueOf(double d)	기본 타입 값을 문자열로 리턴합니다.
 */

    public static void main(String[] args) throws Exception {

        String str = "2025-04-20 정보처리기사 시험 합격하고 싶어요";
        //replaceAll
        String RStr = str.replaceAll("합격하고 싶어요", "합격 기원!!!");
        System.out.println("str.length()적용 " + str.length());

        // concat() 적용
        String Cstr = str.concat("concat() 적용 ");
        System.out.println("str.concat()은 문자열을 합성합니다. "+ Cstr);

        // subString
        // 문자열을 자르며, 인덱스 번호를 넣어서 범위를 지정한다. 
        // 만약 파라미터를 한 개만 넣을 경우, 해당 인덱스부터 문자열의 마지막까지 자른다. 
        System.out.println("subString(11)적용 : "+ str.substring(11));
        System.out.println("subString(0,10)적용 : "+ str.substring(0,10));
        System.out.println();
        
        String StrBeforeTrim = "      "+str+"    ";
        System.out.println("trim()적용하기 전 공백이 존재하는 변수 : " + StrBeforeTrim);
        System.out.println("공백이 존재하는 문자열에 trim() 적용 " + StrBeforeTrim.trim());

        // replace, replaceAll

        String replaceStr = "apple banana apple";
        System.out.println(replaceStr.replace("apple", "orrange"));

        System.out.println(replaceStr.replaceAll("apple", "1"));
        
        // indexof >> 문자열에 .indexOf()를 적용 후 () 사이에 문자열을 넣고, 메소드를 실행 후 
        // ()안의 인자가 문자열에 존재하면 인덱스를 반환 
        // () 안에 존재하지 않는 경우 -1을 반환한다. 
        System.out.println(str.indexOf(1));

        // split() > () 안의 요소를 기준으로 문자열을 자른 후 배열로 반환 
        System.out.println("split() 적용 전 : "+ str);
        System.out.println();

        String [] arrStr = str.split(" "); // 기존 문자열에 split을 적용 후 배열에 담음 

        System.out.println("split 적용 후 : "+ Arrays.toString(arrStr)); // 출력시 배열을 스트링으로 변환하는 toString() 적용
        




    }



}
