/*
 * Implementing insertion and selection sort
 * 	Both run in O(n2) time 
 */


public class SimpleSorting {

	public static int[] insertionSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int j=i-1;
			int val = arr[i];
			while(j>=0 && arr[j]> val && j>=0) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = val;
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] arr) {
		for(int i=0;i<arr.length -1; i++) {
			int min = arr[i];
			int index = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j] < min) {
					min= arr[j];
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		return arr;
	}
	
	public static int[] bubbleSort(int[] arr) {
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j< (arr.length - 1 - i) ;j++) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	public static int[] mergeSort(int[] arr, int left, int right) {
		
		if(left >= right) {
			int[] newArr = new int[1];
			newArr[0] = arr[left];
			return newArr;
		}
		
		int mid = (int) (left + right)/2;
		
		int[] leftArr = mergeSort(arr,left,mid);
		int[] rightArr = mergeSort(arr,mid+1,right);
		
		return partition(leftArr,rightArr);
		
	}
	
	
	
	
	
	public static int[] partition(int[] leftArr, int[] rightArr) {
		int[] outputArr = new int[leftArr.length + rightArr.length];
		int i=0,j=0,k=0;
		
		while(i<leftArr.length && j < rightArr.length) {
			if(leftArr[i]<rightArr[j]) {
				outputArr[k++] = leftArr[i++];
			} else {
				outputArr[k++] = rightArr[j++];
			}
		}
		
		if(i == leftArr.length) {
			while(j<rightArr.length) {
				outputArr[k++] = rightArr[j++];
			}
		} else {
			while(i<leftArr.length) {
				outputArr[k++] = leftArr[i++];
			}
		}
		
		return outputArr;
		
	}

	
	public static void quickSort(int[] arr, int l, int r) {
		
		if(l<r) {
			int pivot = partitionQuickSort(arr,l,r);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);
		}
		
		
	}
	
	public static int partitionQ(int[] arr, int l, int r) {
		int value = arr[l];
		int lower = l;
		int upper = r;
		
		while(lower < upper) {
			
			while(lower <= r && arr[lower] <= value)
				lower++;
			
			while(upper >= l && arr[upper] > value)
				upper--;
			
			int temp;
			temp = arr[lower];
			arr[lower] = arr[upper];
			arr[upper] = temp;
			
			
			
		}
		
		int temp = arr[upper];
		arr[upper] = arr[l];
		arr[l] = temp;
		
		return upper;
		
	}
	
	
	
	public static int partitionQuickSort(int arr[], int l, int r) {
		int pivotIndex = (int)(Math.random() % (r-l)) + l;
		// Exchange with end
		int temp = arr[pivotIndex];
		arr[pivotIndex] = arr[r];
		arr[r] = temp;
		
		// Run from left to right -1
		// if lesser than, then swap arr[i] and arr[k]
		int k=l;
		for(int i=l;i<r;i++) {
			if(arr[i]<=arr[r]) {
				int tempw = arr[k];
				arr[k] = arr[i];
				arr[i] = tempw;
				k++;
			}
		}
		
		temp = arr[k];
		arr[k] = arr[r];
		arr[r] = temp;
		return k;
	}
	

	public static void printArray(int[] arr) {
		for(int i: arr)
			System.out.print(i+" ");
		
		System.out.println();
	}
	
	public static int[] mergeSortedArray(int[] a, int[] b, int an, int bn) {
		if(a.length < an + bn) {
			return null;
		}
		
		int k = an + bn -1;
		an = an -1;
		bn = bn -1;
		while(an>=0 && bn >=0) {
			if(a[an] > b[bn]) {
				a[k--] = a[an--];
			} else {
				a[k--] = b[bn--];
			}
		}
		
		if(an == -1) {
			while(bn >= 0) {
				a[k--] = b[bn--];
			}
		} else {
			while(an >= 0) {
				a[k--] = a[an--];
			}
		}
		
		return a;
		
	}
	
	public static  int findPosition(int[] arr, int l, int r,int searchItem) {
		if(l==r) {
			if(arr[l] == searchItem) {
				return l;
			} else {
				return -1;
			}
		}
		
		int mid = (l+r)/2;
		if(arr[l] <= searchItem && searchItem <= arr[mid]) {
			return findPosition(arr, l, mid, searchItem);
		} else if(arr[mid+1] <= searchItem && searchItem <= arr[r]) {
			return findPosition(arr, mid+1, r, searchItem);
		} else if((arr[mid] >= searchItem && arr[l] > arr[r])) {
			return findPosition(arr, l, mid, searchItem); 
		} else {
	//	} else if(arr[mid+1] >=searchItem && arr[l]>arr[r]) {
			return findPosition(arr, mid+1, r, searchItem);
		}
		
	}
	
	public static int binarySearchEmptyString(String[] arrayOfWords, int left, int right,String searchWord) {
		
		if(left >= right) {
			if(arrayOfWords[left].equals(searchWord)) {
				return left;
				
			} else 
				return -1;
		}
		
		int mid = (int) ((left + right) /2);
		while(right > left && arrayOfWords[right].equals(""))
			right--;
		
		while(mid<right && arrayOfWords[mid].equals(""))
			mid++;
		
		if(searchWord.compareTo(arrayOfWords[mid]) == 0) {
			return mid;
		}
		
		
		if(searchWord.compareTo(arrayOfWords[mid]) > 0) {
			return binarySearchEmptyString(arrayOfWords, mid + 1, right,searchWord);
		} else if(searchWord.compareTo(arrayOfWords[mid]) < 0  || arrayOfWords[mid].equals(""))  {
			return binarySearchEmptyString(arrayOfWords, left, mid - 1,searchWord);
		} else {
			return mid;
		}
		
	
		
	}
	
	public static boolean doesElementExist(int[][] matrix, int searchElement,int m,int n) {
		int col = n;
		int row = 0;
		
		while(col >0 && row <= n) {
			if(matrix[col][row] == searchElement) {
				return true;
			}
			if(matrix[col][row] > searchElement) {
				col--;
			} else {
				row++;
			}
		}
		
		
		return false;
	}
	public static void main(String[] args) {
		//int arr[] = {4,3,7,1,0,11,24,5,3,2,66,78,100,-1,234};
		//printArray(mergeSort(arr, 0, arr.length -1));
		//quickSort(arr, 0, arr.length - 1);
		
		int a[] = {0, 4, 7,10,15,45,0,0,0,0};
		int b[] = {5,8,9,13};
		
		
		//printArray(mergeSortedArray(a,b,a.length - 4,b.length));
		
		int arr[] = {15,16,19,20,25,1,3,4,5,7,10,14};
		//String[] arrayOfWords = {"at","","","","","ball","bar","","","car","","","dad","",""};
		
		//System.out.println(binarySearchEmptyString(arrayOfWords,0,arrayOfWords.length - 1,"bar"));
		
		int arr1[][]= {{1,4,7},{2,5,8},{3,6,9}};
		
		System.out.println(doesElementExist(arr1, 0, 2, 2));
	}
	
	
	
}
