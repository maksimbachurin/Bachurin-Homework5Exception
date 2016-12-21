package exceptions;

/**
 * Created by Максим on 21.12.2016.
 */
public interface Terminal {

    float checkBalance(Account account); //проверяет баланс
    void addCash(Account account, int sum); //внести наличные
    void getCash(Account account, int sum); //получить наличные
    Account readCard(); //считывание данных с карты
    void giveCash(int sum); //выдача наличных
    int countCash(); //метод считает внесенные в терминал наличные

}