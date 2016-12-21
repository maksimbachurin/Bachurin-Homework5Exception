package exceptions;

/**
 * Created by Максим on 21.12.2016.
 */
/**
 Здесь содержится данные счёта, считанные с карты. Они не несут информации о состоянии счета и не позволяют опрерировать им, а только содержат необходимую информация для запроса серверу
 на получение необходимых данных по счету и совершения операций с ним.
 Также содержит информацию о пинкоде
 */
public class Account {
    int accountNumber;
    int pin;
    boolean avail;

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public int getPin(){
        return this.pin;
    }

    public boolean isAvail(){
        return this.avail;
    }

    Account(int accountNumber, int pin, boolean avail)
    {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.avail = true;
    }
}
