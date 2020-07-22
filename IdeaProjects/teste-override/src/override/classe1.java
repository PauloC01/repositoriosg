package override;

public class classe1 {
private double saldo = 10;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public void VerificaSaldo(){
        System.out.println("Valor do saldo R$"+ getSaldo());


    }
}