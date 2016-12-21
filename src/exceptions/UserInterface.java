package exceptions;

import java.io.*;

/**
 * Created by Максим on 21.12.2016.
 */
public class UserInterface {

    private static OutputStream outputStream; //куда выводить сообщения
    private static InputStream inputStream; //откуда считываем информацию
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

    public static void print(String mes) throws IOException {
        outputStream.write(mes.getBytes());
    }

    public static String read() throws IOException {
        return reader.readLine();
    }
}
