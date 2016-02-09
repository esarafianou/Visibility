
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class InputData {
	
	private int n;
	Building[] ArrayOfBuildings;
	int[] AllXArray;
	


	public int[] getAllXArray() {
		return AllXArray;
	}


	public void setAllXArray(int[] allXArray) {
		AllXArray = allXArray;
	}


	public Building[] getArrayOfBuildings() {
		return ArrayOfBuildings;
	}


	public void setArrayOfBuildings(Building[] arrayOfBuildings) {
		ArrayOfBuildings = arrayOfBuildings;
	}


public InputData(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            String[] a = line.split(" ");
            n = Integer.parseInt(a[0]);
            ArrayOfBuildings = new Building[n];
            AllXArray=new int[2*n+1];
            int j=-1;
	for (int i = 0; i < n; i++) {
			line = in.readLine();
		        a = line.split(" ");
	                int Xsw = Integer.parseInt(a[0]);
	                int Ysw = Integer.parseInt(a[1]);
	                int Xne = Integer.parseInt(a[2]);
	                int Yne = Integer.parseInt(a[3]);
	                float Height = Float.parseFloat(a[4]);


			Building nd = new Building(Xsw,Ysw,Xne,Yne,Height);
			ArrayOfBuildings[i]=nd;
			AllXArray[++j]=Xsw;
			AllXArray[++j]=Xne;	
			

	}

            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }





	public int getN(){
        return n;
    }

}
