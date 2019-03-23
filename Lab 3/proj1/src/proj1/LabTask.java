package proj1;

import java.util.Scanner;

public class LabTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String[] elements = {"beta", "chi", "alpha", "zeta", "nu", "mu"};
			System.out.println("How do you want to sort the string?");
			System.out.println("1 for Selection and 2 for Insertion");
			Scanner input = new Scanner(System.in);
			int blla = input.nextInt();
			if(blla == 1) {
				factor(elements,"Selection");
			}else if(blla == 2) {
				factor(elements,"Insertion");
			}
			
	}
	
	public static void printer(String elements[]) {
		for (int i = 0; i < elements.length; i++)
            System.out.println(elements[i]);
	}
	public static void factor(String elements[],String sortingTechnique) {
        // The factory -- creates non-recursive sorting algorithms
        SortFactory factory = new NonRecursive();
        
		factory.setFactory(sortingTechnique);
        
        // Get the sorting algorithm from the factory
        SortingAlgorithm algorithm = factory.getAlgorithm();
        
        // apply the algorithm
        algorithm.sort(elements);
        System.out.println("The result for "+sortingTechnique+" is:");
        printer(elements);
	}

}
