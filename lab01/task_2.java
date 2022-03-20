import java.util.*;
class task_2{
	public static void main(String[] args) {
		int n = args.length;
		int[] arr = new int[n];	
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(args[i]);
		}
		Arrays.sort(arr);
		System.out.println(arr[n-1] +  " " + arr[n-2]);
	}
}
