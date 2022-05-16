package company.behavioral.chainofresponsability;

public interface ApproveLoanChain {
    void setNext(ApproveLoanChain loan);
    ApproveLoanChain getNext();
    void creditCardRequest(int totalLOEAN);

}
