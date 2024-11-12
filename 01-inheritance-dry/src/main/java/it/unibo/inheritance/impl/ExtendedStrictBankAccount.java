package it.unibo.inheritance.impl;

public class ExtendedStrictBankAccount extends SimpleBankAccount {
    private static final double TRANSACTION_FEE = 0.1;

    public ExtendedStrictBankAccount(final int id, final double balance) {
        super(id, balance);
    }

    @Override
    public withdraw(final int id, final double amount) {
        if(isWithdrawAllowed(amount))
        super.withdraw(id, amount);
    }

    @Override
    public void chargeManagementFees(final int id){
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
        if (checkUser(id) && isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() -= feeAmount);
            resetTransactions(getTransactionsCount());
        }
    }

    @Override
    public void withdrawFromATM(final int id, final double amount){
        if(isWithdrawAllowed(amount + ATM_TRANSACTION_FEE)){
            super.withdrawFromATM(id, amount);
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return balance >= amount;
    }
    

}


