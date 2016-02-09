import java.util.Comparator;

public class YswComparator implements Comparator <Building>  {
	
	@Override
	public int compare(Building o1, Building o2) {
		if(o1.getYsw() < o2.getYsw()){
            return -1;
        } else {
            return 1;
        }
    }

}
