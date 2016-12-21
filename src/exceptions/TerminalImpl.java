package exceptions;

/**
 * Created by Максим on 21.12.2016.
 */
class TerminalImpl implements Terminal {

    private final TerminalServer server;

    TerminalImpl(TerminalServer server){
        this.server = server;
    }

    @Override
    public float checkBalance(Account account) {

        return server.checkBalance(account);
    }

    @Override
    public void addCash(Account account, int sum) {

        server.addBalance(account, sum);;
    }

    @Override
    public void getCash(Account account, int sum) {

    }

    @Override
    public Account readCard() {
        return new Account(1,2,true);
    }

    @Override
    public void giveCash(int sum) {

    }

    @Override
    public int countCash() {
        return 0;
    }

}