public class URLEncodedExample {
    public static void main(String[] args) {

        String deviceIdMacro = "testing";
        if(deviceIdMacro.charAt(0) == '$') {
            deviceIdMacro = deviceIdMacro.substring(1);
        }
        System.out.println(deviceIdMacro);

    }
}
