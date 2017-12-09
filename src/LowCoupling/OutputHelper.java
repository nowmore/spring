package LowCoupling;

public class OutputHelper {
    IOutputGenerator out;

    public void generateOutput(){
        out.generateOutput();
    }

    public void setOut(IOutputGenerator out) {
        this.out = out;
    }
}
