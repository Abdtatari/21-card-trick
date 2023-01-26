import java.util.Iterator;

public class card {
    private String value;
    private char type;
    public card() {
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  value + " " + type ;
    }

}
