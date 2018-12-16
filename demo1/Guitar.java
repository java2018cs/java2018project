import java.util.ArrayList;

public class Guitar {
	private boolean[][] singleMeasure;
	private ArrayList<boolean[][]> measureList = new ArrayList<boolean[][]>();
	
	public void addMeasure() {
		singleMeasure = new boolean[15][16];
		measureList.add(singleMeasure);
	}
	
	public void deleteMeasure() {
		if (measureList.isEmpty())
			System.out.println("There is no measure!");
		else 
			measureList.remove(measureList.size()-1);
	}
	
	public void showMeasure() {
		for (boolean[][] ms : measureList) {
			for (boolean[] scale : ms) {
				for (boolean note : scale) {
					System.out.print(note + " ");
				}
				System.out.println();
			}
			System.out.println("\n");
		}
	}
	
}
