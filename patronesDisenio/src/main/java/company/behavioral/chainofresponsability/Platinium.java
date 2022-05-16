package company.behavioral.chainofresponsability;

public class Platinium implements ApproveLoanChain{

    private ApproveLoanChain next;

    @Override
    public void setNext(ApproveLoanChain loan) {
        next = loan;
    }

    @Override
    public ApproveLoanChain getNext() {
        return next;
    }

    @Override
    public void creditCardRequest(int totalLOEAN) {

        if ((totalLOEAN > 1000 && totalLOEAN <= 50000)) {
            System.out.println("Esta solicitud de tarjeta de credito la maneja la tarjeta Platinium");
        } else {
            next.creditCardRequest(totalLOEAN);
        }

    }
}
