package exceptions;

import sun.security.pkcs.ParsingException;

import java.io.IOException;

/**
 * Created by Максим on 21.12.2016.
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException, IOException {
        try {
            int wrongpin = 0;
            Terminal terminal = new TerminalImpl(new TerminalServer());
            UserInterface.print("Вставьте карту");
            Account account = terminal.readCard();
            while (wrongpin < 3) {
                UserInterface.print("Введите пин-код");
                int pin = Integer.parseInt(UserInterface.read());
                int correctPin = account.getPin();
                if (pin == correctPin) {
                    UserInterface.print("Введите код необходимой операции: 1.Проверить баланс \n 2.Снять наличные \n 3.Внести наличные");
                    int operation = Integer.parseInt(UserInterface.read());
                    switch (operation) {
                        case 1:
                            UserInterface.print(String.valueOf(terminal.checkBalance(account)));
                            break;
                        case 2:
                            int sum = Integer.parseInt(UserInterface.read());
                            if (sum % 100 != 0)
                                throw new NonDiv100Sum();

                            break;
                        case 3:
                            UserInterface.print("Внесите наличные");
                            Thread.sleep(10000l);
                            terminal.addCash(account, terminal.countCash());
                            UserInterface.print("Средства успешно зачислены");
                            break;
                        default:
                            throw new ParsingException();
                    }
                    break;
                } else {
                    UserInterface.print("Неверный пин-код");
                    wrongpin++;

                }
            }

            account.avail = false;
            Thread.sleep(5000l);
            UserInterface.print("Аккаунт заблокирован на 5 сек");
        } catch (ParsingException e) {

            System.out.println("Неверный формат ввода");
            UserInterface.print("Вы неверно произвели послежний ввод");

        } catch (NonDiv100Sum nonDiv100Sum) {
            UserInterface.print("Сумма далжна быть кратна 100");
        }
    }
}