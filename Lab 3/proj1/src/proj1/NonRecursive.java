package proj1;

public class NonRecursive extends SortFactory{
	SortingAlgorithm a;
	@Override
	public SortingAlgorithm getAlgorithm() {
		// TODO Auto-generated method stub
		if(this.algorithm == "Selection") {
			return new SelectionSort();
		}else {
			return new InsertionSort();
		}
	}
}
