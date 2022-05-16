package company.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CuentaComposite implements CuentaComponent{

    private List<CuentaComponent> childCuentas;

    public CuentaComposite() {
        this.childCuentas = new ArrayList<>();
    }

    @Override
    public void showAccountName() {
        childCuentas.stream().forEach(cuentaComponent -> cuentaComponent.showAccountName());
    }

    @Override
    public Double getAmount() {
        return childCuentas.stream().mapToDouble(CuentaComponent::getAmount).sum();
    }

    public void addCuenta(CuentaComponent cuenta){
        childCuentas.add(cuenta);
    }

    public void removeCuenta(CuentaComponent cuenta){
        childCuentas.remove(cuenta);
    }

}
