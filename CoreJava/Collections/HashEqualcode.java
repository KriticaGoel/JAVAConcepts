package CoreJava.Collections;

import java.util.Objects;

public class HashEqualcode {
    private int x;
    private int y;

    public HashEqualcode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        // complete the code here
        if (this == obj)
            return true;
        else if (this == null || this.getClass() != obj.getClass())
            return false;
        HashEqualcode other = (HashEqualcode) obj;
        if (other.x == this.x)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        // complete the code here
        return Objects.hash(x);
    }

}
